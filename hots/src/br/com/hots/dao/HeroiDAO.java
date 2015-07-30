package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.com.hots.generico.dao.GenericJPADAO;
import br.com.hots.modelo.Heroi;

@Stateless
public class HeroiDAO extends GenericJPADAO<Heroi, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public List<Heroi> getListaTodos() {
		return manager.createQuery(
				" select u from Heroi u join fetch u.universo join fetch u.funcao " + 
				" order by u.nome ", Heroi.class)
				.getResultList();
	}

	public List<Heroi> getListaTodosAtivos() {
		return manager.createQuery(
				" select u from Heroi u where u.flagAtivo = 'S' order by u.nome ", Heroi.class)
				.getResultList();
	}
	
	public Heroi getFuncaoPorNome(String nome) {
		try {
			return manager.createQuery(
					" select h from Heroi h where h.nome = :nome ", Heroi.class)
					.setParameter("nome", nome)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}