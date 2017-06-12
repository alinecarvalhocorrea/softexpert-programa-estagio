package br.com.biblioteca.console.pesquisa.livro;

import java.util.Scanner;
import java.util.Set;

import br.com.biblioteca.objetos.Livro;
import br.com.biblioteca.repositorios.interfaces.Livros;

/**
 * 
 * @author aline.correa
 *
 *         Script de integração de pesquisa: Interação com o usuário e pesquisa
 *         de Livros pelo autor no banco
 *
 */

public class PesquisaLivroPorAutor {
	private Scanner scanner;
	private static Livros bancoDeLivros;

	public PesquisaLivroPorAutor(Scanner scanner, Livros bancoDeLivros) {
		this.scanner = scanner;
		PesquisaLivroPorAutor.bancoDeLivros = bancoDeLivros;
	}

	public void pesquisaLivroPorAutor() {
		System.out.println("Insira o(a) autor(a):");
		scanner.nextLine();
		String autorParaPesquisar = scanner.nextLine();
		boolean verifica = verificarExistenciaDeLivroPorAutor(autorParaPesquisar);

		if (verifica) {
			Set<Livro> livrosEncontrados = bancoDeLivros.buscarPorAutor(autorParaPesquisar);
			System.out.println("Livro(s) encontrado(s):");
			for (Livro livro : livrosEncontrados) {
				System.out.println(livro);
			}
		} else {
			System.out.println("Livro não encontrado, verifique o(a) autor(a) informado(a) e tente novamente.");
			return;
		}
	}

	private boolean verificarExistenciaDeLivroPorAutor(String autor) {
		Set<Livro> busca = bancoDeLivros.buscarPorAutor(autor);
		if (!busca.isEmpty()) {
			return true;
		}
		return false;
	}
}
