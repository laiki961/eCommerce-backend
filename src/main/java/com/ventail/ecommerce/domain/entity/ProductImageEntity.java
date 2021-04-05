package com.ventail.ecommerce.domain.entity;

import javax.persistence.*;


@Entity
@Table(name="ProductImage")
public class ProductImageEntity {
    @Id
    @Column(name = "productImage_id", nullable = false, updatable = false)
    private Long ProductImageId;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private ProductEntity product;

    @Column(name="imageUrl", nullable = false)
    private String imageUrl;

    public ProductImageEntity() {
    }

    public Long getProductImageId() {
        return ProductImageId;
    }

    public void setProductImageId(Long productImageId) {
        ProductImageId = productImageId;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ProductImageEntity{" +
                "ProductImageId=" + ProductImageId +
                ", product=" + product +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
