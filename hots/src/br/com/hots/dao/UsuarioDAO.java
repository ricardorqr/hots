package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.hots.modelo.Usuario;

@Stateless
public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Usuario buscar(Integer id) {
		return manager.find(Usuario.class, id);
	}

	public void salvar(Usuario entidade) {
		manager.joinTransaction();
		manager.persist(entidade);
	}

	public void atualizar(Usuario entidade) {
		manager.joinTransaction();
		manager.merge(entidade);
	}
	
	public void remover(Integer id) {
		manager.joinTransaction();
		Usuario usuario = buscar(id);
		manager.remove(usuario);
	}

	public List<Usuario> getListaTodos() {
		return manager.createQuery(
				" select u from Usuario u order by u.nome ", Usuario.class)
				.getResultList();
	}

	public List<Usuario> getListaTodosAtivos() {
		return manager.createQuery(
				" select u from Usuario u where u.flagAtivo = 'S' order by u.nome ", Usuario.class)
				.getResultList();
	}
	
	public Usuario getUsuarioPorLogin(String login) {
		List<Usuario> usuarios = manager.createQuery(
				" select u from Usuario u where u.login = :login and u.flagAtivo = 'S' ", Usuario.class)
				.setParameter("login", login)
				.getResultList();
		
		if (usuarios.isEmpty()) {
			return null;
		} else {
			return usuarios.get(0);
		}
	}
	
}