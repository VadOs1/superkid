package com.gmail.dissa.vadim.superkid.config;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@EnableTransactionManagement
@EnableJpaRepositories(basePackages={"com.gmail.dissa.vadim.superkid.repository"})
@ComponentScan(basePackages={"com.gmail.dissa.vadim.superkid.domain"})
public class RootConfig {

    // Making DataSource
    // TODO: CHANGE TO SERVLET CONTAINER JNDI LOOKUP
    // TODO: SPRING DATA => SPRING DATA REST
    @Bean
    @Profile("!test")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/superkid?autoReconnect=true&useSSL=false");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(20);
        return dataSource;
    }

    // Making TEST DataSource
    @Bean
    @Profile("test")
    public DataSource testDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:h2:mem:superkid_test;INIT=RUNSCRIPT FROM 'classpath:superkid_test.sql';DATABASE_TO_UPPER=false;");
        dataSource.setDriverClassName("org.h2.Driver");
        return dataSource;
    }

    // Making JPA provider
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(false);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        return hibernateJpaVendorAdapter;
    }

    // Making EntityManager factory
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("com.gmail.dissa.vadim.superkid.domain");
        return lef;
    }

    // Enabling transactions
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    // JPA-specific or Hibernate-specific exceptions -> Spring exceptions
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}