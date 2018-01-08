package com.app.service.user;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

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

	@Override
	public UserMaster doLogin(String userId, String password) {
		UserMaster userMaster = null;
		CriteriaBuilder cb = hibernateService.getCriteriaBuilder();
		CriteriaQuery<UserMaster> query = cb.createQuery(UserMaster.class);
		Root<UserMaster> root = query.from(UserMaster.class);
		query.select(root);

		ParameterExpression<String> userIdParam = cb.parameter(String.class);
		ParameterExpression<String> pwdParam = cb.parameter(String.class);

		query.where(cb.and(cb.equal(root.get("userId"), userIdParam), cb.equal(root.get("password"), pwdParam)));

		TypedQuery<UserMaster> typedQuery = hibernateService.getSession().createQuery(query);
		typedQuery.setParameter(userIdParam, userId);
		typedQuery.setParameter(pwdParam, password);

		try {
			userMaster = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			// ignore ;)
		}
		return userMaster;
	}

}
