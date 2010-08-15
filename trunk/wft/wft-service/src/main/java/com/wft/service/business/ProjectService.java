package com.wft.service.business;

import java.util.List;

import org.springframework.security.annotation.Secured;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.wft.model.Project;
import com.wft.service.business.exception.ServiceSecurityException;

/**
 * Services related to projects operations
 * 
 * @version 1.0
 */
@RemoteServiceRelativePath("ProjectService.rpc")
public interface ProjectService extends RemoteService
{

    /**
     * @return the list of projects available
     * @throws ServiceSecurityException 
     */
    @Secured("ROLE_ADMIN")
    List<Project> fetch() throws ServiceSecurityException;

    /**
     * 
     * @param record the project to add
     * @return the record added and potentially modified on server side
     * @throws ServiceSecurityException
     */
    @Secured("ROLE_ADMIN")
    Project add(Project record) throws ServiceSecurityException;

    /**
     * @param record the project to update
     * @return the record updated and potentially modified on server side
     * @throws ServiceSecurityException
     */
    @Secured("ROLE_ADMIN")
    Project update(Project record) throws ServiceSecurityException;

    /**
     * @param record the record to remove
     * @throws ServiceSecurityException
     */
    @Secured("ROLE_ADMIN")
    void remove(Project record) throws ServiceSecurityException;
}
