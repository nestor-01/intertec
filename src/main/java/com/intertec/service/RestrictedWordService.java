package com.intertec.service;

import com.intertec.model.data.RestrictedWord;

import java.util.List;

/**
 * Created by Userpc on 13/05/2018.
 */
public interface RestrictedWordService {

    public RestrictedWord saveRestrictedWord(String restrictedWord);

    public List<RestrictedWord> getAllRestrictedWords();
}
