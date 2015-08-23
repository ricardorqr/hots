package br.com.hots.auditoria;

import java.io.Serializable;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hibernate.envers.RevisionListener;

import br.com.hots.modelo.auditoria.AuditoriaRevisao;

public class AuditoriaListener implements RevisionListener, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void newRevision(Object object) {
		Subject currentUser = SecurityUtils.getSubject();
		AuditoriaRevisao auditoriaRevisao = (AuditoriaRevisao) object;
		auditoriaRevisao.setLogin(currentUser.getPrincipal().toString());
	}

}