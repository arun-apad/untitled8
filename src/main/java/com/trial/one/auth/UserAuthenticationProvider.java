package com.trial.one.auth;

import com.trial.one.domain.User;
import com.trial.one.proxy.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Arun
 * Date: 8/1/13
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */

public class UserAuthenticationProvider implements AuthenticationProvider {
    Logger logger = LoggerFactory.getLogger(UserAuthenticationProvider.class);

    @Autowired
    private IUserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
        User user = userService.findByEmail(authentication.getName());
        if(user != null){
            if(user.getPassword().equals(authentication.getCredentials())){
//                AUTHORITIES.add(new SimpleGrantedAuthority(user.getRole().toString()));
                logger.info("Authentication successful");
                return new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), AUTHORITIES);
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);  //To change body of implemented methods use File | Settings | File Templates.
    }
}