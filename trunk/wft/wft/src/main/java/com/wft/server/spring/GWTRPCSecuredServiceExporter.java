package com.wft.server.spring;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.security.SpringSecurityException;

import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.wft.server.spring.hb4gwt.HB4GWTRPCServiceExporter;
import com.wft.service.business.exception.ServiceSecurityException;

public class GWTRPCSecuredServiceExporter extends HB4GWTRPCServiceExporter
{
    /* (non-Javadoc)
     * @see org.gwtwidgets.server.spring.GWTRPCServiceExporter#handleInvocationTargetException(java.lang.reflect.InvocationTargetException, java.lang.Object, java.lang.reflect.Method, com.google.gwt.user.server.rpc.RPCRequest)
     */
    @Override
    protected String handleInvocationTargetException(InvocationTargetException e, Object service, Method targetMethod, RPCRequest rpcRequest) throws Exception
    {
        Throwable cause = e.getCause();
        if (cause instanceof SpringSecurityException)
        {
            String failurePayload = RPC.encodeResponseForFailure(rpcRequest.getMethod(), 
                                                                 new ServiceSecurityException(cause.getMessage()), 
                                                                 rpcRequest.getSerializationPolicy());
            return failurePayload;
        }
        else
        {
            return super.handleInvocationTargetException(e, service, targetMethod, rpcRequest);
        }
    }
}
