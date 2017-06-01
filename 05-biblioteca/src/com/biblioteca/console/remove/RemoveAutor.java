package com.biblioteca.console.remove;

import java.util.Scanner;

import com.biblioteca.console.confirmacao.Confirmacao;
import com.biblioteca.console.pesquisa.autor.PesquisaAutorPorCodigoSequencial;
import com.biblioteca.objetos.Autor;
import com.biblioteca.repositorios.memoria.BancoDeAutores;

public class RemoveAutor {
	private static BancoDeAutores bancoDeAutores;
	private Scanner scanner;

	public RemoveAutor(Scanner scanner, BancoDeAutores bancoDeAutores) {
		this.scanner = scanner;
		RemoveAutor.bancoDeAutores = bancoDeAutores;
	}

	public void removerAutor() {
		System.out.println("Insira o código sequencial do(a) Autor(a): ");
		scanner.nextLine();
		String codigoSequencial = scanner.nextLine();
		System.out.println("Buscando Autor...");
		boolean verifica = new PesquisaAutorPorCodigoSequencial(scanner, bancoDeAutores).verificaExistenciaDeAutorPorCodigoSequencial(codigoSequencial);
		if(verifica){
			Autor autor = bancoDeAutores.buscarPorCodigoSequencial(codigoSequencial);
			System.out.println("Autor(a) Encontrado(a): " + autor);
			boolean decisao = new Confirmacao(scanner,autor).confirmaRemocao();
				if (decisao) {
						bancoDeAutores.excluir(autor);
						System.out.println("Autor(a) " + autor + " removido(a).");
				} else {
					System.out.println("Autor(a) " + autor + " não foi removido(a).");
					return;
		}
		}else{
			System.out.println("Autor(a) não encontrado(a). Por favor, verifique o código sequencial informado e tente novamente.");
			return;
		}
	}

}
