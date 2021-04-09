package com.ventail.ecommerce.domain.dto.response;

import com.ventail.ecommerce.domain.TransactionProduct;

public class TransactionItemsResponseDto {
    private ProductResponseDto details;
    private Integer quantity;
    private Double subtotal;

    public TransactionItemsResponseDto(TransactionProduct transactionProduct) {
        this.details = new ProductResponseDto(transactionProduct.getDetails()); //transactionItem.getDetails() <-- is Product
        this.subtotal = transactionProduct.getSubtotal();
        this.quantity = transactionProduct.getQuantity();
    }

    public ProductResponseDto getDetails() {
        return details;
    }

    public void setDetails(ProductResponseDto details) {
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
        return "TransactionItemsResponseDto{" +
                "details=" + details +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                '}';
    }
}
