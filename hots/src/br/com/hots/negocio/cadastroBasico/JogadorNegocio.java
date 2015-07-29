package br.com.hots.negocio.cadastroBasico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.dao.JogadorDAO;
import br.com.hots.modelo.Jogador;

@Named
public class JogadorNegocio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private JogadorDAO jogadorDAO;

	public void cadastrarJogador(Jogador jogador) {
		jogadorDAO.salvar(jogador);
	}
	
	public void editarJogador(Jogador jogador) {
		jogadorDAO.atualizar(jogador);
	}
	
	public void removerJogador(Integer id) {
		Jogador jogador = jogadorDAO.buscar(id);
		jogadorDAO.remover(jogador);
	}
	
	public List<Jogador> getListaTodos() {
		return jogadorDAO.getListaTodos();
	}
	
	public List<Jogador> getListaTodosAtivos() {
		return jogadorDAO.getListaTodosAtivos();
	}

}