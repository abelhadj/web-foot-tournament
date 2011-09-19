package com.wft.ui.forms.user;


import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Item;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.wft.model.user.User;
import com.wft.service.services.IUserService;
import com.wft.ui.forms.TemplateGridForm;
import com.wft.ui.forms.TemplateInternalFormWithGridLayout;
import com.wft.util.WFTUIHelper;

public class CreateUserForm extends TemplateGridForm<User> {

	private transient IUserService iUserService = WFTUIHelper
	.getApplicationServiceProvider().getUserService();

	public CreateUserForm() {
		super(new User(), new CreateUserInternalForm());
		this.setClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				final User user = CreateUserForm.this.getBean();
				iUserService.createNewUser(user);
			}
		});
	}

	private static class CreateUserInternalForm extends
			TemplateInternalFormWithGridLayout<User> {

		public CreateUserInternalForm() {
			super(3, 3, new CreateUserFieldFactory());
			// TODO Auto-generated constructor stub
		}

		/*
		 * Override to get control over where fields are placed.
		 */
		@Override
		protected void attachField(Object propertyId, Field field) {
			if (propertyId.equals("firstName")) {
				this.getGridLayout().addComponent(field, 0, 0);
			} else if (propertyId.equals("lastName")) {
				this.getGridLayout().addComponent(field, 1, 0, 2, 0);
			} else if (propertyId.equals("password")) {
				this.getGridLayout().addComponent(field, 0, 2);
			}
		}
	}

	private static class CreateUserFieldFactory extends DefaultFieldFactory {

		public CreateUserFieldFactory() {
		}

		@Override
		public Field createField(Item item, Object propertyId,
				Component uiContext) {
			Field f;
			if ("password".equals(propertyId)) {
				// Create a password field so the password is not shown
				f = createPasswordField(propertyId);
			} else {
				// Use the super class to create a suitable field base on the
				// property type.
				f = super.createField(item, propertyId, uiContext);
			}

			if ("firstName".equals(propertyId)) {
				TextField tf = (TextField) f;
				tf.setRequired(true);
				tf.setRequiredError("Please enter a First Name");
				tf.setWidth(COMMON_FIELD_WIDTH);
				tf.addValidator(new StringLengthValidator(
						"First Name must be 3-25 characters", 3, 25, false));
			} else if ("lastName".equals(propertyId)) {
				TextField tf = (TextField) f;
				tf.setRequired(true);
				tf.setRequiredError("Please enter a Last Name");
				tf.setWidth(COMMON_FIELD_WIDTH);
				tf.addValidator(new StringLengthValidator(
						"Last Name must be 3-50 characters", 3, 50, false));
			} else if ("password".equals(propertyId)) {
				PasswordField pf = (PasswordField) f;
				pf.setRequired(true);
				pf.setRequiredError("Please enter a password");
				pf.setWidth("10em");
				pf.addValidator(new StringLengthValidator(
						"Password must be 6-20 characters", 6, 20, false));
			}

			return f;
		}

		private PasswordField createPasswordField(Object propertyId) {
			PasswordField pf = new PasswordField();
			pf.setCaption(DefaultFieldFactory
					.createCaptionByPropertyId(propertyId));
			return pf;
		}
	}
}
