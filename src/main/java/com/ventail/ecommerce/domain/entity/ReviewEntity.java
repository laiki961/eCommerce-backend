package com.ventail.ecommerce.domain.entity;

import javax.persistence.*;

@Entity
@Table(name="Review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="review_id", nullable = false, updatable = false)
    private Long reviewId;

    @Column(name ="username", nullable = false)
    private String username;

    @Column(name ="rating", nullable = false)
    private Integer rating;

    @Column(name ="comment", nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private ProductEntity product;


    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ReviewEntity{" +
                "reviewId=" + reviewId +
                ", username='" + username + '\'' +
                ", rating=" + rating +
                ", comment='" + comment +
                '}';
    }
}
