package br.com.hots.bean.jogo;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.generico.bean.GenericBean;
import br.com.hots.modelo.jogo.Jogador;
import br.com.hots.modelo.jogo.Partida;
import br.com.hots.negocio.jogo.PartidaNegocio;

@Named
@ViewScoped
public class PartidaBean extends GenericBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PartidaNegocio negocio;
	private Partida partida = new Partida();
	private List<Partida> partidas;
	private List<Jogador> jogadoresSelecionado;
	
	public void gerar() {
		
	}
	
	
	public List<Partida> getPartidas() {
		if (partidas == null || partidas.isEmpty()) {
			partidas = negocio.getListaTodosAtivos();
		}
		
		return partidas;
	}
	
	private void limparTela() {
		partida = new Partida();
		partidas= negocio.getListaTodosAtivos();
	}

	public List<Jogador> getJogadoresSelecionado() {
		return jogadoresSelecionado;
	}

	public void setJogadoresSelecionado(List<Jogador> jogadoresSelecionado) {
		this.jogadoresSelecionado = jogadoresSelecionado;
	}

}