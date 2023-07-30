package com.gelinski.apiBtgChallenge.repositories;

import com.gelinski.apiBtgChallenge.models.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Long> {
    List<TransactionEntity> findByAccountId(Long accountId);
}
