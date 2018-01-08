package com.app.service.user;

import com.app.domain.model.user.UserMaster;

public interface UserService {

	public UserMaster createUser(UserMaster master) throws Exception;

	public UserMaster getUser(Integer userIndex);

	public void deleteUser(Integer userIndex);

	public void updateUser(UserMaster userMaster);

	public UserMaster doLogin(String userId, String password);
}
