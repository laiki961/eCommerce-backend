package com.ventail.ecommerce.domain.dto.response;

import com.ventail.ecommerce.domain.ProductImage;

public class ProductImageResponseDto {
    private Long id;
    private String imageUrl;

    public ProductImageResponseDto(ProductImage productImage) {
        this.id = productImage.getProductImageId();
        this.imageUrl = productImage.getImageUrl();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ProductImageResponseDto{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
