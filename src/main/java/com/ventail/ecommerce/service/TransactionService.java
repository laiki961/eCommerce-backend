package com.ventail.ecommerce.service;

import com.ventail.ecommerce.domain.BillingInformation;
import com.ventail.ecommerce.domain.CheckoutItem;
import com.ventail.ecommerce.domain.Transaction;
import com.ventail.ecommerce.domain.entity.TransactionEntity;
import com.ventail.ecommerce.domain.entity.TransactionProductEntity;

import java.util.List;

public interface TransactionService {
    Transaction getTransaction(Long transactionId);
    Transaction createTransaction(List<CheckoutItem> checkoutItems);
    Transaction completeTransaction(Long transactionId, BillingInformation billingInformation);
}
