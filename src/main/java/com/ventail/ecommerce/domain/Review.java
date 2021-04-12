package com.ventail.ecommerce.domain;

import com.ventail.ecommerce.domain.entity.ReviewEntity;

public class Review {
    private Long reviewId;
    private String userName;
    private Integer rating;
    private String comment;
    private Long productId;

    public Review() {
    }

    public Review(ReviewEntity reviewEntity) {
        this.reviewId = reviewEntity.getReviewId();
        this.userName = reviewEntity.getUserName();
        this.rating = reviewEntity.getRating();
        this.comment = reviewEntity.getComment();
        this.productId = reviewEntity.getProduct().getProductId();
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", username='" + userName + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", productId=" + productId +
                '}';
    }
}
