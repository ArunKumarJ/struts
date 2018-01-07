package com.app.service.user;

import org.hibernate.Session;

import com.app.common.config.HibernateService;
import com.app.common.config.NextKeyGenService;
import com.app.domain.model.user.UserMaster;
import com.opensymphony.xwork2.inject.Inject;

public class UserServiceImpl implements UserService {

	@Inject("nextKeyGenService")
	private NextKeyGenService nextKeyGenService;
	@Inject("hibernateService")
	private HibernateService hibernateService;

	@Override
	public UserMaster createUser(UserMaster master) throws Exception {
		Session session = hibernateService.getSession();
		try {
			session.getTransaction().begin();
			Integer pk = nextKeyGenService.getNextKey("usermaster");
			master.setUserIndex(pk);
			hibernateService.getSession().save(master);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return master;
	}

	@Override
	public UserMaster getUser(Integer userIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(UserMaster userMaster) {
		// TODO Auto-generated method stub

	}

}
