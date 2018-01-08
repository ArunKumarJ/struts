package com.app.action.user;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import com.app.common.config.AppActionSupport;
import com.app.domain.model.user.UserMaster;
import com.app.service.user.UserService;
import com.opensymphony.xwork2.inject.Inject;

public class LoginAction extends AppActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8976874734903102529L;

	@Inject("userService")
	private UserService userService;
	private String userId;
	private String password;

	public String doLogin() {
		UserMaster userMaster = userService.doLogin(userId, password);
		if (Objects.isNull(userMaster)) {
			addActionError("User Id or Password not match.");
		} else {
			HttpSession session = getSession();
			session.setAttribute(SESSION_USER_INFO, userMaster);
		}
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
