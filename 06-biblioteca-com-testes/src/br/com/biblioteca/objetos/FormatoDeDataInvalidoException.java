package br.com.biblioteca.objetos;

@SuppressWarnings("serial")
public class FormatoDeDataInvalidoException extends DataException {
	
	public FormatoDeDataInvalidoException(String mensagem) {
		super(mensagem);
	}
}
