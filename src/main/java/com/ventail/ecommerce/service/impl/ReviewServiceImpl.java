package com.ventail.ecommerce.service.impl;

import com.ventail.ecommerce.domain.Product;
import com.ventail.ecommerce.domain.Review;
import com.ventail.ecommerce.domain.dto.response.ReviewResponseDto;
import com.ventail.ecommerce.domain.entity.ProductEntity;
import com.ventail.ecommerce.domain.entity.ReviewEntity;
import com.ventail.ecommerce.repository.ProductRepository;
import com.ventail.ecommerce.repository.ReviewRepository;
import com.ventail.ecommerce.service.ProductService;
import com.ventail.ecommerce.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    Logger logger = LoggerFactory.getLogger(ReviewService.class);

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProductService productService;

    @Override
    public Review createNewReview(Review review) {
        //convert productDO to productEntity
        ProductEntity productEntity = productService.getProductEntityById(review.getProductId()); // unfinished, loop die

        ReviewEntity reviewEntity = new ReviewEntity(review, productEntity); //?????
        reviewEntity = reviewRepository.save(reviewEntity);
        //not sure if should return the new review or the whole list of review
        return new Review(reviewEntity);
    }

//    @Override
//    public List<Review> getAllReviews() {
//        List<ReviewEntity> reviews = reviewRepository.findAll();
//        List<Review> reviewList = new ArrayList<>();
//        for(ReviewEntity reviewEntity: reviews){
//            reviewList.add(new Review(reviewEntity));
//        }
//        return reviewList;
//    }
        @Override
        public List<Review> getAllReviewsByProductId(Long productId) {
        List<ReviewEntity> reviews = reviewRepository.findByProduct_ProductId(productId);
        List<Review> reviewList = new ArrayList<>();
        for(ReviewEntity reviewEntity: reviews){
            reviewList.add(new Review(reviewEntity));
        }
        return reviewList;
    }

}
