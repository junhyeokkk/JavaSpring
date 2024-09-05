package com.ch05.dao;

import com.ch05.dto.User1DTO;
import com.ch05.dto.User2DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User2Mapper {

    public void insertUser2(User2DTO user2DTO);
    public List<User2DTO> selectUser2s();
    public User2DTO selectUser2(String uid);
    public void updateUser2(User2DTO user2DTO);
    public void deleteUser2(String uid);

}
