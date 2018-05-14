package com.intertec.service.serviceimplementation;

import com.intertec.Exceptions.UserNameException;
import com.intertec.model.data.RestrictedWord;
import com.intertec.model.data.User;
import com.intertec.model.repository.UserRepository;
import com.intertec.service.RestrictedWordService;
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

    @Autowired
    private RestrictedWordService restrictedWordService;

    /**
     * Method that checks if a user name is available
     * @param userName - the user name to be analyze
     * @return if the user name is available or not, if is not available then return a list
     * of possible names.
     * @throws UserNameException- if the user name have less than 6 characters.
     */
    public Map<Boolean, List<String>> checkUserName(String userName) throws UserNameException {
        Map result = new HashMap<Boolean, List<String>>();
        if (userName.length() < 6) {
            throw new UserNameException();
        }
        if (verifyRestrictedWord(userName)) {
            throw new UserNameException();
        }
        User user = userRepository.findUserByUserName(userName);
        if (user == null) {
            List possibleUserNames = new ArrayList<String>();
            List<User> usersSimilarName = userRepository.findUsersByName(userName);
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
            result.put(false, possibleUserNames);
        } else {
            result.put(true, null);
        }
        return result;
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
}
