package br.com.hots.generico.dao;

import javax.persistence.EntityManager;

public class GenericJPADAO<T, ID> implements IGenericDAO<T, ID> {

	protected Class<T> classe;
	protected EntityManager manager;

	public GenericJPADAO(Class<T> classe, EntityManager manager) {
		this.classe = classe;
		this.manager = manager;
	}

	public T buscar(ID id) {
		T instancia = manager.find(classe, id);
		return instancia;
	}

	public void salvar(T entidade) {
		manager.persist(entidade);
	}

	public void remover(T entidade) {
		manager.remove(manager.merge(entidade));
	}

	public void atualizar(T entidade) {
		manager.merge(entidade);
	}

}