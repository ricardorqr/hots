package br.com.hots.exception;

public class HotsException extends Exception {

	private static final long serialVersionUID = 1L;

	public HotsException() {
		super("ERRO: Desconhecido");
	}

	public HotsException(String message) {
		super(message);
	}

}