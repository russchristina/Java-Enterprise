package com.revature;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.model.Polkaman;

/*
 * We will configure our Spring ORM specific beans in this class.
 */

@Configuration
/*
 * Oh, and I predictably also forgot to use my @Enable annotation. What a Spring week.
 */
@EnableTransactionManagement
public class ORMConfig {

	/*
	 * We'll start by adding a bean that represents our data source. This means that the
	 * bean will encompass the credentials for accessing the data source.
	 */
	@Bean
	public DataSource dataSourceBean() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		/*
		 * Same rules apply: Do not hardcode credentials into an application. You can
		 * still pull this information from environment variables or a properties file.
		 */
		dataSource.setUrl(System.getenv("url"));
		/*
		 * My local DB does not have a username or a password, but I'm keeping this
		 * here for your reference.
		 */
//		dataSource.setUsername(username);
//		dataSource.setPassword(password);
		return dataSource;
	}
	
	/*
	 * We will now set up a bean for our JPA Vendor. Our JPA vendor is Hibernate in this
	 * case. We will then pass our datasource to our JPA Vendor.
	 * 
	 * We will just use our session factory as our entity manager. The difference between
	 * using this session factory and an entity manager factory is that the entity manager
	 * factory provides more interface-driven development, which makes for easier refactoring.
	 * 
	 * 
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		//Make sure that you pass your data source to your JPA vendor.
		sessionFactory.setDataSource(dataSourceBean());
		//Tell Hibernate where your entities (classes marked with @Entity) are located.
		sessionFactory.setAnnotatedClasses(Polkaman.class);
		/*
		 * There are a few properties that you might want to set when working with
		 * Hibernate.
		 */
		Properties hibernateProperties = new Properties();
		//This property is helpful in that it shows you the SQL statements Hibernate generates for you.
		hibernateProperties.put("hibernate.show_sql", "true");
		/*
		 * This property determines Hibernate's behavior on application startup. You
		 * have four potential values: 1) create: hibernate will drop tables and recreate them
		 * on application startup; should NEVER be used in production. 2) update: hibernate will
		 * simply update tables in the DB on application startup. 3) create-drop: hibernate
		 * will create tables on application startup and drop them when the application stops.
		 * 4) validate: hibernate will attempt to validate your existing schema against your
		 * mappings on the Java side; this is harder, but it is good practice.
		 */
		hibernateProperties.put("hibernate.hbm2ddl.auto", "validate");
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}
	
	/*
	 * My transaction wouldn't work today because I forgot to add my transaction manager,
	 * and I'm big sad about this.
	 */
	@Bean
	public TransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
}
