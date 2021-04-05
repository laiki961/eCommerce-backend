package com.ventail.ecommerce.domain;

import com.ventail.ecommerce.domain.entity.ProductEntity;
import com.ventail.ecommerce.domain.entity.ProductImageEntity;

public class ProductImage {

    private Long ProductImageId;
    private Product details;
    private String imageUrl;

    public ProductImage() {
    }

    public ProductImage(ProductImageEntity productImageEntity) {
        this.ProductImageId = productImageEntity.getProductImageId();
        this.details = new Product(productImageEntity.getProduct());
        this.imageUrl = productImageEntity.getImageUrl();
    }

    public Long getProductImageId() {
        return ProductImageId;
    }

    public void setProductImageId(Long productImageId) {
        ProductImageId = productImageId;
    }

    public Product getDetails() {
        return details;
    }

    public void setDetails(Product details) {
        this.details = details;
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
                "ProductImageId=" + ProductImageId +
                ", details=" + details +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
