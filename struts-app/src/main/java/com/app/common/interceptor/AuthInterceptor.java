package com.app.common.interceptor;

import com.app.common.config.AppActionSupport;
import com.app.domain.model.user.UserMaster;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3187895812940172508L;

	private String excludeMethods;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Ghanta");
		UserMaster userMaster = (UserMaster) invocation.getInvocationContext().getSession()
				.get(AppActionSupport.SESSION_USER_INFO);

		if (userMaster == null && !excludeMethods.contains(invocation.getInvocationContext().getName()))
			return Action.LOGIN;
		return invocation.invoke();
	}

	public String getExcludeMethods() {
		return excludeMethods;
	}

	public void setExcludeMethods(String excludeMethods) {
		this.excludeMethods = excludeMethods;
	}

}
