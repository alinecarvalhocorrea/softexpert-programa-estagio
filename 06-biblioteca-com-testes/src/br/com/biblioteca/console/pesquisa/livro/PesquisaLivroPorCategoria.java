package br.com.biblioteca.console.pesquisa.livro;

import java.util.Scanner;
import java.util.Set;

import br.com.biblioteca.objetos.Livro;
import br.com.biblioteca.repositorios.interfaces.Livros;

public class PesquisaLivroPorCategoria {
	private Scanner scanner;
	private static Livros bancoDeLivros;

	public PesquisaLivroPorCategoria(Scanner scanner, Livros bancoDeLivros) {
		this.scanner = scanner;
		PesquisaLivroPorCategoria.bancoDeLivros = bancoDeLivros;
	}

	public void pesquisaLivroPorCategoria() {
		System.out.println("Insira a categoria:");
		scanner.nextLine();
		String categoriaParaPesquisar = scanner.nextLine();
		boolean verifica = verificarExistenciaDeLivroPorCategoria(categoriaParaPesquisar);

		if (verifica) {
			Set<Livro> livrosEncontrados = bancoDeLivros.buscarPorCategoria(categoriaParaPesquisar);
			System.out.println("Livro(s) encontrado(s):");
			for (Livro livro : livrosEncontrados) {
				System.out.println(livro);
			}
		} else {
			System.out.println("Livro não encontrado, verifique a categoria informada e tente novamente.");
			return;
		}
	}

	private boolean verificarExistenciaDeLivroPorCategoria(String categoria) {
		Set<Livro> busca = bancoDeLivros.buscarPorCategoria(categoria);
		if (!busca.isEmpty()) {
			return true;
		}
		return false;
	}
}
