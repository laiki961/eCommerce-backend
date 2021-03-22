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
        TransactionEntity entity = transactionRepository.findFirstByTransactionId(transactionId);
        return toTransaction(entity, entity.getTransactionProducts());
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
        //loop products and accumulate total price
        for(ProductEntity item: products){
            totalPrice += item.getPrice();
        }
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setTotal(totalPrice);
        transactionEntity.setStatus(TransactionStatusEnum.initiated);

        transactionEntity = transactionRepository.save(transactionEntity);

        //save the specific transaction purchased products
        // if purchased 10 items -> have 10 TransactionProudctId
        List<TransactionProductEntity> transactionProductEntityList = new ArrayList<>();

        logger.debug("Input from user: " + checkoutItems);
        Integer quantity = null;
        for (ProductEntity productEntity: products) {
            for (CheckoutItem checkoutItem : checkoutItems) {
                logger.debug("101: "+productEntity.getProductId()+","+checkoutItem.getProductId());
                if (checkoutItem.getProductId().equals(productEntity.getProductId())) {
                    logger.debug(String.valueOf(checkoutItem.getProductId()));
                    logger.debug(String.valueOf(productEntity.getProductId()));
                    logger.debug(String.valueOf(checkoutItem.getQuantity()));
                    quantity = checkoutItem.getQuantity();
                }
            }
            if(quantity == null){
                throw new ValidationException();
            }
            TransactionProductEntity transactionProductEntity = new TransactionProductEntity(productEntity, transactionEntity, quantity);
            transactionProductRepository.save(transactionProductEntity);
            transactionProductEntityList.add(transactionProductEntity);
        }

        //Create TransactionDO
        return toTransaction(transactionEntity, transactionProductEntityList);

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

        return toTransaction(transactionEntity, transactionEntity.getTransactionProducts());
    }

    private Transaction toTransaction(TransactionEntity transactionEntity, List<TransactionProductEntity> transactionProductEntityList){
        List<TransactionItem> transactionItems = new ArrayList<>();
        for (TransactionProductEntity transactionProductEntity: transactionProductEntityList) {
            TransactionItem transactionItem = new TransactionItem();
            transactionItem.setDetails(new Product(transactionProductEntity.getProduct()));
            transactionItem.setQuantity(transactionProductEntity.getQuantity());
            transactionItem.setSubtotal(transactionProductEntity.getSubtotal());
            transactionItems.add(transactionItem);
        }

        Transaction transaction = new Transaction();
        transaction.setTransactionId(transactionEntity.getTransactionId());
        transaction.setItems(transactionItems);
        transaction.setTotal(transactionEntity.getTotal());
        transaction.setStatus(transactionEntity.getStatus());

        return transaction;
    }

}
