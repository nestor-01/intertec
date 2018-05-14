package com.intertec.service.serviceimplementation;

import com.intertec.model.data.RestrictedWord;
import com.intertec.model.repository.RestrictedWordRepository;
import com.intertec.service.RestrictedWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Userpc on 13/05/2018.
 */
@Service
public class RestrictedWordServiceImpl implements RestrictedWordService {

    @Autowired
    private RestrictedWordRepository restrictedWordRepository;

    public RestrictedWord saveRestrictedWord(String word) {
        RestrictedWord restrictedWord = new RestrictedWord();
        restrictedWord.setWord(word);
        return restrictedWordRepository.save(restrictedWord);
    }

    public List<RestrictedWord> getAllRestrictedWords() {
        return restrictedWordRepository.findAll();
    }
}
