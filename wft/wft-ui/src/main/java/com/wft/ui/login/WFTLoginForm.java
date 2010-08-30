package com.wft.ui.login;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window.Notification;
import com.wft.model.ReturnMemento;
import com.wft.service.services.AuthenticationService;

@SuppressWarnings("serial")
public class WFTLoginForm extends Form {

	private static final String COMMON_FIELD_WIDTH = "12em";

	private UserLogin userLogin;

	private transient AuthenticationService authenticationService;

	public WFTLoginForm(AuthenticationService authenticationService) {
		super();
		
		this.authenticationService = authenticationService;

		userLogin = new UserLogin();
		BeanItem<UserLogin> userLoginItem = new BeanItem<UserLogin>(userLogin);
		setCaption("Login");
		setFormFieldFactory(new UserLoginFieldFactory());
		setItemDataSource(userLoginItem);
		setVisibleItemProperties(Arrays.asList(new String[] { "login",
				"password" }));

		// The cancel / apply buttons
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.setSpacing(true);
		Button discardChanges = new Button("Discard changes",
				new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						try {
							discard();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
		buttons.addComponent(discardChanges);
		buttons.setComponentAlignment(discardChanges, "middle");

		Button apply = new Button("Apply", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				try {
					commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		buttons.addComponent(apply);
		getFooter().addComponent(buttons);
		getFooter().setMargin(false, false, true, true);
	}

	private class UserLoginFieldFactory extends DefaultFieldFactory {

		public UserLoginFieldFactory() {
		}

		@Override
		public Field createField(Item item, Object propertyId,
				Component uiContext) {
			Field f = super.createField(item, propertyId, uiContext);
			if ("login".equals(propertyId)) {
				TextField tf = (TextField) f;
				tf.setRequired(true);
				tf.setRequiredError("Please enter a Login");
				tf.setWidth(COMMON_FIELD_WIDTH);
			} else if ("password".equals(propertyId)) {
				TextField tf = (TextField) f;
				tf.setSecret(true);
				tf.setRequired(true);
				tf.setRequiredError("Please enter a password");
				tf.setWidth(COMMON_FIELD_WIDTH);
			}
			return f;
		}
	}

	@Override
	public void commit() throws SourceException {
		super.commit();

		ReturnMemento ret = authenticationService.authenticate(
				userLogin.getLogin(), userLogin.getPassword());
		if (ret.getCode() == ReturnMemento.CODE_SUCCESS) {
			getApplication().getMainWindow().showNotification(
					"Authentication succesful",
					"Username: " + userLogin.getLogin() + ", password: "
							+ userLogin.getPassword(),
					Notification.TYPE_HUMANIZED_MESSAGE);
		} else {
			getApplication().getMainWindow().showNotification(
					"Authentication failed !",
					"Username: " + userLogin.getLogin() + ", password: "
							+ userLogin.getPassword(),
					Notification.TYPE_ERROR_MESSAGE);
		}
	}

}
