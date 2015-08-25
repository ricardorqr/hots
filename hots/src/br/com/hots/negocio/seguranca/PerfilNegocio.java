package br.com.hots.negocio.seguranca;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.dao.PerfilDAO;
import br.com.hots.modelo.seguranca.Perfil;

@Named
public class PerfilNegocio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PerfilDAO perfilDAO;

	public void cadastrarPerfil(Perfil perfil) {
		perfilDAO.salvar(perfil);
	}
	
	public void editarPerfil(Perfil perfil) {
		perfilDAO.atualizar(perfil);
	}
	
	public void removerPerfil(Integer id) {
		Perfil perfil = perfilDAO.buscar(id);
		perfilDAO.remover(perfil);
	}
	
	public List<Perfil> getListaTodos() {
		return perfilDAO.getListaTodos();
	}
	
	public List<Perfil> getListaTodosAtivos() {
		return perfilDAO.getListaTodosAtivos();
	}

}