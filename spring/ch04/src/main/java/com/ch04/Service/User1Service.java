package com.ch04.Service;

import com.ch04.Dao.User1DAO;
import com.ch04.Dto.User1DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User1Service {


    private User1DAO dao;

    @Autowired
    public User1Service(User1DAO dao) {
        this.dao = dao;
    }

    public void insertUser1(User1DTO dto){
        dao.insertUser1(dto);
    };
    public User1DTO selectUser1(String uid){

        return dao.selectUser1(uid);
    }
    public List<User1DTO> selectUser1s(){
        return dao.selectUser1s();
    }
    public void updateUser1(User1DTO dto){
        dao.updateUser1(dto);
    }
    public void deleteUser1(String uid){
        dao.deleteUser1(uid);
    }
}
