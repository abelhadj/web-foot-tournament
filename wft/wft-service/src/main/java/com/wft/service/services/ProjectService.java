package com.wft.service.services;

import java.util.List;

import org.springframework.security.annotation.Secured;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wft.model.Project;
import com.wft.service.services.exception.ServiceSecurityException;

/**
 * Services related to projects operations
 * 
 * @version 1.0
 */
public interface ProjectService {

	/**
	 * @return the list of projects available
	 * @throws ServiceSecurityException
	 */
	@Secured("ROLE_ADMINISTRATOR")
	List<Project> fetch() throws ServiceSecurityException;

	/**
	 * 
	 * @param record
	 *            the project to add
	 * @return the record added and potentially modified on server side
	 * @throws ServiceSecurityException
	 */
	@Secured("ROLE_ADMINISTRATOR")
	Project add(Project record) throws ServiceSecurityException;

	/**
	 * @param record
	 *            the project to update
	 * @return the record updated and potentially modified on server side
	 * @throws ServiceSecurityException
	 */
	@Secured("ROLE_ADMINISTRATOR")
	Project update(Project record) throws ServiceSecurityException;

	/**
	 * @param record
	 *            the record to remove
	 * @throws ServiceSecurityException
	 */
	@Secured("ROLE_ADMINISTRATOR")
	void remove(Project record) throws ServiceSecurityException;
}
