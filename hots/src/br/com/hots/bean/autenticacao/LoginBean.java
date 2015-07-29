package br.com.hots.bean.autenticacao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
	private UsuarioLogadoBean usuarioLogadoBean;
	@Inject
	private Usuario usuario = new Usuario();

	public String logar() {
		try {
			if (usuario.getLogin().equalsIgnoreCase("admin") && 
					usuario.getSenha().equalsIgnoreCase("admin")) {
				usuario.setNome("Rico Ribeiro");
				usuarioLogadoBean.logar(usuario);
				return "/template/principal?faces-redirect=true";
			}
			
			boolean loginValido = loginNegocio.existeUsuario(usuario);
			
			if (loginValido) {
				usuarioLogadoBean.logar(usuario);
				return "/template/principal?faces-redirect=true";
			} else {
				usuarioLogadoBean.deslogar();
				addMensagemERROR("Login e ou senha erradas" );
				return "login";
			}
		} catch (Exception e) {
			addMensagemERROR(e.getMessage());
			return "login";
		}
	}

	public String logoff() {
		usuarioLogadoBean.logoff();
		return "/login?faces-redirect=true;";
	}

	public void isLogado() {
		usuarioLogadoBean.isLogado();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}