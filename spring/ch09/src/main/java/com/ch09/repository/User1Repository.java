package com.ch09.repository;

import com.ch09.dto.User1DTO;
import com.ch09.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User1Repository extends JpaRepository<User1, String> {
}
