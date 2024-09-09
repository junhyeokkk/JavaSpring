package com.ch06.service;

import com.ch06.DTO.User1DTO;
import com.ch06.dao.User1Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User1Service {
    //테스트 케이스 작성 : 마우스 오른버튼 > generate .. -> test  클릭 후 테스트 작성

    private final User1Mapper user1Mapper;

    public void insertUser1(User1DTO user1DTO){
        user1Mapper.insertUser1(user1DTO);
    };
    public List<User1DTO> selectUser1s(){
        return user1Mapper.selectUser1s();
    };
    public User1DTO selectUser1(String uid){
        return user1Mapper.selectUser1(uid);
    };
    public void updateUser1(User1DTO user1DTO){
        user1Mapper.updateUser1(user1DTO);
    };
    public void deleteUser1(String uid){
        user1Mapper.deleteUser1(uid);
    };
}
