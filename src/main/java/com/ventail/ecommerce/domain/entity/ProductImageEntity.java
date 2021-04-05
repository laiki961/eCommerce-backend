package com.ventail.ecommerce.domain.entity;

import javax.persistence.*;


@Entity
@Table(name="ProductImage")
public class ProductImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productImage_id", nullable = false, updatable = false)
    private Long productImageId;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private ProductEntity product;

    @Column(name="imageUrl", nullable = false)
    private String imageUrl;

    public ProductImageEntity() {
    }

    public ProductImageEntity(ProductEntity productEntity) {
        this.productImageId = getProductImageId();
        this.product = productEntity;
        this.imageUrl = getImageUrl();
    }

    public Long getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Long productImageId) {
        productImageId = productImageId;
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
                "ProductImageId=" + productImageId +
                ", product=" + product +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
