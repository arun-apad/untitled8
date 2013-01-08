package com.trial.test.dao;

import com.trial.one.domain.*;
import com.trial.one.dao.UserRepository;
import com.trial.test.config.ApplicationTestConfig;
import com.trial.test.config.PersistenceTestConfig;
import com.trial.test.config.PersistenceTestProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Arun
 * Date: 8/1/13
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
@ContextConfiguration(classes  = {ApplicationTestConfig.class, PersistenceTestProperties.class, PersistenceTestConfig.class})
public class UserDaoTest {


    @Autowired
    private UserRepository userRepository;



    @BeforeClass
    public static void setUpClass(){

    }

    @Test
    public void findByEmail()
    {
        System.out.println("CHECK >>>>>______________________________________");
        System.out.println("---------------"+userRepository.findAll().toString());
    }

    //@Test
    public void testCreate(){
        User user = new User("firoz.fazil@gmail.com", "test");
        user = userRepository.save(user);
        Assert.assertNotNull(user.getId());
    }

    //@Test
    public void testDeleteAll(){
        userRepository.deleteAll();
    }


    @AfterClass
    public static void tearDownClass(){

    }

}
