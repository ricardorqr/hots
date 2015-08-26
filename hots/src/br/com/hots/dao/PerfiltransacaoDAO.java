package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import br.com.hots.generico.dao.GenericJPADAO;
import br.com.hots.modelo.seguranca.Perfiltransacao;
import br.com.hots.modelo.seguranca.PerfiltransacaoId;
import br.com.hots.modelo.seguranca.Transacao;

@Stateless
public class PerfiltransacaoDAO extends GenericJPADAO<Perfiltransacao, PerfiltransacaoId> implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Perfiltransacao> getListaTodos() {
		return manager.createQuery(
				" select u from Perfiltransacao u order by u.perfil.dePerfil ", Perfiltransacao.class)
				.getResultList();
	}
	
	public List<Transacao> getListaTransacoesPorPerfil(Integer idPerfil) {
		return manager.createQuery(
				" select p.transacao " + 
				" from Perfiltransacao p where p.perfil.idPerfil = :idPerfil " + 
				" and p.perfil.flagAtivo = 'S' " + 
				" and p.transacao.flagAtivo = 'S' " + 
				" order by p.transacao.deTransacao ", Transacao.class).setParameter("idPerfil", idPerfil)
				.getResultList();
	}

	public List<Perfiltransacao> getListaTodosAtivos() {
		return manager.createQuery(
				" select u from Perfiltransacao u where u.flagAtivo = 'S' order by u.perfil.dePerfil ", Perfiltransacao.class)
				.getResultList();
	}
	
}