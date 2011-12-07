package com.wft.util;

import org.zkoss.zk.ui.Component;

public class WFTUIHelper {

  public static Component getChildByName(Component parent, String name) {

    for (Object child : parent.getChildren()) {
      if (!(child instanceof Component)) {
        continue;
      }
      Component childComp = (Component) child;
      if (name.equals(childComp.getId())) {
        return childComp;
      } else {
        Component comp = getChildByName(childComp, name);
        if (comp != null) {
          return comp;
        }
      }
    }
    
    return null;
  }
  
}
