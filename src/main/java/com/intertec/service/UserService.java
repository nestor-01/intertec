package com.intertec.service;

import com.intertec.Exceptions.UserNameException;

import java.util.List;
import java.util.Map;

/**
 * Created by Userpc on 13/05/2018.
 */
public interface UserService {

    public Map<Boolean, List<String>> checkUserName(String userName)throws UserNameException;
}
