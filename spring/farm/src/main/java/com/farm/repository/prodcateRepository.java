package com.farm.repository;

import com.farm.entity.product.prodcate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface prodcateRepository extends JpaRepository<prodcate, Integer> {
}
