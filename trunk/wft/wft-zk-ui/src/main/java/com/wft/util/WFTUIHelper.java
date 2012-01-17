package com.wft.util;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventQueues;

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

  public static void publishEventToApplication(String eventName, Object data) {
    EventQueues.lookup(WFTEventUtil.WFT_APPLICATION, EventQueues.APPLICATION,
        true).publish(new Event(eventName, null, data));

  }

}
