package br.com.hots.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

public class JSFUtil {

	private FacesContext context = FacesContext.getCurrentInstance();

	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return context;
	}

	@Produces
	@RequestScoped
	public NavigationHandler getNavigationHandler() {
		return context.getApplication().getNavigationHandler();
	}
}
