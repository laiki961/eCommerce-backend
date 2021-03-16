package com.ventail.ecommerce.domain;

public class TransactionItems {
    private Product details;
    private Integer quantity;
    private Double subtotal;

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

