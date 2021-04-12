package com.ventail.ecommerce.service;

import com.ventail.ecommerce.domain.Product;
import com.ventail.ecommerce.domain.Review;
import com.ventail.ecommerce.domain.dto.response.ReviewResponseDto;

import java.util.List;

public interface ReviewService {
    Review createNewReview(Review review);
    List<Review> getAllReviews();
}
