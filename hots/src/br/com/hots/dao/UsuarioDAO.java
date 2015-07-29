package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.com.hots.generico.dao.GenericJPADAO;
import br.com.hots.modelo.Usuario;

@Stateless
public class UsuarioDAO extends GenericJPADAO<Usuario, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

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
		try {
			return manager.createQuery(
					" select u from Usuario u where u.login = :login and u.flagAtivo = 'S' ", Usuario.class)
					.setParameter("login", login)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}