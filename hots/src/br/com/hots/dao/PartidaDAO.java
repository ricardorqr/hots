package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import br.com.hots.generico.dao.GenericJPADAO;
import br.com.hots.modelo.jogo.Partida;

@Stateless
public class PartidaDAO extends GenericJPADAO<Partida, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<Partida> getListaTodosAtivos() {
		return manager.createQuery(
				" select f from Partida f where f.flagAtivo = 'S' ", Partida.class)
				.getResultList();
	}

}