package com.intertec.service;

import com.intertec.model.data.RestrictedWord;

import java.util.List;

/**
 * Created by Userpc on 13/05/2018.
 */
public interface RestrictedWordService {

    public List<RestrictedWord> getAllRestrictedWords();

    public RestrictedWord save(RestrictedWord restrictedWord);

}
