package com.biblioteca.console.edita;

import java.util.Scanner;

import com.biblioteca.console.cadastro.CadastroDeAutor;
import com.biblioteca.console.confirmacao.Confirmacao;
import com.biblioteca.console.pesquisa.autor.PesquisaAutorPorCodigoSequencial;
import com.biblioteca.objetos.Autor;
import com.biblioteca.repositorios.memoria.BancoDeAutores;

public class EditaAutor {
	private Scanner scanner;
	private static BancoDeAutores bancoDeAutores;
	
	public EditaAutor(Scanner scanner, BancoDeAutores bancoDeAutores){
		this.scanner = scanner;
		EditaAutor.bancoDeAutores = bancoDeAutores;
	}
	
	public void editarAutor(){
		System.out.println("Insira o código sequencial do(a) autor(a): ");
		scanner.nextLine();
		String codigoSequencial = scanner.nextLine();
		PesquisaAutorPorCodigoSequencial verifica = new PesquisaAutorPorCodigoSequencial(scanner, bancoDeAutores);
		System.out.println("Pesquisando por autor(a) no banco...");
		boolean verificacao = verifica.verificaExistenciaDeAutorPorCodigoSequencial(codigoSequencial);
	
		if(verificacao){
			Autor autor = bancoDeAutores.buscarPorCodigoSequencial(codigoSequencial);
			Confirmacao confirmacao = new Confirmacao(scanner,autor);
			boolean decisaoUsuario = confirmacao.confirmaEdicao();
			if(decisaoUsuario){
				bancoDeAutores.excluir(autor);
				CadastroDeAutor cadastraAutor = new CadastroDeAutor(scanner, bancoDeAutores);
				cadastraAutor.cadastrarAutor();
			}
			
		}else{
			
			return;
		}
	}
}
