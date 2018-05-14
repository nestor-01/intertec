package com.intertec.ws;

import com.intertec.model.data.RestrictedWord;
import com.intertec.service.RestrictedWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 * Created by Userpc on 13/05/2018.
 */
@RestController
@EnableWebMvc
@RequestMapping("restrictedword/")
public class RestrictedWordWS {

    @Autowired
    private RestrictedWordService restrictedWordService;

    @RequestMapping(value = "saveRestrictedWord", method = RequestMethod.PUT)
    public @ResponseBody
    RestrictedWord saveRestrictedWord(@RequestParam("word") String word) throws Exception
    {
        return restrictedWordService.saveRestrictedWord(word);
    }



}
