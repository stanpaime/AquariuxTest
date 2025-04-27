package com.aquariux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aquariux.entity.Crypto_Details;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto_Details, String> {

}
