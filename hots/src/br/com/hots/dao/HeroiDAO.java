package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.hots.modelo.Heroi;


public class HeroiDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Heroi buscar(Integer id) {
		return manager.find(Heroi.class, id);
	}

	public void salvar(Heroi entidade) {
		manager.joinTransaction();
		manager.persist(entidade);
	}

	public void atualizar(Heroi entidade) {
		manager.joinTransaction();
		manager.merge(entidade);
	}
	
	public void remover(Integer id) {
		manager.joinTransaction();
		Heroi heroi = buscar(id);
		manager.remove(heroi);
	}

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