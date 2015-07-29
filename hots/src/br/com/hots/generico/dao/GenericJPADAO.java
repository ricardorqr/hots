package br.com.hots.generico.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

public class GenericJPADAO<T extends Serializable, ID extends Serializable> implements IGenericDAO<T, ID> {

	@PersistenceContext
	protected EntityManager manager;
	private Class<T> entityClass;

	private Class<T> getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
		
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T buscar(ID id) {
		T instancia = (T) manager.find(getEntityClass(), id);
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
	
	public List<T> getListaTodos() {
		CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(getEntityClass());
		query.select(query.from(getEntityClass()));
		return manager.createQuery(query).getResultList();
	}

}