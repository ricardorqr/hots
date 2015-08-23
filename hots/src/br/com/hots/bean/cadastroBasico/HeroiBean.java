package br.com.hots.bean.cadastroBasico;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.exception.HotsException;
import br.com.hots.generico.bean.GenericBean;
import br.com.hots.modelo.jogo.Heroi;
import br.com.hots.negocio.cadastroBasico.HeroiNegocio;

@Named
@ViewScoped
public class HeroiBean extends GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private HeroiNegocio negocio;
	private Heroi heroi = new Heroi();
	private Integer idFuncao;
	private Integer idUniverso;
	private List<Heroi> herois;
	
	public void salvar() {
		try {
			if (heroi.getIdHeroi() == null) {
				if (negocio.heroiJaCadastradaNoBanco(heroi)) {
					throw new HotsException("Herói já cadastrado");
				}
				
				negocio.cadastrarHeroi(heroi, idFuncao, idUniverso);
			} else {
				negocio.editarHeroi(heroi, idFuncao, idUniverso);
			}
			
			limparTela();
		}
		catch (Exception e) {
			addMensagemFATAL(e.getLocalizedMessage());
		}
	}
	
	public void removerPermanentemente() {
		try {
			negocio.removerHeroi(heroi.getIdHeroi());
			
			limparTela();
		}
		catch (Exception e) {
			addMensagemFATAL(e.getLocalizedMessage());
		}
	}
	
	public List<Heroi> getHerois() {
		if (herois == null || herois.isEmpty()) {
			herois = negocio.getListaTodos();
		}
		
		return herois;
	}
	
	private void limparTela() {
		heroi = new Heroi();
		herois = negocio.getListaTodos();
		idFuncao = null;
		idUniverso = null;
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

	public Integer getIdUniverso() {
		return idUniverso;
	}

	public void setIdUniverso(Integer idUniverso) {
		this.idUniverso = idUniverso;
	}
	
}