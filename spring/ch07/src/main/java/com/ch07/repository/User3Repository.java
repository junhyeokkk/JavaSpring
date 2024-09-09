package com.ch07.repository;

import com.ch07.entity.User3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<User1, String> : 사용하는 엔티티 타입과 해당 엔티티의 @ID 컬럼 속성 타입 선언
@Repository
public interface User3Repository extends JpaRepository<User3, String> {

}
