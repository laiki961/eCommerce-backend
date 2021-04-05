package com.ventail.ecommerce.repository;

import com.ventail.ecommerce.domain.Product;
import com.ventail.ecommerce.domain.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findAll();

    ProductEntity findFirstByProductId(Long productId);
    //e.g. productId = 1 ;
    //SELECT * FROM Product WHERE product_id = 1 LIMIT 1;

    List<ProductEntity> findByProductIdIn(List<Long> productIds);
    // e.g. productIds = [1, 3, 5];
    //SELECT * FROM Product WHERE product_id IN (1, 3, 5);

    List<ProductEntity> findByCategory_Id(String categoryId);

    //for search function
    List<ProductEntity> findByNameLike(String productName);

}
