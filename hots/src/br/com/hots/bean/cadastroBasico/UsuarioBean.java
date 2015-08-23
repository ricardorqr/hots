package br.com.hots.bean.cadastroBasico;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hots.generico.bean.GenericBean;
import br.com.hots.modelo.seguranca.Usuario;
import br.com.hots.negocio.cadastroBasico.UsuarioNegocio;

@Named
@ViewScoped
public class UsuarioBean extends GenericBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioNegocio negocio;
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	
	public void salvar() {
		try {
			if (usuario.getIdUsuario() == null) {
				negocio.cadastrarUsuario(usuario);
			} else {
				negocio.editarUsuario(usuario);
			}
			
			limparTela();
		}
		catch (Exception e) {
			addMensagemFATAL(e.getLocalizedMessage());
		}
	}
	
	public void removerPermanentemente() {
		try {
			negocio.removerUsuario(usuario.getIdUsuario());
			
			limparTela();
		}
		catch (Exception e) {
			addMensagemFATAL(e.getLocalizedMessage());
		}
	}
	
	public List<Usuario> getUsuarios() {
		if (usuarios == null || usuarios.isEmpty()) {
			usuarios = negocio.getListaTodos();
		}
		
		return usuarios;
	}
	
	private void limparTela() {
		usuario = new Usuario();
		usuarios= negocio.getListaTodos();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}