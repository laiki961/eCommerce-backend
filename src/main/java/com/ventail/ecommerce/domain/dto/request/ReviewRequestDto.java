package com.ventail.ecommerce.domain.dto.request;

import com.ventail.ecommerce.domain.Review;

public class ReviewRequestDto {
    private Long productId;
    private String userName;
    private Integer rating;
    private String comment;


    public Review toReview(){
        Review review = new Review();
        review.setProductId(productId);
        review.setUserName(userName);
        review.setRating(rating);
        review.setComment(comment);
        return review;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    @Override
    public String toString() {
        return "ReviewRequestDto{" +
                "productId='" + productId + '\'' +
                ", userName='" + userName + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
