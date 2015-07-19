package br.com.hots.generico.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T extends Serializable, ID extends Serializable> {

	public T buscar(ID id);

	public void salvar(T entidade);

	public void atualizar(T entidade);

	public List<T> getTodos();
	
}