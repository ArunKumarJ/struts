package com.app.action.user;

import com.app.common.config.AppActionSupport;

public class LoginAction extends AppActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8976874734903102529L;

	private String userId;
	private String password;

	public String doLogin() {

		return SUCCESS;
	}

	@Override
	public void validate() {
		if (userId == null || userId.length() == 0)
			addFieldError("userId", "User Id can not be null");
		if (password == null || password.length() == 0)
			addFieldError("password", "Password can not be null");
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
