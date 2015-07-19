package br.com.hots.bean.autenticacao;

import javax.faces.bean.ManagedBean;

import br.com.hots.generico.bean.GenericBean;

@ManagedBean
public class LoginBean extends GenericBean {

	private String login;
	private String senha;

	public String logar() {
		System.out.println(login);
		System.out.println(senha);
		
		addObjetoSessao("login", login);
		
		return "/paginas/principal.xhtml?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
