package br.com.hots.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import br.com.hots.generico.dao.GenericJPADAO;
import br.com.hots.modelo.seguranca.Perfil;

@Stateless
public class PerfilDAO extends GenericJPADAO<Perfil, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Perfil> getListaTodos() {
		return manager.createQuery(
				" select u from Perfil u order by u.dePerfil ", Perfil.class)
				.getResultList();
	}

	public List<Perfil> getListaTodosAtivos() {
		return manager.createQuery(
				" select u from Perfil u where u.flagAtivo = 'S' order by u.dePerfil ", Perfil.class)
				.getResultList();
	}
	
}