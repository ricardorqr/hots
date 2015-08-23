package br.com.hots.negocio.cadastroBasico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.dao.FuncaoDAO;
import br.com.hots.dao.HeroiDAO;
import br.com.hots.dao.UniversoDAO;
import br.com.hots.modelo.jogo.Funcao;
import br.com.hots.modelo.jogo.Heroi;
import br.com.hots.modelo.jogo.Universo;

@Named
public class HeroiNegocio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private HeroiDAO heroiDAO;
	@Inject
	private FuncaoDAO funcaoDAO;
	@Inject
	private UniversoDAO universoDAO;

	public void cadastrarHeroi(Heroi heroi, Integer idFuncao, Integer idUniverso) {
		buscaFuncaoUniverso(heroi, idFuncao, idUniverso);
		heroiDAO.salvar(heroi);
	}
	
	public void editarHeroi(Heroi heroi, Integer idFuncao, Integer idUniverso) {
		buscaFuncaoUniverso(heroi, idFuncao, idUniverso);
		heroiDAO.atualizar(heroi);
	}

	private void buscaFuncaoUniverso(Heroi heroi, Integer idFuncao, Integer idUniverso) {
		Funcao funcao = funcaoDAO.buscar(idFuncao);
		Universo universo = universoDAO.buscar(idUniverso);
		heroi.setFuncao(funcao);
		heroi.setUniverso(universo);
	}
	
	public void removerHeroi(Integer id) {
		Heroi heroi = heroiDAO.buscar(id);
		heroiDAO.remover(heroi);
	}
	
	public List<Heroi> getListaTodos() {
		return heroiDAO.getListaTodos();
	}
	
	public List<Heroi> getListaTodosAtivos() {
		return heroiDAO.getListaTodosAtivos();
	}
	
	public boolean heroiJaCadastradaNoBanco(Heroi heroi) {
		return heroiDAO.getFuncaoPorNome(heroi.getNome()) == null ? false : true;
	}
	
}