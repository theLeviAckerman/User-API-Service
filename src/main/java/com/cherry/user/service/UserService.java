package com.cherry.user.service;


import com.cherry.user.mapper.UserMapper;
import com.cherry.user.dto.UserDto;
import com.cherry.user.entity.User;
import com.cherry.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDto addUser(UserDto userDto) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDtoToUser(userDto));
        return UserMapper.INSTANCE.mapUserToUserDto(savedUser);
    }


    public ResponseEntity<UserDto> findUserById(Integer id) {
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent())
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDto(user.get()),HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
}
