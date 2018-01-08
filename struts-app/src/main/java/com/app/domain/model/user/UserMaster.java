package com.app.domain.model.user;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usermaster")
public class UserMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7742589885662777841L;

	@Id
	private Integer userIndex;
	private String userId;
	private String password;
	private String emailAddress;
	private String userName;
	private String mobileNo;

	public UserMaster() {
		// TODO Auto-generated constructor stub
	}

	public UserMaster(String userId, String password, String emailAddress, String userName, String mobileNo) {
		this.userId = userId;
		this.password = password;
		this.emailAddress = emailAddress;
		this.userName = userName;
		this.mobileNo = mobileNo;
	}

	public Integer getUserIndex() {
		return userIndex;
	}

	public void setUserIndex(Integer userIndex) {
		this.userIndex = userIndex;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}
