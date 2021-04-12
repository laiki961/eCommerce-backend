package com.ventail.ecommerce.service.impl;

import com.ventail.ecommerce.domain.*;
import com.ventail.ecommerce.domain.entity.ProductEntity;
import com.ventail.ecommerce.domain.entity.TransactionEntity;
import com.ventail.ecommerce.domain.entity.TransactionProductEntity;
import com.ventail.ecommerce.domain.enumeration.TransactionStatusEnum;
import com.ventail.ecommerce.exception.ValidationException;
import com.ventail.ecommerce.repository.TransactionProductRepository;
import com.ventail.ecommerce.repository.TransactionRepository;
import com.ventail.ecommerce.service.ProductService;
import com.ventail.ecommerce.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private ProductService productService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionProductRepository transactionProductRepository;

    Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Override
    public Transaction getTransaction(Long transactionId) {
        TransactionEntity transactionEntity = transactionRepository.findFirstByTransactionId(transactionId);
        logger.debug("[getTransaction] transactionRepository"+ transactionEntity);
        return new Transaction(transactionEntity, transactionEntity.getTransactionProducts());
    }

    @Override
    public Transaction createTransaction(List<CheckoutItem> checkoutItems){
        //Convert List<CheckoutItem> to List<Long>
        List<Long> productIds = new ArrayList<>();
        //It loops and get each CheckoutItem in the list on by one
        //for (CheckoutItem item: checkoutItems){ ... }
        for(int i=0; i<checkoutItems.size(); i++){
            productIds.add(checkoutItems.get(i).getProductId());
        }

        //ProductDO -> TransactionDO
        List<ProductEntity> products = productService.getProductEntityByIds(productIds);
        // Calculate total
        double totalPrice = 0;

        TransactionEntity transactionEntity = new TransactionEntity();
        //loop products and accumulate total price
        for(ProductEntity item: products){
            for(CheckoutItem checkoutItem: checkoutItems){
                if(item.getProductId().equals(checkoutItem.getProductId())) {
                    totalPrice += checkoutItem.getQuantity() * item.getPrice();
                }
            }
        }
        transactionEntity.setTotal(totalPrice);
        transactionEntity.setStatus(TransactionStatusEnum.initiated);
        transactionEntity = transactionRepository.save(transactionEntity);

        logger.debug("[createTransaction], transactionRepository "+ transactionEntity);

        //save the specific transaction purchased products
        // if purchased 10 items -> have 10 TransactionProudctId
        List<TransactionProductEntity> transactionProductEntityList = new ArrayList<>();

        logger.debug("Input from user: " + checkoutItems);
        Integer quantity = null;
        for (ProductEntity productEntity: products) {
            for (CheckoutItem checkoutItem : checkoutItems) {
                if (checkoutItem.getProductId().equals(productEntity.getProductId())) {
                    quantity = checkoutItem.getQuantity();
                    logger.debug("quantity: "+ quantity.toString());
                }
            }
            if(quantity == null){
                throw new ValidationException();
            }
            TransactionProductEntity transactionProductEntity = new TransactionProductEntity(productEntity, transactionEntity, quantity);
            transactionProductRepository.save(transactionProductEntity);
            transactionProductEntityList.add(transactionProductEntity);
            logger.debug("[createTransaction], transactionProductRepository: "+  transactionProductEntity);
        }

        //Create TransactionDO
        return new Transaction(transactionEntity, transactionProductEntityList);

    }

    @Override
    public Transaction completeTransaction(Long transactionId, BillingInformation billingInformation){
        TransactionEntity transactionEntity = transactionRepository.findFirstByTransactionId(transactionId);
        if(transactionEntity == null){
            // Error
            throw new ValidationException("Transaction ID not found");
        }
        transactionEntity.setStatus(TransactionStatusEnum.success);
        transactionEntity.setFirstName(billingInformation.getFirstName());
        transactionEntity.setLastName(billingInformation.getLastName());
        transactionEntity.setEmail(billingInformation.getEmail());
        transactionEntity.setAddressLine1(billingInformation.getBillingAddressLine1());
        transactionEntity.setAddressLine2(billingInformation.getBillingAddressLine2());
        transactionEntity = transactionRepository.save(transactionEntity);

        return new Transaction(transactionEntity, transactionEntity.getTransactionProducts());
    }


}
