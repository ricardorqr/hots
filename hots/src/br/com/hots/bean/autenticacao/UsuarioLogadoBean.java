package br.com.hots.bean.autenticacao;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.hots.modelo.seguranca.Usuario;

@Named
@SessionScoped
public class UsuarioLogadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private HttpSession session;
	private Usuario usuario;

	public void logar(Usuario usuario) {
		this.usuario = usuario;
	}

	public void deslogar() {
		this.usuario = null;
	}

	public boolean isLogado() {
		return usuario != null;
	}
	
	public void logoff() {
		session.invalidate();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

}