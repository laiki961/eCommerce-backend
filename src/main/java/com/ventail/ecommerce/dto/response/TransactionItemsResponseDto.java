package com.ventail.ecommerce.dto.response;

import com.ventail.ecommerce.domain.TransactionItem;

public class TransactionItemsResponseDto {
    private ProductResponseDto details;
    private Double subtotal;

    public TransactionItemsResponseDto(TransactionItem transactionItem) {
        this.details = new ProductResponseDto(transactionItem.getDetails()); //transactionItem.getDetails() <-- is Product
        this.subtotal = transactionItem.getSubtotal();
    }

    public ProductResponseDto getDetails() {
        return details;
    }

    public void setDetails(ProductResponseDto details) {
        this.details = details;
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
                ", subtotal=" + subtotal +
                '}';
    }
}
