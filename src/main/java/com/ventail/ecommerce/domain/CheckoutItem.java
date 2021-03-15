package com.ventail.ecommerce.domain;

public class CheckoutItem {
    private Long productId;
//    private Integer quantity;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "CheckoutItems{" +
                "productId=" + productId +
                '}';
    }
}
