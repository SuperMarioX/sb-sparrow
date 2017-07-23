package com.supermario.sparrow.disclient.controller;

import com.supermario.sparrow.disclient.mapper.UserMapper;
import com.supermario.sparrow.disclient.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controllers
 */

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getOne")
    public User getOneUser(){
        userMapper.getOne(1L);//Test userMapper
        return new User("hekai", "supermario_x@126.com", "jinye");
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable(value = "id") int id) {

        return new User("hekai", "supermario_x@126.com", "jinye");

    }

}
