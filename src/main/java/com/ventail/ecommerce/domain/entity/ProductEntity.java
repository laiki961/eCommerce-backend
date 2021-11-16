package com.ventail.ecommerce.domain.entity;

import com.ventail.ecommerce.domain.Product;
import com.ventail.ecommerce.domain.ProductImage;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Product")
public class ProductEntity {
    @Id
    @Column(name = "product_id", nullable = false, updatable = false)
    private Long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @Column(name ="description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "product")
    private List<ProductImageEntity> imageUrls;

    @Column(name = "price", nullable = false)
    private Double price;

    //new (testing)
    @OneToMany(mappedBy = "product")
    private List<ReviewEntity> reviews;

    public ProductEntity() {}

    public Long getProductId() {
        return productId;
    }

    //customise the productId
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductImageEntity> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrl(List<ProductImageEntity> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

//    @Override
//    public String toString() {
//        return "ProductEntity{" +
//                "productId=" + productId +
//                ", name='" + name + '\'' +
//                ", category='" + category + '\'' +
//                ", description='" + description + '\'' +
//                ", imageUrls='" + imageUrls + '\'' +
//                ", price=" + price +
//                '}';
//    }


    @Override
    public String toString() {
        return "ProductEntity{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", imageUrls=" + imageUrls +
                ", price=" + price +
                ", reviews=" + reviews +
                '}';
    }
}
