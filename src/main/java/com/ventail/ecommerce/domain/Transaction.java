package com.ventail.ecommerce.domain;

import com.ventail.ecommerce.domain.enumeration.TransactionStatusEnum;

import java.util.List;

public class Transaction {
    private Long transactionId;
    private List<TransactionItems> items;
    private Double total;
    private TransactionStatusEnum status;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public List<TransactionItems> getItems() {
        return items;
    }

    public void setItems(List<TransactionItems> items) {
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
