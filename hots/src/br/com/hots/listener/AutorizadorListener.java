package br.com.hots.listener;

import java.io.Serializable;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import br.com.hots.bean.autenticacao.UsuarioLogadoBean;

public class AutorizadorListener implements PhaseListener, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioLogadoBean usuarioLogadoBean;
	@Inject
	private FacesContext context;
	@Inject
	private NavigationHandler handler;

	@Override
	public void afterPhase(PhaseEvent event) {
		if ("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}

		if (!usuarioLogadoBean.isLogado()) {
			handler.handleNavigation(context, null, "/login?faces-redirect=true");
			context.renderResponse();
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}