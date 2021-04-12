package com.ventail.ecommerce.domain.entity;

import com.ventail.ecommerce.domain.Review;

import javax.persistence.*;

@Entity
@Table(name="Review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="review_id", nullable = false, updatable = false)
    private Long reviewId;

    @Column(name ="userName", nullable = false)
    private String userName;

    @Column(name ="rating", nullable = false)
    private Integer rating;

    @Column(name ="comment", nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private ProductEntity product;

    public ReviewEntity() {
    }

    public ReviewEntity(Review review, ProductEntity productEntity) {
        this.userName = review.getUserName();
        this.rating = review.getRating();
        this.comment = review.getComment();
        this.product = productEntity;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
                ", userName='" + userName + '\'' +
                ", rating=" + rating +
                ", comment='" + comment +
                '}';
    }
}
