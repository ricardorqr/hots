package br.com.hots.bean.cadastroBasico;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.generico.bean.GenericBean;
import br.com.hots.modelo.Funcao;
import br.com.hots.negocio.cadastroBasico.CadastrarNovaFuncaoNegocio;

@Named
@ViewScoped
public class FuncaoBean extends GenericBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastrarNovaFuncaoNegocio negocio;
	private Funcao funcao = new Funcao();
	private List<Funcao> funcoes;
	private boolean exibirNaTela = true;
	
	@PostConstruct
    public void init() {
		if (funcao.getIdFuncao() == null) {
//			exibirNaTela = false;
			funcao.setFlagAtivo("S");
		} else {
			funcao.setFlagAtivo("N");
//			exibirNaTela = true;
		}
    }
	
	public void salvar() {
		try {
			if (funcao.getIdFuncao() == null) {
				negocio.cadastrarFuncao(funcao);
			} else {
				negocio.editarFuncao(funcao);
			}
			
			funcoes = getFuncoes();
			limpar();
		}
		catch (Exception e) {
			addMensagemERROR("ERRO: " + e.getLocalizedMessage());
		}
	}
	
	public void editarFuncao(Funcao funcao) {
		System.out.println(funcao.getDeFuncao());
		System.out.println(funcao.getIdFuncao());
		this.funcao = funcao;
    }
	
	public List<Funcao> getFuncoes() {
		if (funcoes == null) {
			funcoes = negocio.getListaAtivos();
		}
		return funcoes;
	}
	
	private void limpar() {
		funcao = new Funcao();
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public boolean isExibirNaTela() {
		return exibirNaTela;
	}

	public void setExibirNaTela(boolean exibirNaTela) {
		this.exibirNaTela = exibirNaTela;
	}

}