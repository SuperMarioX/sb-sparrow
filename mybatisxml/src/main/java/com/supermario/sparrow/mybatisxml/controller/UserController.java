package com.supermario.sparrow.mybatisxml.controller;

import com.supermario.sparrow.mybatisxml.entity.User;
import com.supermario.sparrow.mybatisxml.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getOne")
    public User getOneUser(){
        //userMapper.getOne(1L);//Test userMapper
        userMapper.getAll();
        return new User("hekai", "supermario_x@126.com");
    }


    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        List<User> userList = userMapper.getAll();
        return userList;

    }
}
