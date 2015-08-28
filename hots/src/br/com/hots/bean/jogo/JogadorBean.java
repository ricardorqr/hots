package br.com.hots.bean.jogo;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.generico.bean.GenericBean;
import br.com.hots.modelo.jogo.Jogador;
import br.com.hots.negocio.jogo.JogadorNegocio;

@Named
@ViewScoped
public class JogadorBean extends GenericBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private JogadorNegocio negocio;
	private Jogador jogador = new Jogador();
	private List<Jogador> jogadores;
	
	public void salvar() {
		try {
			if (jogador.getIdJogador() == null) {
				negocio.cadastrarJogador(jogador);
			} else {
				negocio.editarJogador(jogador);
			}
			
			limparTela();
		}
		catch (Exception e) {
			addMensagemFATAL(e.getMessage());
		}
	}
	
	public void removerPermanentemente() {
		try {
			negocio.removerJogador(jogador.getIdJogador());
			
			limparTela();
		}
		catch (Exception e) {
			addMensagemFATAL(e.getMessage());
		}
	}
	
	public List<Jogador> getJogadores() {
		if (jogadores == null || jogadores.isEmpty()) {
			jogadores = negocio.getListaTodos();
		}
		
		return jogadores;
	}
	
	public List<Jogador> getListaTodosAtivos() {
		if (jogadores == null || jogadores.isEmpty()) {
			jogadores = negocio.getListaTodosAtivos();
		}
		
		return jogadores;
	}
	
	private void limparTela() {
		jogador = new Jogador();
		jogadores= negocio.getListaTodos();
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

}