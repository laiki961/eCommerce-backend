package com.ventail.ecommerce.repository;

import com.ventail.ecommerce.domain.entity.TransactionProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionProductRepository extends CrudRepository<TransactionProductEntity, String> {
}
