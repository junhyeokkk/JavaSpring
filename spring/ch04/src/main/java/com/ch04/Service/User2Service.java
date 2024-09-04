package com.ch04.Service;

import com.ch04.Dao.User2DAO;
import com.ch04.Dto.User2DTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2Service {

    private User2DAO dao;

    public User2Service(User2DAO user2DAO) {
        this.dao = user2DAO;
    }

    public void insertUser2(User2DTO dto){
        dao.insertUser2(dto);
    }
    public User2DTO selectUser2(String uid){
        return dao.selectUser2(uid);
    }
    public List<User2DTO> selectUser2s(){

        return dao.selectUser2s();
    }
    public void updateUser2(User2DTO dto){
        dao.updateUser2(dto);
    }
    public void deleteUser2(String uid){
        dao.deleteUser2(uid);
    }
}
