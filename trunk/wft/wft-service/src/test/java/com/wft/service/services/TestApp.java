package com.wft.service.services;

import org.junit.Ignore;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wft.model.Project;
import com.wft.model.user.Administrator;
import com.wft.model.user.User;
import com.wft.service.dao.IProjectDAO;
import com.wft.service.dao.IUserDAO;

@Ignore
public class TestApp {
public static void main(String[] args) {
	ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext(new String[] { "myapp-persistence-tech.xml",
				"datasource_mysql.xml" });
	ctxt.getBean("sessionFactory");
	IProjectDAO projectDAO = (IProjectDAO) ctxt.getBean("projectDAO");
	
	Project p = new Project();
	p.setDesc("desc");

	for (Project project : projectDAO.findAll()) {
		projectDAO.delete(project);
	}
	// this.getDao().add(admin);
	// dao.add(user1);
	projectDAO.add(p);

	IUserDAO userDAO = (IUserDAO) ctxt.getBean("userDAO");
	Administrator admin = new Administrator("admin", "admin");
	User user1 = new User("user1", "user1");
	User user2 = new User("user2", "user2");

	for (User user : userDAO.findAll()) {
		if (user instanceof Administrator) {
			System.out.println("Deleting administrator");
		} else {
			System.out.println("Deleting user");
		}
		userDAO.delete(user);
	}
	userDAO.add(user1);
	userDAO.add(admin);

	
	
	System.out.println();

}
}
