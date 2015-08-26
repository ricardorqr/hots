package br.com.hots.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.hots.dao.TransacaoDAO;
import br.com.hots.modelo.seguranca.Transacao;

@FacesConverter(value="transacaoConverter")
public class TransacaoConverter implements Converter {

	@Inject
	private TransacaoDAO transacaoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Transacao transacao = null;

		if (value != null && ! value.equals("")) {
			transacao = transacaoDAO.buscar(Integer.valueOf(value));
		}

		return transacao;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Integer retorno = null;
		
		if (value != null) {
			Transacao transacao = new Transacao();
			transacao = (Transacao) value;
			retorno = transacao.getIdTransacao();
		}
		
		return retorno.toString();
	}

}