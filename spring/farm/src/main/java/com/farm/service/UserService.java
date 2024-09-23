package com.farm.service;

import com.farm.dto.user.UserDTO;
import com.farm.entity.user.User;
import com.farm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> selectUsers(){
        List<User> users = userRepository.findAll();

        List<UserDTO> userDTOs = new ArrayList<>();
        userDTOs = users.stream().map(entity -> entity.toDTO()).collect(Collectors.toList());

        return userDTOs;
    }
}
