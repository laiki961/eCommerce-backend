package com.ventail.ecommerce.repository;

import com.ventail.ecommerce.domain.entity.ReviewEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<ReviewEntity, Long> {
    List<ReviewEntity> findAll();
    List<ReviewEntity> findByProduct_ProductId(Long productId);

}
