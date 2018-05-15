package com.intertec.mock;

import com.intertec.model.data.User;
import com.intertec.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Userpc on 14/05/2018.
 */
public class UserServiceMock implements UserService {

    private List<User> listUsers;

    public UserServiceMock() {
        listUsers = new ArrayList<User>();
    }

    public User findUserByUserName(String userName) {
        for (User u: listUsers) {
            if (u.getUserName().equals(userName)) {
                return u;
            }
        }
        return null;
    }

    public List<User> findUsersByName(String userName) {
        List listUsersResponse = new ArrayList<User>();
        for (User u: listUsers) {
            if (u.getUserName().contains(userName)) {
                listUsersResponse.add(u);
            }
        }
        return listUsersResponse;
    }

    public User saveUser(String userName) {
        User user = new User();
        user.setUserName(userName);
        listUsers.add(user);
        return user;
    }

}