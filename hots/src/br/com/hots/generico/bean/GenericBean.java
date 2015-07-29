package br.com.hots.generico.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class GenericBean {
	
	public String cancelar() {
		return "/template/principal?faces-redirect=true";
	}

	public void addMensagemINFO(String mensagem) {
		String prefixo = "Informação: ";
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, prefixo.concat(mensagem), prefixo.concat(mensagem)));
	}

	public void addMensagemWARN(String mensagem) {
		String prefixo = "Atenção: ";
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage(
						FacesMessage.SEVERITY_WARN, prefixo.concat(mensagem), prefixo.concat(mensagem)));
	}

	public void addMensagemERROR(String mensagem) {
		String prefixo = "ERRO: ";
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, prefixo.concat(mensagem), prefixo.concat(mensagem)));
	}

	public void addMensagemFATAL(String mensagem) {
		String prefixo = "ERRO FATAL: ";
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage(
						FacesMessage.SEVERITY_FATAL, prefixo.concat(mensagem), prefixo.concat(mensagem)));
	}

}