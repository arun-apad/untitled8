package com.trial.test.endpoint;

import com.trial.one.domain.User;
import com.trial.test.config.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.MvcResult;

import java.security.Principal;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.setup.MockMvcBuilders.annotationConfigSetup;

/**
 * Created with IntelliJ IDEA.
 * User: Arun
 * Date: 8/1/13
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserControllerTest
{
    static MockMvc mockMvc;
    static User user;

    @BeforeClass
    public static void init(){
        mockMvc = annotationConfigSetup(ApplicationTestConfig.class,
                PersistenceTestProperties.class,
                PersistenceTestConfig.class,
                ServiceTestConfig.class,
                WebTestConfig.class).build();

    }



    @Test
    public void findOne() throws Exception
    {
        user = new User();
        user.setEmail("mail.com");
        Principal principal = new Principal() {
            @Override
            public String getName()
            {
                return user.getEmail();
            }
        };

        MvcResult mvcResult = mockMvc.perform(get("/user/me").principal(principal)).andReturn();

        System.out.println( "CURRENT USER ::::: "+mvcResult.getResponse().getContentAsString());

    }
}
