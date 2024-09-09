package com.ch07.service;

import com.ch07.dto.User4DTO;
import com.ch07.entity.User4;
import com.ch07.repository.User4Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User4Service {

    private final User4Repository userRepository;

    public void insertUser4(User4DTO user4DTO){

        User4 entity = user4DTO.toEntity();

        entity = userRepository.save(entity);

    }

    public User4DTO selectUser4(String uid){

        Optional<User4> opt = userRepository.findById(uid);

        if(opt.isPresent()){
            return opt.get().toDTO();
        }
        return null;
    }

    public List<User4DTO> selectUser4s(){
        List<User4> user4s = userRepository.findAll();

        List<User4DTO> users = user4s.stream().map(entity -> entity.toDTO())
                                             .collect(Collectors.toList());
        return users;
    }

    public void updateUser4(User4DTO user4DTO){
        Boolean result = userRepository.existsById(user4DTO.getUid());

        if(result){
            User4 entity = user4DTO.toEntity();
            entity = userRepository.save(entity);
        }
    }

    public void deleteUser4(String uid){
        userRepository.deleteById(uid);
    }
}
