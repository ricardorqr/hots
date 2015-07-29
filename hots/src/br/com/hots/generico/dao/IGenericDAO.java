package br.com.hots.generico.dao;

import java.util.List;

public interface IGenericDAO<T, ID> {

	public T buscar(ID id);

	public void salvar(T entidade);

	public void atualizar(T entidade);

	public void remover(T entidade);
	
	public List<T> getListaTodos();

}