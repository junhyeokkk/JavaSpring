package com.ch05.service;

import com.ch05.dao.User2Mapper;
import com.ch05.dto.User2DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2Service {

    private final User2Mapper user2Mapper;

    @Autowired
    public User2Service(User2Mapper user2Mapper) {
        this.user2Mapper = user2Mapper;
    }

    public void insertUser2(User2DTO user2DTO){
        user2Mapper.insertUser2(user2DTO);
    };
    public List<User2DTO> selectUser2s(){
        return user2Mapper.selectUser2s();
    };
    public User2DTO selectUser2(String uid){
        return user2Mapper.selectUser2(uid);
    };
    public void updateUser2(User2DTO user2DTO){
        user2Mapper.updateUser2(user2DTO);
    };
    public void deleteUser2(String uid){
        user2Mapper.deleteUser2(uid);
    };
}
