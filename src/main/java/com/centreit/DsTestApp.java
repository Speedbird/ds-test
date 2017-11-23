package com.centreit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jta.XADataSourceWrapper;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;
import javax.sql.XADataSource;

@SpringBootApplication
@Configuration
public class DsTestApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DsTestApp.class, args);
    }

    @Autowired
    private XADataSourceWrapper wrapper;

    @Bean
    public DataSource dataSource() throws Exception {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("java:comp/env/sharedDataSource");
        jndiObjectFactoryBean.afterPropertiesSet();
        XADataSource xaDataSource = (XADataSource) jndiObjectFactoryBean.getObject();
        return wrapper.wrapDataSource(xaDataSource);
    }

}
