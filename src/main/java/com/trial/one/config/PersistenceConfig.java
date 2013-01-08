package com.trial.one.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created with IntelliJ IDEA.
 * User: Arun
 * Date: 8/1/13
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ImportResource("classpath:dao.xml")
@EnableTransactionManagement
public class PersistenceConfig {

    private static final Logger log = LoggerFactory.getLogger(PersistenceConfig.class);

    @Autowired
    private PersistenceProperties persistenceProperties;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(persistenceProperties.getDriverClass());
        dataSource.setJdbcUrl(persistenceProperties.getJdbcUrl());
        dataSource.setUser(persistenceProperties.getUser());
        dataSource.setPassword(persistenceProperties.getPassword());
        dataSource.setMinPoolSize(Integer.parseInt(persistenceProperties.getMinPoolSize()));
        dataSource.setMaxPoolSize(Integer.parseInt(persistenceProperties.getMaxPoolSize()));
        dataSource.setCheckoutTimeout(Integer.parseInt(persistenceProperties.getCheckoutTimeout()));
        dataSource.setMaxStatements(Integer.parseInt(persistenceProperties.getMaxStatements()));
        dataSource.setIdleConnectionTestPeriod(Integer.parseInt(persistenceProperties.getIdleConnectionTestPeriod()));
        dataSource.setPreferredTestQuery(persistenceProperties.getPreferredTestQuery());
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(Boolean.parseBoolean(persistenceProperties.getShowSql()));
        jpaVendorAdapter.setGenerateDdl(Boolean.parseBoolean(persistenceProperties.getGenerateDdl()));
        jpaVendorAdapter.setDatabasePlatform(persistenceProperties.getDialect());
        return jpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws PropertyVetoException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.trial.one.domain");
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        return factoryBean;
    }




}

