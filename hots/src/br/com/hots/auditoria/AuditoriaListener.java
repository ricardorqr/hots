package br.com.hots.auditoria;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.envers.RevisionListener;

import br.com.hots.bean.autenticacao.UsuarioLogadoBean;

@Named
public class AuditoriaListener implements RevisionListener, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioLogadoBean usuarioLogadoBean;
	
	@Override
	public void newRevision(Object object) {
		//Usuario usuario = usuarioLogadoBean.getUsuario();

		AuditoriaRevisao auditoriaRevisao = (AuditoriaRevisao) object;
		auditoriaRevisao.setLogin("teste");
	}

}