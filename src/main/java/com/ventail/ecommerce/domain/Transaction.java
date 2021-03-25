package com.ventail.ecommerce.domain;

import com.ventail.ecommerce.domain.entity.TransactionEntity;
import com.ventail.ecommerce.domain.entity.TransactionProductEntity;
import com.ventail.ecommerce.domain.enumeration.TransactionStatusEnum;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private Long transactionId;
    private List<TransactionItem> items;
    private Double total;
    private TransactionStatusEnum status;

    public Transaction() {
    }

    public Transaction(TransactionEntity transactionEntity, List<TransactionProductEntity> transactionProductEntityList) {
        this.transactionId = transactionEntity.getTransactionId();
        List<TransactionItem> transactionItems = new ArrayList<>();
        for (TransactionProductEntity transactionProductEntity: transactionProductEntityList) {
            TransactionItem transactionItem = new TransactionItem(transactionProductEntity);
            transactionItems.add(transactionItem);
        }
        this.items = transactionItems;
        this.total = transactionEntity.getTotal();
        this.status = transactionEntity.getStatus();
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public List<TransactionItem> getItems() {
        return items;
    }

    public void setItems(List<TransactionItem> items) {
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
