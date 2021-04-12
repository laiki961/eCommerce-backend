package com.ventail.ecommerce.domain;

import com.ventail.ecommerce.domain.entity.CategoryEntity;
import com.ventail.ecommerce.domain.entity.ProductEntity;
import com.ventail.ecommerce.domain.entity.ProductImageEntity;
import com.ventail.ecommerce.domain.entity.ReviewEntity;

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
    private List<ProductImage> imageUrls;
    private Double price;
    //new
    private List<Review> reviews;


    //work (don't touch) previous version
    public Product(ProductEntity productEntity) {
        this.productId = productEntity.getProductId();
        this.name = productEntity.getName();
        this.category = new Category(productEntity.getCategory());
        this.description = productEntity.getDescription();
        this.price = productEntity.getPrice();
        //covert List<ProductImageEntity> to List<ProductImage>
        List<ProductImage> productImages = new ArrayList<>();
        for (ProductImageEntity productImageEntity: productEntity.getImageUrls()){
            ProductImage productImage =  new ProductImage(productImageEntity);
            productImages.add(productImage);
        }
        this.imageUrls = productImages;
        //new(testing)
        List<Review> reviews = new ArrayList<>();
        for(ReviewEntity reviewEntity: productEntity.getReviews()){
            reviews.add(new Review(reviewEntity));
        }
        this.reviews = reviews;
        //
    }

    public Product() {
    }

//    public ProductEntity toEntity(){
//        ProductEntity productEntity = new ProductEntity();
//        productEntity.setProductId(productId);
//        productEntity.setCategory(category.toCategoryEntity());
//        productEntity.setName(name);
//        productEntity.setDescription(description);
//        List<ProductImageEntity> productImageEntities = new ArrayList<>();
//        for(int i=0; i<imageUrls.size() ; i++){
//            ProductImageEntity productImageEntity = new ProductImageEntity();
//            productImageEntity.setProductImageId(imageUrls.get(i).getProductImageId());
//            productImageEntity.setProduct(); // how to pass itself ???
//            productImageEntity.setImageUrl(imageUrls.get(i).getImageUrl());
//            productImageEntities.add(productImageEntity);
//        }
//        productEntity.setImageUrl(productImageEntities);
//        productEntity.setImageUrl(null);
//        productEntity.setPrice(price);
//        return productEntity;
//    }

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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
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
