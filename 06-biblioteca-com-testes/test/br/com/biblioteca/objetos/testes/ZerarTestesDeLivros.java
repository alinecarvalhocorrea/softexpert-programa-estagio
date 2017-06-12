package br.com.biblioteca.objetos.testes;

import br.com.biblioteca.objetos.CodigoSequencial;
import br.com.biblioteca.repositorios.memoria.BancoDeLivrosEmMemoria;

/**
 * 
 * @author aline.correa
 *
 */

public class ZerarTestesDeLivros {

	public void zerar() {
		zerarCodigos();
		zerarBanco();
	}

	private void zerarBanco() {
		BancoDeLivrosEmMemoria banco = new BancoDeLivrosEmMemoria();
		banco.listar().clear();
	}

	private void zerarCodigos() {
		new CodigoSequencial().zerar();
	}
}
