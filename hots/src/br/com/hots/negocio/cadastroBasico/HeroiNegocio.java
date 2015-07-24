package br.com.hots.negocio.cadastroBasico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.dao.FuncaoDAO;
import br.com.hots.dao.HeroiDAO;
import br.com.hots.modelo.Funcao;
import br.com.hots.modelo.Heroi;

@Named
public class HeroiNegocio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private HeroiDAO heroiDAO;
	@Inject
	private FuncaoDAO funcaoDAO;

	public void cadastrarHeroi(Heroi heroi) {
		heroiDAO.salvar(heroi);
	}
	
	public void editarHeroi(Heroi heroi) {
		heroiDAO.atualizar(heroi);
	}
	
	public void removerHeroi(Integer id) {
		heroiDAO.remover(id);
	}
	
	public List<Heroi> getListaTodos() {
		return heroiDAO.getListaTodos();
	}
	
	public List<Heroi> getListaTodosAtivos() {
		return heroiDAO.getListaTodosAtivos();
	}
	
	public List<Funcao> getListaFunfoesAtivos() {
		return funcaoDAO.getListaTodosAtivos();
	}
	
}