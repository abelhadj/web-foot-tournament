package com.wft.service.services;

import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.wft.model.Project;
import com.wft.model.user.Administrator;
import com.wft.model.user.User;
import com.wft.service.dao.IProjectDAO;
import com.wft.service.dao.IUserDAO;


public class TestContext extends AbstractTransactionalDataSourceSpringContextTests {

	  private IUserDAO userDAO;
	  private IProjectDAO projectDAO;
	  private SessionFactory sessionFactory = null;

	  protected String[] getConfigLocations() {
	      return new String[]{"myapp-persistence-tech.xml", "datasource_mysql.xml"};
	  }


	@Override
	protected boolean isDefaultRollback() {
		return false;
	}


	@Override
	protected boolean isRollback() {
		return false;
	}


	/**
	   * Spring will automatically inject userDAO object on startup
	   * @param userDAO
	   */
	  public void setUserDAO(IUserDAO userDAO) {
	      this.userDAO = userDAO;
	  }

	  /**
	   * Spring will automatically inject projectDAO object on startup
	   * @param projectDAO
	   */
	  public void setProjectDAO(IProjectDAO projectDAO) {
	      this.projectDAO = projectDAO;
	  }

	  /**
	   * Spring will automatically inject the Hibernate session factory on startup
	   * @param sessionFactory
	   */
	  public void setSessionFactory(SessionFactory sessionFactory) {
	      this.sessionFactory = sessionFactory;
	  }
	  
	public void test1() {
		Administrator admin = new Administrator("admin", "admin");
		User user1 = new User("user1","user1");
		User user2 = new User("user2","user2");

		for (User user : userDAO.findAll())
		{
			if (user instanceof Administrator) {
				System.out.println("Deleting administrator");
			} else {
				System.out.println("Deleting user");
			}
			userDAO.delete(user);
		}
		userDAO.add(user1);
		userDAO.add(admin);
//		dao.add(user2);

		System.out.println();
		assertTrue(true);
	}

	public void _test2() {
		Project p = new Project();
		p.setDesc("desc");

		for (Project project : projectDAO.findAll())
		{
			projectDAO.delete(project);
		}
//		this.getDao().add(admin);
//		dao.add(user1);
		projectDAO.add(p);
		
		System.out.println();
		assertTrue(true);
	}
}
