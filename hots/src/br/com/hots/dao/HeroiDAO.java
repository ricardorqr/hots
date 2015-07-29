package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import br.com.hots.generico.dao.GenericJPADAO;
import br.com.hots.modelo.Heroi;


public class HeroiDAO extends GenericJPADAO<Heroi, Integer> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public List<Heroi> getListaTodos() {
		return manager.createQuery(
				" select u from Heroi u order by u.deNome ", Heroi.class)
				.getResultList();
	}

	public List<Heroi> getListaTodosAtivos() {
		return manager.createQuery(
				" select u from Heroi u where u.flagAtivo = 'S' order by u.deNome ", Heroi.class)
				.getResultList();
	}

}