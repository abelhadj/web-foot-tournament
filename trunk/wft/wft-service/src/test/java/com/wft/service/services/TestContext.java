package com.wft.service.services;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wft.model.user.User;
import com.wft.service.dao.impl.UserDAO;


public class TestContext extends TestCase {

	public void test() {
		ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext(new String[]{"applicationContext_GWT.xml", "myapp-persistence-tech.xml", "datasource_mysql.xml"});

		UserDAO dao = (UserDAO) ctxt.getBean("userDAO");
		for (User user : dao.findAll())
		{
			dao.delete(user);
		}
//		Administrator admin = new Administrator("admin", "admin");
		User user1 = new User("user1","user1");
		User user2 = new User("user2","user2");
//		this.getDao().add(admin);
		dao.add(user1);
		dao.add(user2);

		System.out.println();
		assertTrue(true);
	}
}
