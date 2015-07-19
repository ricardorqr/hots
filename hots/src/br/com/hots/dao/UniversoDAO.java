package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.hots.modelo.Universo;

@Stateless
public class UniversoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Universo buscar(Integer id) {
		return manager.find(Universo.class, id);
	}

	public void salvar(Universo entidade) {
		manager.joinTransaction();
		manager.persist(entidade);
	}

	public void atualizar(Universo entidade) {
		manager.joinTransaction();
		manager.merge(entidade);
	}
	
	public void remover(Integer id) {
		manager.joinTransaction();
		Universo universo = buscar(id);
		manager.remove(universo);
	}

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

}