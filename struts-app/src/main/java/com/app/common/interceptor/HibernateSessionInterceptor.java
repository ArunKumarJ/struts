package com.app.common.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.common.config.HibernateService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class HibernateSessionInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6739059751077263455L;

	private final static Logger logger = LogManager.getLogger(HibernateSessionInterceptor.class);

	@Inject("hibernateService")
	private HibernateService hibernateService;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String str = invocation.invoke();
		hibernateService.closeSession();
		logger.info("***Session flush & closed***");
		return str;
	}
}
