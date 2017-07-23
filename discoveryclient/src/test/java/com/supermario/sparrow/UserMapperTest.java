package com.supermario.sparrow;


import com.supermario.sparrow.disclient.mapper.UserMapper;
import com.supermario.sparrow.disclient.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
        userMapper.deleteAll();
//        userMapper.insert(new User("aa", "a123456", "www.supermario.com"));
//        userMapper.insert(new User("bb", "b123456", "www.supermario.com"));
//        userMapper.insert(new User("bb", "b123456", "www.supermario.com"));

        Assert.assertEquals(0, userMapper.getAll().size());
    }

}
