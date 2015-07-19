package br.com.hots.generico.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public abstract class GenericBean {

	public Object getObjetoSessao(String chave) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		if (session == null) {
			return null;
		} else {
			return session.getAttribute(chave);
		}
	}

	public void addObjetoSessao(String chave, Object valor) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		removeObjetoSessao(chave);
		session.setAttribute(chave, valor);
	}

	public void removeObjetoSessao(String chave) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.removeAttribute(chave);
	}

	public void addMensagemINFO(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem));
	}

	public void addMensagemWARN(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, mensagem));
	}

	public void addMensagemERROR(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem));
	}

	public void addMensagemFATAL(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, mensagem, mensagem));
	}

}