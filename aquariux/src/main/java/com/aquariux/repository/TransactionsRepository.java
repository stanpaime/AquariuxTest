package com.aquariux.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aquariux.entity.Transactions;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
	List<Transactions> findByUserId(Long userId);
}
