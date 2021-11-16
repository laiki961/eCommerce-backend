package com.ventail.ecommerce.domain.dto.response;

import com.ventail.ecommerce.domain.Review;

public class ReviewResponseDto {
    private Long reviewId;
    private String userName;
    private Integer rating;
    private String comment;


    public ReviewResponseDto(Review review) {
        this.reviewId = review.getReviewId();
        this.userName = review.getUserName();
        this.rating = review.getRating();
        this.comment = review.getComment();
    }

    public Review toReview(){
        Review review = new Review();
        review.setReviewId(reviewId);
        review.setUserName(userName);
        review.setRating(rating);
        review.setComment(comment);
        return review;
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

    @Override
    public String toString() {
        return "ReviewResponseDto{" +
                "reviewId=" + reviewId +
                ", username='" + userName + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
