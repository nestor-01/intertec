package com.intertec.mock;

import com.intertec.model.data.RestrictedWord;
import com.intertec.service.RestrictedWordService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Userpc on 14/05/2018.
 */
public class RestrictedWordServiceMock implements RestrictedWordService {

    private List<RestrictedWord> listRestrictedWords;

    public RestrictedWordServiceMock() {
        listRestrictedWords = new ArrayList<RestrictedWord>();
    }

    public List<RestrictedWord> getAllRestrictedWords() {
        return listRestrictedWords;
    }

    public RestrictedWord save(RestrictedWord restrictedWord) {
        listRestrictedWords.add(restrictedWord);
        return restrictedWord;
    }
}
