package com.frank;

import com.frank.entity.User;
import com.frank.repositry.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FrankSpringbootHibernateApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        List<User> userList=userRepository.findAll();
        System.out.println(userList.size());
        for (User user:userList){
            System.out.println(user.toString());
        }
    }

    @Test
    public void contextLoads() {
    }
}
