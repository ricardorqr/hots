package br.com.hots.bean.cadastroBasico;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.generico.bean.GenericBean;
import br.com.hots.modelo.Funcao;
import br.com.hots.modelo.Heroi;
import br.com.hots.negocio.cadastroBasico.HeroiNegocio;

@Named
@ViewScoped
public class HeroiBean extends GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private HeroiNegocio negocio;
	private Heroi heroi = new Heroi();
	private Integer idFuncao;
	private List<Funcao> funcoes;
	
	public List<Funcao> getFuncoes() {
		if (funcoes == null || funcoes.isEmpty()) {
			funcoes = negocio.getListaFunfoesAtivos();
		}
		
		return funcoes;
	}

	public Heroi getHeroi() {
		return heroi;
	}

	public void setHeroi(Heroi heroi) {
		this.heroi = heroi;
	}
	
	public Integer getIdFuncao() {
		return idFuncao;
	}

	public void setIdFuncao(Integer idFuncao) {
		this.idFuncao = idFuncao;
	}
	
}