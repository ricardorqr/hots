package br.com.hots.bean.seguranca;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.generico.bean.GenericBean;
import br.com.hots.modelo.seguranca.Perfil;
import br.com.hots.negocio.seguranca.PerfilNegocio;

@Named
@ViewScoped
public class PerfilBean extends GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PerfilNegocio negocio;
	private Perfil perfil = new Perfil();
	private List<Perfil> perfis;

	public void salvar() {
		try {
			if (perfil.getIdPerfil() == null) {
				negocio.cadastrarPerfil(perfil);
			} else {
				negocio.editarPerfil(perfil);
			}

			limparTela();
		} catch (Exception e) {
			addMensagemFATAL(e.getLocalizedMessage());
		}
	}

	public void removerPermanentemente() {
		try {
			negocio.removerPerfil(perfil.getIdPerfil());

			limparTela();
		} catch (Exception e) {
			addMensagemFATAL(e.getLocalizedMessage());
		}
	}

	public List<Perfil> getPerfis() {
		if (perfis == null || perfis.isEmpty()) {
			perfis = negocio.getListaTodos();
		}

		return perfis;
	}
	
	public List<Perfil> getListaPerfilAtivo() {
		if (perfis == null || perfis.isEmpty()) {
			perfis = negocio.getListaTodosAtivos();
		}

		return perfis;
	}

	private void limparTela() {
		perfil = new Perfil();
		perfis = negocio.getListaTodos();
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}