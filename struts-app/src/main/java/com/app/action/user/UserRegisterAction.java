package com.app.action.user;

import com.app.common.config.AppActionSupport;
import com.app.domain.model.user.UserMaster;
import com.app.service.user.UserService;
import com.opensymphony.xwork2.inject.Inject;

public class UserRegisterAction extends AppActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6868915432646362545L;

	@Inject("userService")
	private UserService userService;

	private Integer userIndex;
	private String userId;
	private String password;
	private String emailAddress;
	private String userName;

	public String display() {
		return SUCCESS;
	}

	public String doRegister() throws Exception {

		try {
			userService.createUser(new UserMaster(userId, password, emailAddress, userName));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (userId == null || userId.length() == 0)
			addFieldError("userId", "User id can not be null");
		if (password == null || password.length() == 0)
			addFieldError("password", "password can not be null");
		if (emailAddress == null || emailAddress.length() == 0)
			addFieldError("emailAddress", "emailAddress can not be null");
		if (userName == null || userName.length() == 0)
			addFieldError(userName, "userName can not be null");
	}

	public Integer getUserIndex() {
		return userIndex;
	}

	public void setUserIndex(Integer userIndex) {
		this.userIndex = userIndex;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
