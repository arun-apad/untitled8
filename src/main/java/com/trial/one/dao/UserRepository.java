package com.trial.one.dao;

import org.springframework.data.repository.CrudRepository;
import  com.trial.one.domain.*;
/**
 * Created with IntelliJ IDEA.
 * User: Arun
 * Date: 8/1/13
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends CrudRepository<User, Long>
{
    public User findByEmail(String email);
}
