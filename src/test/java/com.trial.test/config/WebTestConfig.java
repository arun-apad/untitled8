package com.trial.test.config;

import com.trial.one.config.ApplicationConfig;
import com.trial.one.config.CustomObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Arun
 * Date: 10/1/13
 * Time: 1:17 PM
 * To change this template use File | Settings | File Templates.
 */


    @Configuration
//    @ImportResource("classpath:security.xml")
    @ComponentScan(basePackages = "com.trial.one.endpoint")
    @EnableWebMvc
    public class WebTestConfig extends WebMvcConfigurerAdapter {

        private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);


        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            MappingJacksonHttpMessageConverter jacksonHttpMessageConverter = new MappingJacksonHttpMessageConverter();
            jacksonHttpMessageConverter.setObjectMapper(new CustomObjectMapper());
            converters.add(jacksonHttpMessageConverter);

            BufferedImageHttpMessageConverter bufferedImageHttpMessageConverter = new BufferedImageHttpMessageConverter();
            converters.add(bufferedImageHttpMessageConverter);
        }

        @Bean
        public InternalResourceViewResolver viewResolver(){
            InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
            viewResolver.setPrefix("/WEB-INF/pages/");
            viewResolver.setSuffix(".jsp");
            return viewResolver;
        }




    }

