package com.ch09.service;

import com.ch09.dto.User2DTO;
import com.ch09.entity.User2;
import com.ch09.repository.User2Repository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User2Service {

    private final User2Repository user2Repository;

    public User2 insertUser2(User2DTO user2DTO) {
       return user2Repository.save(user2DTO.toEntity());
    }

    public User2DTO selectUser2(String uid) {
        Optional<User2> opt = user2Repository.findById(uid);

        if(opt.isPresent()) {
            User2DTO user2DTO = opt.get().toDTO();
            return user2DTO;
        }
        return null;
    }

    public List<User2DTO> selectUser2s() {
        List<User2> user2s = user2Repository.findAll();

        List<User2DTO> user2DTOS = new ArrayList<>();
        user2DTOS = user2s.stream().map(entity -> entity.toDTO()).collect(Collectors.toList());

        return user2DTOS;
    }

    public User2 updateUser2(User2DTO user2DTO) {
        String uid = user2DTO.getUid();
        boolean result = user2Repository.existsById(uid);
        if(result) {
            User2 user2= user2Repository.save(user2DTO.toEntity());
            return user2;
        }
        return null;
    }

    public void deleteUser2(String uid) {
        if(!user2Repository.existsById(uid)){
            throw new EntityNotFoundException("user not found");
        }
        // Entity 삭제 (데이터베이스 Delete)
        user2Repository.deleteById(uid);
    }
}
