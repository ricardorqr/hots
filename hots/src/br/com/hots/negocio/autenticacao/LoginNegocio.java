package br.com.hots.negocio.autenticacao;

import javax.inject.Inject;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import br.com.hots.modelo.seguranca.Usuario;

public class LoginNegocio {
	
	@Inject
	private Subject currentUser;

	public void login(Usuario usuario) throws AuthenticationException {
		UsernamePasswordToken token = new UsernamePasswordToken(usuario.getLogin(), usuario.getSenha(), false);
		currentUser.login(token);
	}

}