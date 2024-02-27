package com.cherry.user.controller;


import com.cherry.user.dto.UserDto;
import com.cherry.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserDto addedUser = userService.addUser(userDto);
        return new ResponseEntity<>(addedUser, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{userId}")

    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
        ResponseEntity<UserDto> userById = userService.findUserById(userId);
        return userById;

    }
}
