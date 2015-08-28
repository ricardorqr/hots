package br.com.hots.negocio.jogo;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.dao.PartidaDAO;
import br.com.hots.modelo.jogo.Partida;

@Named
public class PartidaNegocio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PartidaDAO partidaDAO;

	public void cadastrarPartida(Partida partida) {
		partidaDAO.salvar(partida);
	}
	
	public void editarPartida(Partida partida) {
		partidaDAO.atualizar(partida);
	}
	
	public void removerJogador(Integer id) {
		Partida partida = partidaDAO.buscar(id);
		partidaDAO.remover(partida);
	}
	
	public List<Partida> getListaTodosAtivos() {
		return partidaDAO.getListaTodosAtivos();
	}
	
}