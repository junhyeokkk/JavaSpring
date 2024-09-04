package com.ch04.Dao;

import com.ch04.Dto.User1DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User1DAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User1DAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser1(User1DTO dto){
        String sql = "insert into user1 values(?,?,?,?,?)";
        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAge()
        };

        jdbcTemplate.update(sql,params);//sql,parameter
    };
    public User1DTO selectUser1(String uid){

        String sql = "select * from user1 where uid=?";
        User1DTO dto = (User1DTO) jdbcTemplate.queryForObject(sql, new User1RowMapper(), uid);

        return dto;
    }
    public List<User1DTO> selectUser1s(){

        String sql = "select * from user1";

        return  jdbcTemplate.query(sql, new User1RowMapper());
    }
    public void updateUser1(User1DTO dto){

        String sql = "update user1 set name = ?,birth = ?,hp = ?,age = ? where uid = ?";
        Object[] params = {
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAge(),
                dto.getUid()
        };
        jdbcTemplate.update(sql, params);
    }
    public void deleteUser1(String uid){
        String sql = "delete from user1 where uid=?";

        jdbcTemplate.update(sql, uid);
    }
}
