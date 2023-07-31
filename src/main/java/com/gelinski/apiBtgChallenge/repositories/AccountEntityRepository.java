package com.gelinski.apiBtgChallenge.repositories;

import com.gelinski.apiBtgChallenge.models.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long> {
    List<AccountEntity> findByClientId(Long clientId);
}
