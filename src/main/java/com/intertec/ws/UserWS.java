package com.intertec.ws;

import com.intertec.model.data.User;
import com.intertec.service.GeneralService;
import com.intertec.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Userpc on 16/05/2018.
 */
@RestController
@EnableWebMvc
@RequestMapping("user/")
public class UserWS {

    @Autowired
    private GeneralService generalService;

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public @ResponseBody
    User saveUser(@RequestParam("user") String user) throws Exception
    {
        return generalService.saveUser(user);
    }

    @RequestMapping(value = "checkUser", method = RequestMethod.POST)
    public @ResponseBody
    Result checkUser(@RequestParam("user") String user) throws Exception
    {
        return generalService.checkUserName(user);
    }
}
