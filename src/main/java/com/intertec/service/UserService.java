package com.intertec.service;

import com.intertec.Exceptions.UserNameException;
import com.intertec.model.data.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Userpc on 13/05/2018.
 */
public interface UserService {

    public User findUserByUserName(String userName);

    public List<User> findUsersByName(String userName);

    public User saveUser(String userName);

}
