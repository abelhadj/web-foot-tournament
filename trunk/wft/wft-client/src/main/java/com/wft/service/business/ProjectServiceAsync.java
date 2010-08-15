package com.wft.service.business;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.wft.model.Project;

public interface ProjectServiceAsync {

    public abstract void fetch (AsyncCallback<List<Project>> asyncCallback);

    public abstract void add (Project record, AsyncCallback<Project> asyncCallback);

    public abstract void update (Project record, AsyncCallback<Project> asyncCallback);

    public abstract void remove (Project record, AsyncCallback<Object> asyncCallback);
}