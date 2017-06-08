package br.com.biblioteca.console.remove;

import java.util.Scanner;

import br.com.biblioteca.console.confirmacao.Confirmacao;
import br.com.biblioteca.console.pesquisa.autor.PesquisaAutorPorCodigoSequencial;
import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.repositorios.interfaces.Autores;

public class RemoveAutor {
	private static Autores bancoDeAutores;
	private Scanner scanner;

	public RemoveAutor(Scanner scanner, Autores bancoDeAutores) {
		this.scanner = scanner;
		RemoveAutor.bancoDeAutores = bancoDeAutores;
	}

	public void removerAutor() {
		System.out.println("Insira o c�digo sequencial do(a) Autor(a): ");
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
					System.out.println("Autor(a) " + autor + " n�o foi removido(a).");
					return;
		}
		}else{
			System.out.println("Autor(a) n�o encontrado(a). Por favor, verifique o c�digo sequencial informado e tente novamente.");
			return;
		}
	}

}
