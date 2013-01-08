package com.trial.one.service;

import com.trial.one.dao.UserRepository;
import com.trial.one.domain.User;
import com.trial.one.proxy.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Arun
 * Date: 8/1/13
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService implements IUserService
{

    @Autowired
    UserRepository userRepository;

    @Override
    public User register(User user) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User updateProfile(User user) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User updatePassword(User user) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
