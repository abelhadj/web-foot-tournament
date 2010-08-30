package com.wft.server.spring.hb4gwt;

import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import java.lang.reflect.Method;
import net.sf.gilead.core.PersistentBeanManager;
import net.sf.gilead.gwt.GileadRPCHelper;
import org.gwtwidgets.server.spring.GWTRPCServiceExporter;

public class HB4GWTRPCServiceExporter extends GWTRPCServiceExporter {

    private PersistentBeanManager beanManager;
    private boolean usingProxyClassLoader;

    public HB4GWTRPCServiceExporter() {
        this.usingProxyClassLoader = false;
    }

    public boolean isUsingProxyClassLoader() {
        return this.usingProxyClassLoader;
    }

    @Override
    public void afterPropertiesSet()
            throws Exception {
        super.afterPropertiesSet();
        if (getBeanManager() == null) {
            throw new Exception("HibernateBeanManager not set");
        }
        if (this.usingProxyClassLoader) {
            GileadRPCHelper.initClassLoader();
        }
    }

    public void setUsingProxyClassLoader(boolean usingProxyClassLoader) {
        this.usingProxyClassLoader = usingProxyClassLoader;
    }

    public PersistentBeanManager getBeanManager() {
        return this.beanManager;
    }

    public void setBeanManager(PersistentBeanManager beanManager) {
        this.beanManager = beanManager;
    }

    @Override
    public String invokeMethodOnService(Object service, Method targetMethod, Object[] targetParameters, RPCRequest rpcRequest) throws Exception {
        GileadRPCHelper.parseInputParameters(rpcRequest, this.beanManager, getThreadLocalRequest().getSession());
        Object result = targetMethod.invoke(service, targetParameters);
        result = GileadRPCHelper.parseReturnValue(result, this.beanManager);
        String encodedResult = RPC.encodeResponseForSuccess(rpcRequest.getMethod(), result, rpcRequest.getSerializationPolicy());

        return encodedResult;
    }
}
