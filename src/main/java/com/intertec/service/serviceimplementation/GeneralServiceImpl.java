package com.intertec.service.serviceimplementation;

import com.intertec.Exceptions.UserNameException;
import com.intertec.model.data.RestrictedWord;
import com.intertec.model.data.User;
import com.intertec.service.GeneralService;
import com.intertec.service.RestrictedWordService;
import com.intertec.service.UserService;
import com.intertec.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Userpc on 14/05/2018.
 */
@Service
public class GeneralServiceImpl implements GeneralService{

    @Autowired
    private UserService userService;

    @Autowired
    private RestrictedWordService restrictedWordService;

    /**
     * Method that checks if a user name is available
     * @param userName - the user name to be analyze
     * @return if the user name is available or not, if is not available then return a list
     * of possible names.
     * @throws UserNameException- if the user name have less than 6 characters.
     */
    public Result checkUserName(String userName) throws UserNameException {
        Result result = null;
        if (userName.length() < 6) {
            throw new UserNameException("The length of the name is too short");
        }
        if (verifyRestrictedWord(userName)) {
            throw new UserNameException("The name contains a restricted word");
        }
        User user = userService.findUserByUserName(userName);
        if (user != null) {
            List possibleUserNames = new ArrayList<String>();
            List<User> usersSimilarName = userService.findUsersByName(userName);
            int count = 0;
            String similarName = userName;
            while (possibleUserNames.size() < 14) {
                String newName = similarName.concat(String.valueOf(count));
                if (!usersSimilarName.contains(newName)) {
                    possibleUserNames.add(newName);
                }
                if ((count%10) == 0) {
                    Random random = new Random();
                    similarName.concat(String.valueOf(random.nextInt()));
                }
            }
            result = new Result(false, possibleUserNames);
        } else {
            result = new Result(true, null);
        }
        return result;
    }

    public RestrictedWord saveRestrictedWord(String word) {
        if (word == null) {
            return null;
        }
        RestrictedWord restrictedWord = new RestrictedWord();
        restrictedWord.setWord(word);
        return restrictedWordService.save(restrictedWord);
    }

    public User saveUser(String userName) {
        return userService.saveUser(userName);
    }

    private boolean verifyRestrictedWord(String word) {
        List<RestrictedWord> listRestrictedWords = restrictedWordService.getAllRestrictedWords();
        for (RestrictedWord rw: listRestrictedWords) {
            if (word.contains(rw.getWord())) {
                return true;
            }
        }
        return false;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setRestrictedWordService(RestrictedWordService restrictedWordService) {
        this.restrictedWordService = restrictedWordService;
    }
}
