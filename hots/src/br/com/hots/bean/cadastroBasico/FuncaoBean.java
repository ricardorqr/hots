package br.com.hots.bean.cadastroBasico;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.exception.HotsException;
import br.com.hots.generico.bean.GenericBean;
import br.com.hots.modelo.Funcao;
import br.com.hots.negocio.cadastroBasico.FuncaoNegocio;

@Named
@ViewScoped
public class FuncaoBean extends GenericBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FuncaoNegocio negocio;
	private Funcao funcao = new Funcao();
	private List<Funcao> funcoes;
	
	public void salvar() {
		try {
			if (funcao.getIdFuncao() == null) {
				if (negocio.objetoExisteNoBanco(funcao)) {
					throw new HotsException("Função já cadastrada");
				}
				
				negocio.cadastrarFuncao(funcao);
			} else {
				negocio.editarFuncao(funcao);
			}
			
			limparTela();
		}
		catch (Exception e) {
			addMensagemFATAL(e.getLocalizedMessage());
		}
	}
	
	public void removerPermanentemente() {
		try {
			negocio.removerFuncao(funcao.getIdFuncao());
			
			limparTela();
		}
		catch (Exception e) {
			addMensagemFATAL(e.getLocalizedMessage());
		}
	}
	
	public List<Funcao> getFuncoes() {
		if (funcoes == null || funcoes.isEmpty()) {
			funcoes = negocio.getListaTodos();
		}
		
		return funcoes;
	}
	
	public List<Funcao> getListaFuncaoAtiva() {
		if (funcoes == null || funcoes.isEmpty()) {
			funcoes = negocio.getListaTodosAtivos();
		}
		
		return funcoes;
	}
	
	private void limparTela() {
		funcao = new Funcao();
		funcoes = negocio.getListaTodos();
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

}