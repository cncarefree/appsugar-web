package org.appsugar.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

/**
 * 
 * @author NewYoung
 * 2016年2月24日下午6:53:52
 */
@Component
public class HibernateContext {

	@PersistenceContext
	private EntityManager em;

	/**
	 * 获取当前session
	 */
	public Session getSession() {
		return em.unwrap(Session.class);
	}
}
