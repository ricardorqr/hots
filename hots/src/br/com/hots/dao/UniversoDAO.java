package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.com.hots.generico.dao.GenericJPADAO;
import br.com.hots.modelo.jogo.Universo;

@Stateless
public class UniversoDAO extends GenericJPADAO<Universo, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<Universo> getListaTodos() {
		return manager.createQuery(
				" select u from Universo u order by u.deUniverso ", Universo.class)
				.getResultList();
	}

	public List<Universo> getListaTodosAtivos() {
		return manager.createQuery(
				" select u from Universo u where u.flagAtivo = 'S' order by u.deUniverso ", Universo.class)
				.getResultList();
	}
	
	public Universo getUniversoPorNome(String nome) {
		try {
			return manager.createQuery(
					" select u from Universo u where u.deUniverso = :nome", Universo.class)
					.setParameter("nome", nome)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}