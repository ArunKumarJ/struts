package com.app.common.config;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.app.domain.model.user.NCounter;
import com.opensymphony.xwork2.inject.Inject;

public class NextKeyGenServiceImpl implements NextKeyGenService {

	@Inject("hibernateService")
	private HibernateService hibernateService;

	public Integer getNextKey(String key) throws Exception {
		NCounter nCounter = null;
		try {
			Session session = hibernateService.getSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<NCounter> query = cb.createQuery(NCounter.class);
			Root<NCounter> root = query.from(NCounter.class);
			query.select(root);
			ParameterExpression<String> p = cb.parameter(String.class);
			query.where(cb.equal(root.get("key"), p));

			TypedQuery<NCounter> typedQuery = session.createQuery(query);
			typedQuery.setParameter(p, key);

			nCounter = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			// ignore
		} catch (Exception e) {
			throw e;
		}
		nCounter = createNextkey(key, nCounter);

		return nCounter.getNext();
	}

	private NCounter createNextkey(String key, NCounter nCounter) {
		if (nCounter == null) {
			nCounter = new NCounter(key, 0);
		}
		nCounter.setNext(nCounter.getNext() + 1);
		hibernateService.getSession().save(nCounter);
		return nCounter;
	}

}
