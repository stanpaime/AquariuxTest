package com.aquariux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aquariux.entity.User_Details;

@Repository
public interface UserRepository extends JpaRepository<User_Details, Long> {

}

