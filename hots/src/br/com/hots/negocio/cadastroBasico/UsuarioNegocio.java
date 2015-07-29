package br.com.hots.negocio.cadastroBasico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.dao.UsuarioDAO;
import br.com.hots.modelo.Usuario;

@Named
public class UsuarioNegocio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDAO usuarioDAO;

	public void cadastrarUsuario(Usuario universo) {
		usuarioDAO.salvar(universo);
	}
	
	public void editarUsuario(Usuario universo) {
		usuarioDAO.atualizar(universo);
	}
	
	public void removerUsuario(Integer id) {
		Usuario usuario = usuarioDAO.buscar(id);
		usuarioDAO.remover(usuario);
	}
	
	public List<Usuario> getListaTodos() {
		return usuarioDAO.getListaTodos();
	}
	
	public List<Usuario> getListaTodosAtivos() {
		return usuarioDAO.getListaTodosAtivos();
	}

}