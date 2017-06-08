package br.com.biblioteca.objetos.testes;

import br.com.biblioteca.objetos.CodigoSequencial;
import br.com.biblioteca.repositorios.memoria.BancoDeCategoriasEmMemoria;

public class ZerarTestesDeCategorias {

	public void zerar(){
		zerarCodigos();
		zerarBanco();
	}
	
	private void zerarBanco() {
		BancoDeCategoriasEmMemoria banco = new BancoDeCategoriasEmMemoria();
		banco.listar().clear();
	}
	
	private void zerarCodigos() {
		new CodigoSequencial().zerar();
	}
}