package br.com.hots.bean.cadastroBasico;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.exception.HotsException;
import br.com.hots.generico.bean.GenericBean;
import br.com.hots.modelo.jogo.Universo;
import br.com.hots.negocio.cadastroBasico.UniversoNegocio;

@Named
@ViewScoped
public class UniversoBean extends GenericBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UniversoNegocio negocio;
	private Universo universo = new Universo();
	private List<Universo> universos;
	
	public void salvar() {
		try {
			if (universo.getIdUniverso() == null) {
				if (negocio.universoJaCadastradoNoBanco(universo)) {
					throw new HotsException("Universo já cadastrada");
				}
				
				negocio.cadastrarUniverso(universo);
			} else {
				negocio.editarUniverso(universo);
			}
			
			limparTela();
		}
		catch (Exception e) {
			addMensagemFATAL(e.getLocalizedMessage());
		}
	}
	
	public void removerPermanentemente() {
		try {
			negocio.removerUniverso(universo.getIdUniverso());
			
			limparTela();
		}
		catch (Exception e) {
			addMensagemFATAL(e.getLocalizedMessage());
		}
	}
	
	public List<Universo> getUniversos() {
		if (universos == null || universos.isEmpty()) {
			universos = negocio.getListaTodos();
		}
		
		return universos;
	}
	
	public List<Universo> getListaUniversoAtiva() {
		if (universos == null || universos.isEmpty()) {
			universos = negocio.getListaTodosAtivos();
		}
		
		return universos;
	}
	
	private void limparTela() {
		universo = new Universo();
		universos= negocio.getListaTodos();
	}

	public Universo getUniverso() {
		return universo;
	}

	public void setUniverso(Universo universo) {
		this.universo= universo;
	}

}