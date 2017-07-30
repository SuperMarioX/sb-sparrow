package com.supermario.sparrow.mybatisxml;

import com.supermario.sparrow.mybatisxml.entity.User;
import com.supermario.sparrow.mybatisxml.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisxmlApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
		//System.out.println("Everything will be ok!");
	}


	@Test
	public void successToGetAlls() {
		userMapper.deleteAll();

		userMapper.insert(new User("supermario", "aaa"));
		System.out.println("hhh:      " + userMapper.getOne(15L));
		Assert.assertEquals(1, userMapper.getAll().size());
	}
}
