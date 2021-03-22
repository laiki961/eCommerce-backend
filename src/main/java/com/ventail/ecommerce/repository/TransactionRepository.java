package com.ventail.ecommerce.repository;

import com.ventail.ecommerce.domain.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {
    TransactionEntity findFirstByTransactionId(Long transactionId);
}
