package br.com.hots.negocio.seguranca;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.dao.PerfilDAO;
import br.com.hots.dao.PerfiltransacaoDAO;
import br.com.hots.dao.TransacaoDAO;
import br.com.hots.modelo.seguranca.Perfil;
import br.com.hots.modelo.seguranca.Perfiltransacao;
import br.com.hots.modelo.seguranca.PerfiltransacaoId;
import br.com.hots.modelo.seguranca.Transacao;

@Named
public class PerfiltransacaoNegocio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PerfiltransacaoDAO perfiltransacaoDAO;
	@Inject
	private TransacaoDAO transacaoDAO;
	@Inject
	private PerfilDAO perfilDAO;
	
	public void salvarPerfiltransacao(Integer idPerfil, List<Transacao> transacoesOrigem, List<Transacao> transacoesDestino) {
		Perfiltransacao perfiltransacao = null;
		
		for (Transacao transacao : transacoesOrigem) {
			PerfiltransacaoId id = new PerfiltransacaoId();
			id.setIdPerfil(idPerfil);
			id.setIdTransacao(transacao.getIdTransacao());
			
			perfiltransacao = perfiltransacaoDAO.buscar(id);
			
			if (perfiltransacao == null) {
				Perfil perfil = perfilDAO.buscar(idPerfil);
				
				perfiltransacao = new Perfiltransacao();
				perfiltransacao.setId(id);
				perfiltransacao.setPerfil(perfil);
				perfiltransacao.setTransacao(transacao);
				perfiltransacao.setFlagAtivo("S");
				perfiltransacaoDAO.salvar(perfiltransacao);
			} else {
				perfiltransacao.setFlagAtivo("S");
				perfiltransacaoDAO.atualizar(perfiltransacao);
			}
		}
		
		for (Transacao transacao : transacoesDestino) {
			PerfiltransacaoId id = new PerfiltransacaoId();
			id.setIdPerfil(idPerfil);
			id.setIdTransacao(transacao.getIdTransacao());
			
			perfiltransacao = perfiltransacaoDAO.buscar(id);
			
			if (perfiltransacao == null) {
				Perfil perfil = perfilDAO.buscar(idPerfil);
				
				perfiltransacao = new Perfiltransacao();
				perfiltransacao.setId(id);
				perfiltransacao.setPerfil(perfil);
				perfiltransacao.setTransacao(transacao);
				perfiltransacao.setFlagAtivo("N");
				perfiltransacaoDAO.salvar(perfiltransacao);
			} else {
				perfiltransacao.setFlagAtivo("N");
				perfiltransacaoDAO.atualizar(perfiltransacao);
			}
		}
	}

	public List<Transacao> getListaTrasacoesAtivos() {
		return transacaoDAO.getListaTodosAtivos();
	}
	
	public List<Transacao> getListaTransacoesAtivaPorPerfil(Integer idPerfil) {
		return perfiltransacaoDAO.getListaTransacoesAtivaPorPerfil(idPerfil);
	}
	
	public List<Transacao> getListaTransacoesInativaPorPerfil(Integer idPerfil) {
		return perfiltransacaoDAO.getListaTransacoesInativaPorPerfil(idPerfil);
	}

}