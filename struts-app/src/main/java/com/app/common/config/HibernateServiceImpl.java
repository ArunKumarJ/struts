package com.app.common.config;

import java.io.Serializable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateServiceImpl implements HibernateService, ServletContextListener {
	private SessionFactory sessionFactory;
	private Session session;

	private SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate/config/hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}

	public Session getSession() {
		if (session == null || !session.isOpen())
			session = getSessionFactory().openSession();
		return session;
	}

	public <T> Serializable save(T t) {
		getSession();
		return session.save(t);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		getSessionFactory();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (session != null || session.isOpen()) {
			session.close();
			sessionFactory.close();
		}
	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() {
		return getSession().getCriteriaBuilder();
	}

}
