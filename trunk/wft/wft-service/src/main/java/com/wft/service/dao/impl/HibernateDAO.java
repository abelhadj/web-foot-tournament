package com.wft.service.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 */
@Transactional(propagation = Propagation.MANDATORY)
public class HibernateDAO extends HibernateDaoSupport {

	@Autowired
	public void setAutoWiredSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	private Session session = null;

	public Session getCurrentSession() {
		if (session == null) {
			return getSession();
		} else {
			if (session.isOpen()) {
				return session;
			} else {
				throw new HibernateException("Session is closed " + session);
			}
		}
	}

	/**
	 * @param _session
	 *            the session to set
	 */
	public void setCurrentSession(Session _session) {
		session = _session;
	}

	/**
	 * 
	 */
	public void closeCurrentSession() {
		if (session != null && session.isOpen()) {
			session.close();
			session = null;
		}
	}

}
