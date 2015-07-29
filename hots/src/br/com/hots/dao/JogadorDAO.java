package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import br.com.hots.generico.dao.GenericJPADAO;
import br.com.hots.modelo.Jogador;

@Stateless
public class JogadorDAO extends GenericJPADAO<Jogador, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Jogador> getListaTodos() {
		return manager.createQuery(" select j from Jogador j order by j.nome ",
				Jogador.class).getResultList();
	}

	public List<Jogador> getListaTodosAtivos() {
		return manager
				.createQuery(
						" select j from Jogador j where j.flagAtivo = 'S' order by j.nome ",
						Jogador.class).getResultList();
	}

}