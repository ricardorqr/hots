package br.com.hots.negocio.cadastroBasico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.dao.UniversoDAO;
import br.com.hots.modelo.Universo;

@Named
public class UniversoNegocio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UniversoDAO universoDAO;

	public void cadastrarUniverso(Universo universo) {
		universoDAO.salvar(universo);
	}
	
	public void editarUniverso(Universo universo) {
		universoDAO.atualizar(universo);
	}
	
	public void removerUniverso(Integer id) {
		Universo universo = universoDAO.buscar(id);
		universoDAO.remover(universo);
	}
	
	public List<Universo> getListaTodos() {
		return universoDAO.getListaTodos();
	}
	
	public List<Universo> getListaTodosAtivos() {
		return universoDAO.getListaTodosAtivos();
	}
	
	public boolean universoJaCadastradoNoBanco(Universo universo) {
		return universoDAO.getUniversoPorNome(universo.getDeUniverso()) == null ? false : true;
	}

}