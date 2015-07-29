package br.com.hots.negocio.autenticacao;

import javax.inject.Inject;

import br.com.hots.dao.UsuarioDAO;
import br.com.hots.exception.HotsException;
import br.com.hots.modelo.Usuario;

public class LoginNegocio {

	@Inject
	private UsuarioDAO usuarioDAO;

	public boolean existeUsuario(Usuario usuario) throws HotsException {
		Usuario usuarioBanco = usuarioDAO.getUsuarioPorLogin(usuario.getLogin());
		
		if (usuarioBanco == null) {
			throw new HotsException("Login não cadastrado");
		} else {
			if (usuarioBanco.getSenha().equals(usuario.getSenha())) {
				return true;
			} else {
				throw new HotsException("Senha digitada errada");
			}
		}
	}

}