package com.intertec.service;

import com.intertec.Exceptions.UserNameException;
import com.intertec.model.data.RestrictedWord;
import com.intertec.model.data.User;
import com.intertec.util.Result;

/**
 * Created by Userpc on 14/05/2018.
 */

public interface GeneralService {

    public Result checkUserName(String userName)throws UserNameException;

    public RestrictedWord saveRestrictedWord(String restrictedWord);

    public User saveUser(String userName);

}
