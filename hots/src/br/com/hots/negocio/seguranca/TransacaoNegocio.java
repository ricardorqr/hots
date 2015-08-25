package br.com.hots.negocio.seguranca;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.dao.TransacaoDAO;
import br.com.hots.modelo.seguranca.Transacao;

@Named
public class TransacaoNegocio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TransacaoDAO transacaoDAO;

	public void cadastrarTransacao(Transacao transacao) {
		transacaoDAO.salvar(transacao);
	}
	
	public void editarTransacao(Transacao transacao) {
		transacaoDAO.atualizar(transacao);
	}
	
	public void removerTransacao(Integer id) {
		Transacao transacao = transacaoDAO.buscar(id);
		transacaoDAO.remover(transacao);
	}
	
	public List<Transacao> getListaTodos() {
		return transacaoDAO.getListaTodos();
	}
	
	public List<Transacao> getListaTodosAtivos() {
		return transacaoDAO.getListaTodosAtivos();
	}

}