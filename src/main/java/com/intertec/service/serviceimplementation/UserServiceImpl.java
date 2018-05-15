package com.intertec.service.serviceimplementation;

import com.intertec.model.data.User;
import com.intertec.model.repository.UserRepository;
import com.intertec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Userpc on 13/05/2018.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    public List<User> findUsersByName(String userName) {
        return userRepository.findUsersByName(userName);
    }

    public User saveUser(String userName) {
        User user = new User();
        user.setUserName(userName);
        return userRepository.save(user);
    }

}