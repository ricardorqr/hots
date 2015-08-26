package br.com.hots.negocio.seguranca;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.dao.PerfiltransacaoDAO;
import br.com.hots.dao.TransacaoDAO;
import br.com.hots.modelo.seguranca.Perfiltransacao;
import br.com.hots.modelo.seguranca.Transacao;

@Named
public class PerfiltransacaoNegocio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PerfiltransacaoDAO perfiltransacaoDAO;
	@Inject
	private TransacaoDAO transacaoDAO;

	public List<Perfiltransacao> getListaTodosAtivos() {
		return perfiltransacaoDAO.getListaTodosAtivos();
	}
	
	public List<Transacao> getListaTrasacoesAtivos() {
		return transacaoDAO.getListaTodosAtivos();
	}
	
	public List<Transacao> getListaTransacoesPorPerfil(Integer idPerfil) {
		return perfiltransacaoDAO.getListaTransacoesPorPerfil(idPerfil);
	}

}