package com.trial.one.config;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomObjectMapper extends ObjectMapper {

    private static final Logger log = LoggerFactory.getLogger(CustomObjectMapper.class);

    public CustomObjectMapper(){
        super.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
    }
}