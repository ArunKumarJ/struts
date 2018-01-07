package com.app.common.config;

import org.hibernate.Session;

public interface HibernateService {
	public Session getSession();
}
