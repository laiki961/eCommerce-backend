package com.ventail.ecommerce.domain;

import com.ventail.ecommerce.domain.entity.CategoryEntity;
import com.ventail.ecommerce.domain.entity.ProductEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Product {
    private Long productId;
    private String name;
    private Category category;
    private String description;
    private String imageUrl;
    private Double price;

    public Product(ProductEntity productEntity){
        this.productId = productEntity.getProductId();
        this.name = productEntity.getName();
        this.category = new Category(productEntity.getCategory());
        this.description = productEntity.getDescription();
        this.price = productEntity.getPrice();
        this.imageUrl = productEntity.getImageUrl();
    }

//    public Product(ProductEntity productEntity){
//        this.productId = productEntity.getProductId();
//        this.name = productEntity.getName();
//        this.description = productEntity.getDescription();
//        this.price = productEntity.getPrice();
//        this.imageUrl = productEntity.getImageUrl();
//    }

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                '}';
    }

}
