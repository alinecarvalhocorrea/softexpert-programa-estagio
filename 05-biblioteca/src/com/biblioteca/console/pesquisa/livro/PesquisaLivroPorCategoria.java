package com.biblioteca.console.pesquisa.livro;

import java.util.List;
import java.util.Scanner;

import com.biblioteca.objetos.Livro;
import com.biblioteca.repositorios.memoria.BancoDeLivros;

public class PesquisaLivroPorCategoria {
	private Scanner scanner;
	private static BancoDeLivros bancoDeLivros;

	public PesquisaLivroPorCategoria(Scanner scanner, BancoDeLivros bancoDeLivros) {
		this.scanner = scanner;
		PesquisaLivroPorCategoria.bancoDeLivros = bancoDeLivros;
	}

	public void pesquisaLivroPorCodigoDeBarras() {
		System.out.println("Insira a categoria:");
		scanner.nextLine();
		String categoriaParaPesquisar = scanner.nextLine();
		boolean verifica = verificarExistenciaDeLivroPorCategoria(categoriaParaPesquisar);

		if (verifica) {
			List<Livro> livrosEncontrados = bancoDeLivros.buscarPorCategoria(categoriaParaPesquisar);
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
		List<Livro> busca = bancoDeLivros.buscarPorCategoria(categoria);
		if (!busca.isEmpty()) {
			return true;
		}
		return false;
	}
}
