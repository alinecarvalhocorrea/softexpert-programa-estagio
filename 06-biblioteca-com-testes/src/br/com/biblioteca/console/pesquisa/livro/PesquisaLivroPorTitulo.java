package br.com.biblioteca.console.pesquisa.livro;

import java.util.Scanner;
import java.util.Set;

import br.com.biblioteca.objetos.Livro;
import br.com.biblioteca.repositorios.interfaces.Livros;

public class PesquisaLivroPorTitulo {
	private Scanner scanner;
	private static Livros bancoDeLivros;

	public PesquisaLivroPorTitulo(Scanner scanner, Livros bancoDeLivros) {
		this.scanner = scanner;
		PesquisaLivroPorTitulo.bancoDeLivros = bancoDeLivros;
	}

	public void pesquisaLivroPorTitulo() {
		System.out.println("Insira o titulo:");
		scanner.nextLine();
		String tituloParaPesquisar = scanner.nextLine();
		boolean verifica = verificarExistenciaDeLivroPorTitulo(tituloParaPesquisar);

		if (verifica) {
			Set<Livro> livrosEncontrados = bancoDeLivros.buscarPorTitulo(tituloParaPesquisar);
			System.out.println("Livro(s) encontrado(s):");
			for (Livro livro : livrosEncontrados) {
				System.out.println(livro);
			}
		} else {
			System.out.println("Livro não encontrado, verifique o titulo informado e tente novamente.");
			return;
		}
	}

	private boolean verificarExistenciaDeLivroPorTitulo(String codigo) {
		Set<Livro> busca = bancoDeLivros.buscarPorTitulo(codigo);
		if (!busca.isEmpty()) {
			return true;
		}
		return false;
	}
}
