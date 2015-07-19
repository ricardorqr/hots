package br.com.hots.negocio.cadastroBasico;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.dao.HeroiDAO;
import br.com.hots.modelo.Heroi;

@Named
public class CadastrarNovoHeroi {

	@Inject
	private HeroiDAO heroiDAO;

	public void cadastrarNovoHeroi(Heroi heroi) {
		heroiDAO.salvar(heroi);
	}
	
}