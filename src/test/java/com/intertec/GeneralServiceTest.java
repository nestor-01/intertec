package com.intertec;

import com.intertec.Exceptions.UserNameException;
import com.intertec.mock.RestrictedWordServiceMock;
import com.intertec.mock.UserServiceMock;
import com.intertec.service.GeneralService;
import com.intertec.service.serviceimplementation.GeneralServiceImpl;
import com.intertec.util.Result;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Userpc on 14/05/2018.
 */

public class GeneralServiceTest {

    private GeneralService generalService;

    private final static String[] namesToTest = {"albert","fabian","travis","lee123"};
    private final static String[] namesRepeatedToTest = {"jeanpaul","george","andrew"};

    @Before
    public void construct(){
        GeneralServiceImpl generalServiceImpl = new GeneralServiceImpl();
        generalServiceImpl.setRestrictedWordService(new RestrictedWordServiceMock());
        generalServiceImpl.setUserService(new UserServiceMock());
        generalService = generalServiceImpl;
        generalService.saveRestrictedWord("grass");
        generalService.saveRestrictedWord("drunk");
        generalService.saveRestrictedWord("damn");
        generalService.saveRestrictedWord("crack");
        generalService.saveRestrictedWord("abuse");
        generalService.saveRestrictedWord("cannabis");

        generalService.saveUser("john");
        generalService.saveUser("jeanpaul");
        generalService.saveUser("george");
        generalService.saveUser("carlos");
        generalService.saveUser("andrew");
        generalService.saveUser("kino");
        generalService.saveUser("alban");
        generalService.saveUser("ronaldinho");
    }

    @Test
    public void testCheckUserName(){
        try {
            for(String name : namesToTest) {
                Result result = generalService.checkUserName(name);
                Assert.assertTrue(result.getAccepted());
            }
        } catch (UserNameException e) {
            Assert.fail();
        }
    }

    @Test
    public void testCheckUserNameRepeated() {
        try {
            for(String name : namesRepeatedToTest) {
                Result result = generalService.checkUserName(name);
                Assert.assertFalse(result.getAccepted());
                Assert.assertEquals(14, result.getSuggestedNames().size());
            }
        } catch (UserNameException e) {
            Assert.fail();
        }
    }

    @Test
    public void testCheckUserNameException() {
        try {
            generalService.checkUserName("12345");
            Assert.fail();

        } catch (UserNameException e) {
            Assert.assertEquals("The length of the name is too short", e.getMessage());
        }
    }

    @Test
    public void testCheckUserRestrictedNameException() {
        try {
            Result result = generalService.checkUserName("crack123");
            Assert.fail();

        } catch (UserNameException e) {
            Assert.assertEquals("The name contains a restricted word", e.getMessage());
        }
    }
}
