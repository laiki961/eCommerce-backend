package com.ventail.ecommerce.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class ProductEntity {
    @Id
    @Column(name = "product_id", nullable = false, updatable = false)
    private Long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name ="description", nullable = false)
    private String description;

    //one to many
    @Column(name ="image_url", nullable = false)
    private String imageUrl;

    @Column(name = "price", nullable = false)
    private Double price;

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
        return "ProductEntity{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                '}';
    }
}
