package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import br.com.hots.generico.dao.GenericJPADAO;
import br.com.hots.modelo.seguranca.Transacao;

@Stateless
public class TransacaoDAO extends GenericJPADAO<Transacao, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Transacao> getListaTodos() {
		return manager.createQuery(
				" select u from Transacao u order by u.deTransacao ", Transacao.class)
				.getResultList();
	}

	public List<Transacao> getListaTodosAtivos() {
		return manager.createQuery(
				" select u from Transacao u where u.flagAtivo = 'S' order by u.deTransacao ", Transacao.class)
				.getResultList();
	}
	
}