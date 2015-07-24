package br.com.hots.generico.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class GenericBean {
	
	public String cancelar() {
		return "/template/principal?faces-redirect=true";
	}

	public void addMensagemINFO(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem));
	}

	public void addMensagemWARN(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, mensagem));
	}

	public void addMensagemERROR(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem));
	}

	public void addMensagemFATAL(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage(FacesMessage.SEVERITY_FATAL, mensagem, mensagem));
	}

}