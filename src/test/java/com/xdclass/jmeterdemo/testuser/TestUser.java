package com.xdclass.jmeterdemo.testuser;

import com.xdclass.jmeterdemo.model.User;
import com.xdclass.jmeterdemo.repository.UserRepository;
import com.xdclass.jmeterdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestUser {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        userService.addUser(new User("list",
                "123456","rr@163.com"));
    }

    @Test
    public void updateTest(){
        User user =new User();
        user.setId(1);
        user.setRegtime("update@163.com");
        user.setName("zhangsan");
        user.setPassword("123456");
        userService.updateUser(user);
    }

    @Test
    public void testUser(){
        userService.addUser(new User("wanghu1111","123456","qq@163.com"));
        userService.updateById("123456", 1);
        System.out.println("===========================");
        List<User> allUser = userService.getAllUser();
        for(User user: allUser){
            System.out.println(user);
        }
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println(userRepository.count());
        System.out.println("+++++++++++++++++++++++++++");

        //userService.deleteById(6);
        User one = userRepository.getOne(1l);
        System.out.println(one);
        System.out.println("+++++++++++++++++++++++++++");

        userRepository.findByNameAndAndPassword("zhangsan","123456");
        System.out.println("+++++++++++++++++++++++++++");
        User byId = userService.findBYId(1);
        System.out.println(byId);
    }

}
