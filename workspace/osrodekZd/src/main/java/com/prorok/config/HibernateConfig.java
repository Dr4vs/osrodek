package com.prorok.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource(value={"classpath:hibernate.properties"})
@EnableJpaRepositories(basePackages="com.prorok.dao")
public class HibernateConfig{
	
	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driver.class.name"));
		driverManagerDataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		driverManagerDataSource.setUsername(environment.getRequiredProperty("jdbc.user.name"));
		driverManagerDataSource.setUrl(environment.getProperty("jdbc.url"));
			
		return driverManagerDataSource;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory(){
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql")); 
		properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql")); 
		properties.put("hibernate.generate_statistics", environment.getProperty("hibernate.generate_statistics")); 
		

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("com.prorok.entity");
		factoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		factoryBean.setJpaProperties(properties);
		factoryBean.setDataSource(dataSource());
		factoryBean.afterPropertiesSet();
			
		return factoryBean.getObject(); 
	}

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }
}
