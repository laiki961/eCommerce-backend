package com.ventail.ecommerce.service.impl;

import com.ventail.ecommerce.domain.*;
import com.ventail.ecommerce.domain.entity.ProductEntity;
import com.ventail.ecommerce.domain.entity.TransactionEntity;
import com.ventail.ecommerce.domain.entity.TransactionProductEntity;
import com.ventail.ecommerce.domain.enumeration.TransactionStatusEnum;
import com.ventail.ecommerce.exception.ValidationException;
import com.ventail.ecommerce.repository.ProductRepository;
import com.ventail.ecommerce.repository.TransactionProductRepository;
import com.ventail.ecommerce.repository.TransactionRepository;
import com.ventail.ecommerce.service.ProductService;
import com.ventail.ecommerce.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private ProductService productService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionProductRepository transactionProductRepository;


    public Transaction createTransaction(List<CheckoutItem> checkoutItems, BillingInformation billingInformation){
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
        transactionEntity.setFirstName(billingInformation.getFirstName());
        transactionEntity.setLastName(billingInformation.getLastName());
        transactionEntity.setEmail(billingInformation.getEmail());
        transactionEntity.setAddressLine1(billingInformation.getBillingAddressLine1());
        transactionEntity.setAddressLine2(billingInformation.getBillingAddressLine2());
        transactionEntity = transactionRepository.save(transactionEntity);

        //save the specific transaction purchased products
        // if purchased 10 items -> have 10 TransactionProudctId
        List<TransactionProductEntity> transactionProductEntityList = new ArrayList<>();
        for (ProductEntity productEntity: products) {
            TransactionProductEntity transactionProductEntity = new TransactionProductEntity(productEntity, transactionEntity);
            transactionProductRepository.save(transactionProductEntity);
            transactionProductEntityList.add(transactionProductEntity);
        }

        //Create TransactionDO
        return toTransaction(transactionEntity, transactionProductEntityList);

    }

    public Transaction completeTransaction(Long transactionId){
        TransactionEntity transactionEntity = transactionRepository.findFirstByTransactionId(transactionId);
        if(transactionEntity == null){
            // Error
            throw new ValidationException("Transaction ID not found");
        }
        transactionEntity.setStatus(TransactionStatusEnum.success);
        transactionEntity = transactionRepository.save(transactionEntity);

        return toTransaction(transactionEntity, transactionEntity.getTransactionProductEntityList());
    }

    private Transaction toTransaction(TransactionEntity transactionEntity, List<TransactionProductEntity> transactionProductEntityList){
        List<TransactionItems> transactionItems = new ArrayList<>();
        for (TransactionProductEntity transactionProductEntity: transactionProductEntityList) {
            TransactionItems transactionItem = new TransactionItems();
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
