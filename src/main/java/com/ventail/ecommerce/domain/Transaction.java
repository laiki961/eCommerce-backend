package com.ventail.ecommerce.domain;

import com.ventail.ecommerce.domain.entity.TransactionEntity;
import com.ventail.ecommerce.domain.entity.TransactionProductEntity;
import com.ventail.ecommerce.domain.enumeration.TransactionStatusEnum;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private Long transactionId;
    private List<TransactionProduct> items;
    private Double total;
    private TransactionStatusEnum status;

    public Transaction() {
    }

    public Transaction(TransactionEntity transactionEntity, List<TransactionProductEntity> transactionProductEntityList) {
        this.transactionId = transactionEntity.getTransactionId();
        List<TransactionProduct> transactionProducts = new ArrayList<>();
        for (TransactionProductEntity transactionProductEntity: transactionProductEntityList) {
            TransactionProduct transactionProduct = new TransactionProduct(transactionProductEntity);
            transactionProducts.add(transactionProduct);
        }
        this.items = transactionProducts;
        this.total = transactionEntity.getTotal();
        this.status = transactionEntity.getStatus();
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public List<TransactionProduct> getItems() {
        return items;
    }

    public void setItems(List<TransactionProduct> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public TransactionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", items=" + items +
                ", total=" + total +
                ", status=" + status +
                '}';
    }
}
