package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.hots.modelo.Funcao;

@Stateless
public class FuncaoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Funcao buscar(Integer id) {
		return manager.find(Funcao.class, id);
	}

	public void salvar(Funcao entidade) {
		manager.joinTransaction();
		manager.persist(entidade);
	}

	public void atualizar(Funcao entidade) {
		manager.joinTransaction();
		manager.merge(entidade);
	}

	public List<Funcao> getTodos() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Funcao> criteriaQuery = builder.createQuery(Funcao.class);
		criteriaQuery.from(Funcao.class);
		return manager.createQuery(criteriaQuery).getResultList();
	}

	public List<Funcao> listarTodosAtivos() {
		return manager.createQuery(
				" select f from Funcao f where f.flagAtivo = 'S' order by f.deFuncao ", Funcao.class)
				.getResultList();
	}

}