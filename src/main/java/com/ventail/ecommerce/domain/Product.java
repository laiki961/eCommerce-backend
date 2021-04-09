package com.ventail.ecommerce.domain;

import com.ventail.ecommerce.domain.entity.CategoryEntity;
import com.ventail.ecommerce.domain.entity.ProductEntity;
import com.ventail.ecommerce.domain.entity.ProductImageEntity;

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
//    private String imageUrl;
    private List<ProductImage> imageUrls;
    private Double price;


    //work (don't touch) previous version
//    public Product(ProductEntity productEntity){
//        this.productId = productEntity.getProductId();
//        this.name = productEntity.getName();
//        this.category = new Category(productEntity.getCategory());
//        this.description = productEntity.getDescription();
//        this.price = productEntity.getPrice();
//        this.imageUrl = productEntity.getImageUrl();
//    }


    //new (testing)
    public Product(ProductEntity productEntity) {
        this.productId = productEntity.getProductId();
        this.name = productEntity.getName();
        this.category = new Category(productEntity.getCategory());
        this.description = productEntity.getDescription();
        this.price = productEntity.getPrice();
        List<ProductImage> productImages = new ArrayList<>();
        for (ProductImageEntity productImageEntity: productEntity.getImageUrls()){
            ProductImage productImage =  new ProductImage(productImageEntity);
            productImages.add(productImage);
        }
        this.imageUrls = productImages;
    }

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

    public List<ProductImage> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<ProductImage> imageUrls) {
        this.imageUrls = imageUrls;
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
                ", imageUrls=" + imageUrls +
                ", price=" + price +
                '}';
    }
}
