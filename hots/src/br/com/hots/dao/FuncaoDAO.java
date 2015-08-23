package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.com.hots.generico.dao.GenericJPADAO;
import br.com.hots.modelo.jogo.Funcao;

@Stateless
public class FuncaoDAO extends GenericJPADAO<Funcao, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;
	
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

	public Funcao getFuncaoPorNome(String nome) {
		try {
			return manager.createQuery(
					" select f from Funcao f where f.deFuncao = :nome ", Funcao.class)
					.setParameter("nome", nome)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}