package com.ventail.ecommerce.dto.response;

import com.ventail.ecommerce.domain.Product;

public class ProductResponseDto {
    private Long productId;
    private String productName;
    private String description;
    private String imageUrl;
    private Double price;

    public ProductResponseDto(Product proudct){
        this.productId = proudct.getProductId();
        this.productName = proudct.getName();
        this.description = proudct.getDescription();
        this.imageUrl = proudct.getImageUrl();
        this.price = proudct.getPrice();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductResponseDto{" +
                "id=" + productId +
                ", name='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}