package com.wft.ui.forms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.userdetails.ldap.Person;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.BaseTheme;
import com.wft.model.BaseEntity;
import com.wft.model.user.User;
import com.wft.service.services.IAuthenticationService;
import com.wft.service.services.IUserService;

public class TemplateGridForm<T extends BaseEntity> extends VerticalLayout {

    T bean;

    public static final String COMMON_FIELD_WIDTH = "12em";
	private Button apply;

    public TemplateGridForm(T initBean, TemplateInternalFormWithGridLayout<T> internalForm) {

    	this.bean = initBean; // a person POJO    	
    	
        BeanItem<T> beanItem = new BeanItem<T>(this.bean); // item from POJO

        // Create the Form
        internalForm.setBeanItem(beanItem);
        final Form beanForm = internalForm;

        // Add form to layout
       addComponent(beanForm);

        // The cancel / apply buttons
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        Button discardChanges = new Button("Discard changes",
                new Button.ClickListener() {
                    public void buttonClick(ClickEvent event) {
                        beanForm.discard();
                    }
                });
        discardChanges.setStyleName(BaseTheme.BUTTON_LINK);
        buttons.addComponent(discardChanges);
        buttons.setComponentAlignment(discardChanges, Alignment.MIDDLE_LEFT);

        apply = new Button("Apply");
        buttons.addComponent(apply);

        beanForm.getFooter().setMargin(true);
        beanForm.getFooter().addComponent(buttons);

    }
    
    protected T getBean() {
    	return this.bean;
    }
    
    protected void setClickListener(Button.ClickListener clickListener) {
    	apply.addListener(clickListener);
    }
}
