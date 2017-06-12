package br.com.biblioteca.objetos.exceptions;

/**
 * 
 * @author aline.correa
 *
 */

@SuppressWarnings("serial")
public class FormatoDeDataInvalidoException extends DataException {

	public FormatoDeDataInvalidoException(String mensagem) {
		super(mensagem);
	}
}
