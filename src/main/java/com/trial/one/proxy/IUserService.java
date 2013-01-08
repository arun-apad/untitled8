package com.trial.one.proxy;

import com.trial.one.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: Arun
 * Date: 8/1/13
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IUserService {
    public User register(User user) ;
    public User updateProfile(User user);
    public User updatePassword(User user) ;
    public User findByEmail(String email);
}