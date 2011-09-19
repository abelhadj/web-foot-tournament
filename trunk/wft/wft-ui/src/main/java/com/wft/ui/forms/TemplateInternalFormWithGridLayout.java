package com.wft.ui.forms;

import java.util.Arrays;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.GridLayout;

public abstract class TemplateInternalFormWithGridLayout<T> extends Form {

        private GridLayout ourLayout;

        public TemplateInternalFormWithGridLayout(int columns, int rows, FormFieldFactory formFieldFactory) {
//            setCaption("Personal details");

            ourLayout = new GridLayout(columns, rows);

            // Use top-left margin and spacing
            ourLayout.setMargin(true, false, false, true);
            ourLayout.setSpacing(true);

            setLayout(ourLayout);

            // Set up buffering
            setWriteThrough(false); // we want explicit 'apply'
            setInvalidCommitted(false); // no invalid values in datamodel

            // FieldFactory for customizing the fields and adding validators
            setFormFieldFactory(formFieldFactory);

            // Determines which properties are shown, and in which order:
            setVisibleItemProperties(Arrays.asList(new String[] { "firstName",
                    "lastName", /*"countryCode",*/ "password", /*"birthdate",
                    "shoesize"*/ }));

        }

        protected void setBeanItem(BeanItem<T> beanItem) {
            setItemDataSource(beanItem); // bind to POJO via BeanItem
        }
        
        protected GridLayout getGridLayout() {
        	return ourLayout;
        }

    }