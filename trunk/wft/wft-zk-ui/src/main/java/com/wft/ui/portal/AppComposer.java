package com.wft.ui.portal;

import org.springframework.context.annotation.Scope;
import org.zkoss.spring.util.GenericSpringComposer;
import org.zkoss.zk.ui.Component;

@org.springframework.stereotype.Component("appComposer")
@Scope("desktop")
public class AppComposer extends GenericSpringComposer  {

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		final Component finalComp = comp;

		
	}


	
	
}
