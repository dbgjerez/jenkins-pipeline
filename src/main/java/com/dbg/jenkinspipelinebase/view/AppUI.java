package com.dbg.jenkinspipelinebase.view;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbg.jenkinspipelinebase.dao.TranslateDao;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
public class AppUI extends UI {

	private static final NativeSelect<String> SELECT = new NativeSelect<>();
	private static final TextField T_FIELD = new TextField();

	private static final long serialVersionUID = 8283544339996644259L;

	@Autowired
	TranslateDao dao;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout vLayout = new VerticalLayout();
		final HorizontalLayout hLayout = new HorizontalLayout();
		SELECT.setItems(Arrays.asList("de", "en"));
		SELECT.setSelectedItem("1");
		hLayout.addComponent(SELECT);
		hLayout.addComponent(T_FIELD);
		final Button btn = new Button("Traducir");
		hLayout.addComponent(btn);

		vLayout.addComponent(hLayout);

		setContent(vLayout);
	}

}
