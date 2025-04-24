package com.bookshop.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bookshop.entity.Author;
import com.bookshop.entity.Book;

public class HibernateUtils {

	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration();
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		hibernateProperties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/online_bookshop");
		hibernateProperties.put("hibernate.connection.username", "root");
		hibernateProperties.put("hibernate.connection.password", "password");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		config.setProperties(hibernateProperties);
		
		config.addAnnotatedClass(Author.class);
		config.addAnnotatedClass(Book.class);
		
		
		return config.buildSessionFactory();
	}
}
