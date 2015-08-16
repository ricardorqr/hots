package br.com.hots.bean.autenticacao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;

import br.com.hots.generico.bean.GenericBean;
import br.com.hots.modelo.Usuario;
import br.com.hots.negocio.autenticacao.LoginNegocio;

@Named
@RequestScoped
public class LoginBean extends GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LoginNegocio loginNegocio;
	@Inject
	private Usuario usuario = new Usuario();
	@Inject
	private Subject currentUser;

	public String logar() {
		try {
			loginNegocio.login(usuario);
			return "/template/principal?faces-redirect=true";
		} catch (AuthenticationException ae) {
			addMensagemERROR("Login ou senha incorretos: " + ae.getMessage());
			return "login";
		} catch (Exception e) {
			addMensagemFATAL(e.getMessage());
			return "login";
		}
	}

	public String logoff() {
		currentUser.logout();
		return "/login?faces-redirect=true;";
	}

	public void isLogado() {
		currentUser.isAuthenticated();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}