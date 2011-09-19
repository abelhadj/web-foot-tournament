package com.wft.service.services;

import javax.sql.DataSource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.wft.model.team.TeamRepository;
import com.wft.model.user.Administrator;
import com.wft.model.user.User;
import com.wft.service.dao.ITeamRepositoryDAO;
import com.wft.service.dao.IUserDAO;
import com.wft.service.services.impl.InitTeamRepositoryFeeder;

public class TestDAO extends
		AbstractTransactionalDataSourceSpringContextTests {

	@Autowired
	public void setDataSource(@Qualifier("txDataSource") DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private ITeamRepositoryDAO teamRepositoryDAO;

	@Autowired
	private ITeamRepositoryService iTeamRepositoryService;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	protected String[] getConfigLocations() {
		return new String[] { "classpath*:applicationContext-persistence.xml",
				"classpath*:datasource_mysql.xml" };
	}

	@Override
	protected boolean isDefaultRollback() {
		return false;
	}

	@Override
	protected boolean isRollback() {
		return false;
	}


	public void test1() {
		Administrator admin = new Administrator();
		admin.setLogin("admin");
		admin.setPassword("admin");
		User user1 = new User();
		user1.setLogin("user1");
		user1.setPassword("user1");
		User user2 = new User();
		user2.setLogin("user2");
		user2.setPassword("user2");

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
		// dao.add(user2);

		System.out.println();
		assertTrue(true);
	}

	public void test2() {
		if (CollectionUtils.isEmpty(teamRepositoryDAO.findAll())) {
			for (TeamRepository repo : InitTeamRepositoryFeeder.getData()) {
				teamRepositoryDAO.add(repo);
			}
		}
		
		assertTrue(CollectionUtils.isNotEmpty(iTeamRepositoryService.getAllRepositoriesName()));
	}
}
