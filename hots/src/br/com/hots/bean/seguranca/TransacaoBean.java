package br.com.hots.bean.seguranca;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.generico.bean.GenericBean;
import br.com.hots.modelo.seguranca.Transacao;
import br.com.hots.negocio.seguranca.TransacaoNegocio;

@Named
@ViewScoped
public class TransacaoBean extends GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TransacaoNegocio negocio;
	private Transacao transacao = new Transacao();
	private List<Transacao> transacoes;
	private List<Transacao> filtroTabela;

	public void salvar() {
		try {
			if (transacao.getIdTransacao() == null) {
				negocio.cadastrarTransacao(transacao);
			} else {
				negocio.editarTransacao(transacao);
			}

			limparTela();
		} catch (Exception e) {
			addMensagemFATAL(e.getLocalizedMessage());
		}
	}

	public void removerPermanentemente() {
		try {
			negocio.removerTransacao(transacao.getIdTransacao());

			limparTela();
		} catch (Exception e) {
			addMensagemFATAL(e.getLocalizedMessage());
		}
	}

	public List<Transacao> getTransacoes() {
		if (transacoes == null || transacoes.isEmpty()) {
			transacoes = negocio.getListaTodos();
		}

		return transacoes;
	}

	private void limparTela() {
		transacao = new Transacao();
		transacoes = negocio.getListaTodos();
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public List<Transacao> getFiltroTabela() {
		return filtroTabela;
	}

	public void setFiltroTabela(List<Transacao> filtroTabela) {
		this.filtroTabela = filtroTabela;
	}

}