package com.ventail.ecommerce.domain.dto.response;

import com.ventail.ecommerce.domain.Review;

public class ReviewResponseDto {
    private Long reviewId;
    private String username;
    private Integer rating;
    private String comment;


    public ReviewResponseDto(Review review) {
        this.reviewId = review.getReviewId();
        this.username = review.getUsername();
        this.rating = review.getRating();
        this.comment = review.getComment();
    }

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

    @Override
    public String toString() {
        return "ReviewResponseDto{" +
                "reviewId=" + reviewId +
                ", username='" + username + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
