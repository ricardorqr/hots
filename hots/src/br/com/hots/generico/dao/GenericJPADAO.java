package br.com.hots.generico.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class GenericJPADAO<T extends Serializable, ID extends Serializable> implements IGenericDAO<T, ID> {

	@Inject
	protected EntityManager manager;
	protected Class<T> classe;

	@SuppressWarnings("unchecked")
	public GenericJPADAO() {
		classe = (Class<T>) (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T buscar(ID id) {
		return manager.find(classe, id);
	}

	@Override
	public void salvar(T entidade) {
		manager.joinTransaction();
		manager.persist(entidade);
	}

	public void atualizar(T entidade) {
		manager.joinTransaction();
		manager.merge(entidade);
	}

	@Override
	public List<T> getTodos() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(classe);
		criteriaQuery.from(classe);
		return manager.createQuery(criteriaQuery).getResultList();
	}

}