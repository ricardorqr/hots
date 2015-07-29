package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.hots.modelo.Jogador;

@Stateless
public class JogadorDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Jogador buscar(Integer id) {
		return manager.find(Jogador.class, id);
	}

	public void salvar(Jogador entidade) {
		manager.joinTransaction();
		manager.persist(entidade);
	}

	public void atualizar(Jogador entidade) {
		manager.joinTransaction();
		manager.merge(entidade);
	}
	
	public void remover(Integer id) {
		manager.joinTransaction();
		Jogador jogador = buscar(id);
		manager.remove(jogador);
	}

	public List<Jogador> getListaTodos() {
		return manager.createQuery(
				" select j from Jogador j order by j.nome ", Jogador.class)
				.getResultList();
	}

	public List<Jogador> getListaTodosAtivos() {
		return manager.createQuery(
				" select j from Jogador j where j.flagAtivo = 'S' order by j.nome ", Jogador.class)
				.getResultList();
	}
	
}