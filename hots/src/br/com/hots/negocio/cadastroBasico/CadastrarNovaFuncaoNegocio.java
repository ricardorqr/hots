package br.com.hots.negocio.cadastroBasico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.dao.FuncaoDAO;
import br.com.hots.modelo.Funcao;

@Named
public class CadastrarNovaFuncaoNegocio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FuncaoDAO funcaoDAO;

	public void cadastrarFuncao(Funcao funcao) {
		funcaoDAO.salvar(funcao);
	}
	
	public void editarFuncao(Funcao funcao) {
		funcaoDAO.atualizar(funcao);
	}
	
	public List<Funcao> getListaAtivos() {
		return funcaoDAO.listarTodosAtivos();
	}

}