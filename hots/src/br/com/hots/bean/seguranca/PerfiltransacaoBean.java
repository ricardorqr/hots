package br.com.hots.bean.seguranca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import br.com.hots.generico.bean.GenericBean;
import br.com.hots.modelo.seguranca.Transacao;
import br.com.hots.negocio.seguranca.PerfiltransacaoNegocio;

@Named
@ViewScoped
public class PerfiltransacaoBean extends GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PerfiltransacaoNegocio negocio;
	private Integer idPerfil;
	private List<Transacao> transacoesOrigem = new ArrayList<Transacao>();
	private List<Transacao> transacoesDestino = new ArrayList<Transacao>();
	private DualListModel<Transacao> transacoes;
	
	public void salvar() {
		try {
			transacoesOrigem = transacoes.getSource();
			transacoesDestino = transacoes.getTarget();
			negocio.salvarPerfiltransacao(idPerfil, transacoesOrigem, transacoesDestino);
			
			limparTela();
		} catch (Exception e) {
			addMensagemFATAL(e.getLocalizedMessage());
		}
	}

	public void listarTransacoesPorPerfil() {
		if (idPerfil != null) {
			transacoesOrigem = negocio.getListaTransacoesAtivaPorPerfil(idPerfil);
			transacoesDestino = negocio.getListaTransacoesInativaPorPerfil(idPerfil);
			
			if (transacoesOrigem == null || transacoesOrigem.isEmpty() && 
					transacoesDestino == null || transacoesDestino.isEmpty()) {
				transacoesOrigem = negocio.getListaTrasacoesAtivos();
			}
			
		}
		
		transacoes = new DualListModel<Transacao>(transacoesOrigem, transacoesDestino);
	}
	
	private void limparTela() {
		idPerfil = null;
		transacoes = new DualListModel<Transacao>(new ArrayList<Transacao>(), new ArrayList<Transacao>());
	}
	
	public void setTransacoes(DualListModel<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
	
	public DualListModel<Transacao> getTransacoes() {
		if (transacoes == null) {
			transacoes = new DualListModel<Transacao>(transacoesOrigem, transacoesDestino);
		}
		
		return transacoes;
	}
	
	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
}