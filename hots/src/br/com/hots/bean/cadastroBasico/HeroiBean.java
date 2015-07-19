package br.com.hots.bean.cadastroBasico;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.generico.bean.GenericBean;
import br.com.hots.modelo.Heroi;
import br.com.hots.negocio.cadastroBasico.CadastrarNovoHeroi;

@Named
public class HeroiBean extends GenericBean {

	@Inject
	private CadastrarNovoHeroi cadastrarNovoHeroi;
	private Heroi heroi = new Heroi();
	
	public void salvar() {
		System.out.println(heroi);
		cadastrarNovoHeroi.cadastrarNovoHeroi(heroi);
	}

	public Heroi getHeroi() {
		return heroi;
	}

	public void setHeroi(Heroi heroi) {
		this.heroi = heroi;
	}
	
	public void limpar() {
		heroi = new Heroi();
	}
	
}
