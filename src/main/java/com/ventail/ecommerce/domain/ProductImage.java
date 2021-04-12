package com.ventail.ecommerce.domain;

import com.ventail.ecommerce.domain.entity.ProductImageEntity;

public class ProductImage {
    private Long productImageId;
    private Long productId;
    private String imageUrl;

    public ProductImage() {
    }

    public ProductImage(ProductImageEntity productImageEntity) {
        this.productImageId = productImageEntity.getProductImageId();
        this.productId = productImageEntity.getProduct().getProductId();
        this.imageUrl = productImageEntity.getImageUrl();
    }

    public Long getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Long productImageId) {
        this.productImageId = productImageId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "ProductImageId=" + productImageId +
                ", productId=" + productId +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
