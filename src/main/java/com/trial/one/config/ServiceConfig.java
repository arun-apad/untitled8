package com.trial.one.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created with IntelliJ IDEA.
 * User: Arun
 * Date: 8/1/13
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.trial.one.service", scopedProxy = ScopedProxyMode.INTERFACES)
public class ServiceConfig {

    private static final Logger log = LoggerFactory.getLogger(ServiceConfig.class);
}