package br.com.hots.negocio.autenticacao;

import javax.inject.Inject;

import br.com.hots.dao.UsuarioDAO;
import br.com.hots.modelo.Usuario;

public class LoginNegocio {

	@Inject
	private UsuarioDAO usuarioDAO;

	public boolean existeUsuario(Usuario usuario) {
		Usuario usuarios = getUsuarioPorLogin(usuario.getLogin());
		
		if (usuarios == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public Usuario getUsuarioPorLogin(String usuario) {
		return usuarioDAO.getUsuarioPorLogin(usuario);
	}

}