package com.wft.service.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 */
@Transactional(propagation = Propagation.SUPPORTS)
public class HibernateDAO extends HibernateDaoSupport {

//	@Autowired
//	protected HibernateTemplate hibernateTemplate;

	@Autowired
	public void setAutoWiredHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}
	
//	@Autowired
//	private SessionFactory sessionFactory;
//
//	public Session getCurrentSession() {
//		return hibernateTemplate.getSessionFactory().getCurrentSession();
//	}

}
