package com.trial.test.service;

import com.trial.one.domain.*;
import com.trial.one.proxy.IUserService;
import com.trial.test.config.ApplicationTestConfig;
import com.trial.test.config.PersistenceTestConfig;
import com.trial.test.config.PersistenceTestProperties;
import com.trial.test.config.ServiceTestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ScopedProxyMode;
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
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
//@ComponentScan(basePackages = "com.trial.one.service", scopedProxy = ScopedProxyMode.INTERFACES)
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
@ContextConfiguration(classes  = {ApplicationTestConfig.class, PersistenceTestProperties.class, PersistenceTestConfig.class, ServiceTestConfig.class})
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testFindByEmail()
    {
        User user = userService.findByEmail("mail.com");
        Assert.assertNotNull(user.getId());
    }
}
