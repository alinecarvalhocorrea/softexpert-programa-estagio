package br.com.biblioteca.objetos.testes;

import br.com.biblioteca.objetos.CodigoSequencial;
import br.com.biblioteca.repositorios.memoria.BancoDeAutoresEmMemoria;

public class ZerarTestesDeAutores {
	
	public void zerar(){
		zerarCodigos();
		zerarBanco();
	}
	
	private void zerarBanco() {
		BancoDeAutoresEmMemoria banco = new BancoDeAutoresEmMemoria();
		banco.listar().clear();
	}
	
	private void zerarCodigos() {
		new CodigoSequencial().zerar();
	}
	
}
