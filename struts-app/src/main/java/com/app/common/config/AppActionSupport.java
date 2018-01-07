package com.app.common.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.HttpParametersAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class AppActionSupport extends ActionSupport implements ServletRequestAware, SessionAware, ApplicationAware, HttpParametersAware, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7360324781039212366L;

	private HttpSession session;
	private HttpServletRequest request;
	protected ObjectMapper mapper = new ObjectMapper();

	public String getParameter(String name) {
		return request.getParameter(name);
	}

	public HttpSession getSession() {
		if (session == null)
			session = request.getSession(true);
		return session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParameters(HttpParameters parameters) {
		// TODO Auto-generated method stub

	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

}
