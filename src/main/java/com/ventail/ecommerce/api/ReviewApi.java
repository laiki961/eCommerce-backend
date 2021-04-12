package com.ventail.ecommerce.api;

import com.ventail.ecommerce.domain.Review;
import com.ventail.ecommerce.domain.dto.request.ReviewRequestDto;
import com.ventail.ecommerce.domain.dto.response.ReviewResponseDto;
import com.ventail.ecommerce.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/public/review")
public class ReviewApi {
    Logger logger = LoggerFactory.getLogger(ReviewApi.class);

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ReviewResponseDto createNewReview(@RequestBody ReviewRequestDto reviewRequestDto){ //reviewDto without ProductId
        Review review = reviewService.createNewReview(reviewRequestDto.toReview());
        //after created a review, render the list of review with the new review
        return new ReviewResponseDto(review);
    }

    @GetMapping
    public List<ReviewResponseDto> fetchAllReview(){
        List<ReviewResponseDto> reviewResponseDtos = new ArrayList<>();
        List<Review> reviews = reviewService.getAllReviews();
        for(Review review: reviews){
            reviewResponseDtos.add(new ReviewResponseDto(review));
        }
        return reviewResponseDtos;
    }
}
