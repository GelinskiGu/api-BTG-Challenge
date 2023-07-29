package com.gelinski.apiBtgChallenge.repositories;

import com.gelinski.apiBtgChallenge.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientEntityRepository extends JpaRepository<ClientEntity, Long> {}
