package br.com.hots.negocio.cadastroBasico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.dao.FuncaoDAO;
import br.com.hots.modelo.Funcao;

@Named
public class FuncaoNegocio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FuncaoDAO funcaoDAO;

	public void cadastrarFuncao(Funcao funcao) {
		funcaoDAO.salvar(funcao);
	}
	
	public void editarFuncao(Funcao funcao) {
		funcaoDAO.atualizar(funcao);
	}
	
	public void removerFuncao(Integer id) {
		Funcao funcao = funcaoDAO.buscar(id);
		funcaoDAO.remover(funcao);
	}
	
	public List<Funcao> getListaTodos() {
		return funcaoDAO.getListaTodos();
	}
	
	public List<Funcao> getListaTodosAtivos() {
		return funcaoDAO.getListaTodosAtivos();
	}
	
	public boolean funcaoJaCadastradaNoBanco(Funcao funcao) {
		return funcaoDAO.getFuncaoPorNome(funcao.getDeFuncao()) == null ? false : true;
	}

}