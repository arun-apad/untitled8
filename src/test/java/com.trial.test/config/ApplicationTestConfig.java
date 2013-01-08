package com.trial.test.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * Created with IntelliJ IDEA.
 * User: Arun
 * Date: 8/1/13
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ComponentScan(basePackages = "com.trial.one.config")
public class ApplicationTestConfig {

    private static final Logger log = LoggerFactory.getLogger(ApplicationTestConfig.class);

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[]{new ClassPathResource("dao-test.properties")};
        configurer.setLocations(resources);
        configurer.setIgnoreUnresolvablePlaceholders(true);
        log.info("dao.properties loaded");
        return configurer;
    }

    @Bean
    public Mapper mapper(){
        DozerBeanMapper mapper = new DozerBeanMapper();
        return mapper;
    }
}
