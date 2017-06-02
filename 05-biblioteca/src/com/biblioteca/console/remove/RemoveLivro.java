package com.biblioteca.console.remove;

import java.util.Scanner;

import com.biblioteca.console.confirmacao.Confirmacao;
import com.biblioteca.console.pesquisa.livro.PesquisaLivroPorCodigoSequencial;
import com.biblioteca.objetos.Livro;
import com.biblioteca.repositorios.memoria.BancoDeLivros;

public class RemoveLivro {
	private static BancoDeLivros bancoDeLivros;
	private Scanner scanner;

	public RemoveLivro(Scanner scanner, BancoDeLivros bancoDeLivros) {
		this.scanner = scanner;
		RemoveLivro.bancoDeLivros = bancoDeLivros;
	}
	
	public void removerLivro() {
		System.out.println("Insira o c�digo sequencial da categoria: ");
		scanner.nextLine();
		String codigoSequencial = scanner.nextLine();
		System.out.println("Buscando categoria...");
		boolean verifica = new PesquisaLivroPorCodigoSequencial(scanner, bancoDeLivros).verificaExistenciaDeLivroPorCodigoSequencial(codigoSequencial);
		if(verifica){
		Livro livro = bancoDeLivros.buscarPorCodigoSequencial(codigoSequencial);
			System.out.println("Livro Encontrado:");
			System.out.println(livro);
			boolean decisao = new Confirmacao(scanner, livro).confirmaRemocao();
				if (decisao) {
						bancoDeLivros.excluir(livro);
						System.out.println("Livro " + livro.getTitulo() + " removido.");
				} else {
					return;
		}
		}else{
			System.out.println("Livro n�o encontrado. Por favor, verifique o c�digo sequencial informado e tente novamente.");
			return;
		}
	}
}
