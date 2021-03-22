package com.ventail.ecommerce.domain;

import com.ventail.ecommerce.dto.request.CheckoutItemsRequestDto;

public class CheckoutItem {
    private Long productId;
    private Integer quantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CheckoutItem{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
