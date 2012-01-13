package com.wft.ui.portal;

import org.springframework.context.annotation.Scope;
import org.zkoss.spring.util.GenericSpringComposer;
import org.zkoss.zk.ui.Component;

@org.springframework.stereotype.Component("portalProfileComposer")
@Scope("desktop")
public class PortalProfileComposer extends GenericSpringComposer {

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}

}
