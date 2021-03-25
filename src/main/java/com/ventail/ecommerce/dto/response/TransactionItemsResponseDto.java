package com.ventail.ecommerce.dto.response;

import com.ventail.ecommerce.domain.TransactionItem;

public class TransactionItemsResponseDto {
    private ProductResponseDto details;
    private Integer quantity;
    private Double subtotal;

    public TransactionItemsResponseDto(TransactionItem transactionItem) {
        this.details = new ProductResponseDto(transactionItem.getDetails()); //transactionItem.getDetails() <-- is Product
        this.subtotal = transactionItem.getSubtotal();
        this.quantity = transactionItem.getQuantity();
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
