package com.ventail.ecommerce.dto.request;

import com.ventail.ecommerce.domain.CheckoutItem;

public class CheckoutItemsRequestDto {
    private Long productId;
    private Integer quantity;

    public CheckoutItem toCheckoutItem(){
        CheckoutItem checkoutItem = new CheckoutItem();
        checkoutItem.setProductId(productId);
        checkoutItem.setQuantity(quantity);
        return checkoutItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "CheckoutItemsRequestDto{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
