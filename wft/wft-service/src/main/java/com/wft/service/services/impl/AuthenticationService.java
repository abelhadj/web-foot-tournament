package com.wft.service.services.impl;

import java.util.Vector;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.context.SecurityContextImpl;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wft.model.ReturnMemento;
import com.wft.model.user.Administrator;
import com.wft.model.user.User;
import com.wft.service.core.ICommonService;
import com.wft.service.core.impl.ServiceImpl;
import com.wft.service.dao.IUserDAO;
import com.wft.service.services.IAuthenticationService;

/**
 * {@link IAuthenticationService} implementation.
 * 
 */
@Service("authenticationService")
@Transactional(propagation = Propagation.REQUIRED)
public class AuthenticationService extends ServiceImpl<User> implements
		IAuthenticationService, InitializingBean {

	@Autowired
	private IUserDAO userDAO;

	public void afterPropertiesSet() throws Exception {
		this.setDao(userDAO);
		Administrator admin = new Administrator();
		admin.setLogin("admin");
		admin.setPassword("admin");
		admin.setFirstName("Guillaume");
		admin.setLastName("Cernier");
		User user = new User();
		user.setLogin("user");
		user.setPassword("user");
		this.dao.add(admin);
		this.dao.add(user);
	}

	public ReturnMemento authenticate(String username, String password) {
		User user = userDAO.findByLogin(username);
		if (user != null) {
			if (password != null && password.equals(user.getPassword())) {
				GrantedAuthority[] grantedAuthorities = getGrantedAuthorities(user
						.getRoleName());
				org.springframework.security.userdetails.User userCtxt = new org.springframework.security.userdetails.User(
						user.getLogin(), user.getPassword(), true, true, true,
						true, grantedAuthorities);
				Authentication auth = new UsernamePasswordAuthenticationToken(
						userCtxt, password, grantedAuthorities);
				SecurityContext sc = new SecurityContextImpl();
				sc.setAuthentication(auth);
				SecurityContextHolder.setContext(sc);

				return new ReturnMemento(ReturnMemento.CODE_SUCCESS,
						ReturnMemento.CODE_SUCCESS);
			}
		}
		ReturnMemento rm = new ReturnMemento(ReturnMemento.CODE_ERROR,
				ReturnMemento.CODE_ERROR);
		rm.getErrors().put("login", "login or password incorrect");
		rm.getErrors().put("password", "login or password incorrect");
		return rm;
	}

	public void logout() {
		SecurityContextHolder.clearContext();
	}

	private GrantedAuthority[] getGrantedAuthorities(String roleName) {
		Vector<GrantedAuthority> auths = new Vector<GrantedAuthority>();
		if ("ROLE_USER".equals(roleName)) {
			auths.add(new GrantedAuthorityImpl("ROLE_USER"));
		}
		if ("ROLE_ADMINISTRATOR".equals(roleName)) {
			auths.add(new GrantedAuthorityImpl("ROLE_USER"));
			auths.add(new GrantedAuthorityImpl("ROLE_ADMINISTRATOR"));
		}
		return auths.toArray(new GrantedAuthority[] {});
	}

}
