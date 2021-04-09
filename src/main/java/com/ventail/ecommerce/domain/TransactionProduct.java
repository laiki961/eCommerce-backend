package com.ventail.ecommerce.domain;

import com.ventail.ecommerce.domain.entity.TransactionProductEntity;

import java.util.ArrayList;
import java.util.List;

public class TransactionProduct {
    private Product details;
    private Integer quantity;
    private Double subtotal;

    public TransactionProduct() {
    }

    public TransactionProduct(TransactionProductEntity transactionProductEntity) {
            this.details = new Product(transactionProductEntity.getProduct());
            this.quantity = transactionProductEntity.getQuantity();
            this.subtotal = transactionProductEntity.getSubtotal();
    }

    public Product getDetails() {
        return details;
    }

    public void setDetails(Product details) {
        this.details = details;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "TransactionItems{" +
                "details=" + details +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                '}';
    }
}

