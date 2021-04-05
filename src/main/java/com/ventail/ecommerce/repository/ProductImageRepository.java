package com.ventail.ecommerce.repository;

import com.ventail.ecommerce.domain.entity.ProductEntity;
import com.ventail.ecommerce.domain.entity.ProductImageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends CrudRepository<ProductImageEntity, Long> {
    List<ProductImageEntity> findAll();
}
