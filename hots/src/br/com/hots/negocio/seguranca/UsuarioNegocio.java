package br.com.hots.negocio.seguranca;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.crypto.hash.Sha256Hash;

import br.com.hots.dao.UsuarioDAO;
import br.com.hots.modelo.seguranca.Usuario;

@Named
public class UsuarioNegocio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDAO usuarioDAO;

	public void cadastrarUsuario(Usuario usuario) {
		usuario.setSenha(new Sha256Hash(usuario.getSenha()).toHex());
		usuarioDAO.salvar(usuario);
	}
	
	public void editarUsuario(Usuario usuario) {
		usuario.setSenha(new Sha256Hash(usuario.getSenha()).toHex());
		usuarioDAO.atualizar(usuario);
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