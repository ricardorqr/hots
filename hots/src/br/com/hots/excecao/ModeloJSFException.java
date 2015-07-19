package br.com.hots.excecao;

public class ModeloJSFException extends Exception {

	private static final long serialVersionUID = 1L;

	public ModeloJSFException() {
		super("Causa do erro: Desconhecida");
	}

	public ModeloJSFException(String message) {
		super(message);
	}

}