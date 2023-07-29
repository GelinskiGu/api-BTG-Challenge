package com.gelinski.apiBtgChallenge.repositories;

import com.gelinski.apiBtgChallenge.models.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long> { }
