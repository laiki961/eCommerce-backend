package com.ventail.ecommerce.repository;

import com.ventail.ecommerce.domain.entity.CategoryEntity;
import com.ventail.ecommerce.domain.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, String> {
    List<CategoryEntity> findAll();
}
