package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

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
	
	public void remover(Integer id) {
		manager.joinTransaction();
		Funcao funcao = buscar(id);
		manager.remove(funcao);
	}

	public List<Funcao> getListaTodos() {
		return manager.createQuery(
				" select f from Funcao f order by f.deFuncao ", Funcao.class)
				.getResultList();
	}

	public List<Funcao> getListaTodosAtivos() {
		return manager.createQuery(
				" select f from Funcao f where f.flagAtivo = 'S' order by f.deFuncao ", Funcao.class)
				.getResultList();
	}

}