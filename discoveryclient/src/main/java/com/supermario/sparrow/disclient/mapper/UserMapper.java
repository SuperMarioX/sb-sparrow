package com.supermario.sparrow.disclient.mapper;


import com.supermario.sparrow.disclient.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 */


public interface UserMapper {

    @Select("SELECT * FROM users")
    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "name", column = "name")
    })
    User getOne(Long id);

    @Insert("INSERT INTO users(name,address,email) VALUES(#{name}, #{address}, #{email})")
    void insert(User user);

    @Update("UPDATE users SET name=#{name},address=#{address} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);


    @Delete("DELETE FROM users")
    void deleteAll();
}
