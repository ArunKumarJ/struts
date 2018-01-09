package com.app.common.config;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;

public interface HibernateService {

	public Session getSession();

	public CriteriaBuilder getCriteriaBuilder();

	void closeSession();
}
