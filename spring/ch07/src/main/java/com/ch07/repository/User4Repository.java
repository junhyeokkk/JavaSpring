package com.ch07.repository;

import com.ch07.entity.User4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User4Repository extends JpaRepository<User4, String> {
}
