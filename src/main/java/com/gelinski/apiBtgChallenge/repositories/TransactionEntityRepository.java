package com.gelinski.apiBtgChallenge.repositories;

import com.gelinski.apiBtgChallenge.models.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Long> {
}
