package com.ch05.service;

import com.ch05.dao.User3Mapper;
import com.ch05.dao.User4Mapper;
import com.ch05.dto.User3DTO;
import com.ch05.dto.User4DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User4Service {

    private User4Mapper user4Mapper;

    @Autowired
    public User4Service(User4Mapper user4Mapper) {
        this.user4Mapper = user4Mapper;
    }

    public void insertUser4(User4DTO user4DTO){
        user4Mapper.insertUser4(user4DTO);
    };
    public List<User4DTO> selectUser4s(){
        return user4Mapper.selectUser4s();
    };
    public User4DTO selectUser4(String uid){
        return user4Mapper.selectUser4(uid);
    };
    public void updateUser4(User4DTO user4DTO){
        user4Mapper.updateUser4(user4DTO);
    };
    public void deleteUser4(String uid){
        user4Mapper.deleteUser4(uid);
    };

}
