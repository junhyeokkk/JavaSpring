package com.ch07.service;


import com.ch07.dto.User3DTO;
import com.ch07.entity.User3;
import com.ch07.repository.User3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User3Service {

    // 생성자 주입
    private final User3Repository user3Repository;

    public void insertUser3(User3DTO user3DTO) {

        //DTO를 Entity로 변환
        User3 entity = user3DTO.toEntity();

        // Entity 저장(데이터베이스 Insert)
        user3Repository.save(entity);
    }
    public User3DTO selectUser3(String uid) {
        /*
             Optional
             - null 체크 검정을 손쉽고 안전하게 처리하기 위한 클래스
             - Spring JPA find~ 메서드 결과 타입
        */
        Optional<User3> opt = user3Repository.findById(uid);
        // Entity 존재확인 후 Optional 타입으로 정의된 Entity 가져오기
        if (opt.isPresent()) {
            User3 user3 = opt.get();

            // Entity를 DTO로 변환
            return user3.toDTO();
        }
        return null;
    }
    public List<User3DTO> selectUser3s() {

        // Entity 전체 조회
        List<User3> user3s = user3Repository.findAll();

        // List stream(내부반복자)를 이용한 Entity 리스트를 DTO 리스트로 변환
        List<User3DTO> users = user3s.stream()
                                     .map(entity -> entity.toDTO())
                                     .collect(Collectors.toList());

        return users;
    }
    public void updateUser3(User3DTO user3DTO) {

        Boolean result = user3Repository.existsById(user3DTO.getUid());

        if(result){
            // DTO를 Entity로 변환
            User3 entity = user3DTO.toEntity();

            // Entity 수정 (데이터베이스 Update)
            user3Repository.save(entity);
        }
    }

    public void deleteUser3(String uid) {

        // Entity 삭제 (데이터베이스 Delete)
        user3Repository.deleteById(uid);
    }
}
