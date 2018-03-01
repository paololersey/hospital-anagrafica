package com.application.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.application.rest.ClientiRestService;
import com.application.rest.ContoCorrenteRestService;
import com.application.rest.MessageRestService;
import com.application.rest.ProdottiRestService;
import com.application.rest.ProvinceRestService;
import com.application.util.HibernateUtil;

public class BankingApplication extends Application {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();

		classes.add(ClientiRestService.class);
		classes.add(ProdottiRestService.class);
		classes.add(ProvinceRestService.class);
		classes.add(MessageRestService.class);
		classes.add(ContoCorrenteRestService.class);
		
		return classes;
	}

}
