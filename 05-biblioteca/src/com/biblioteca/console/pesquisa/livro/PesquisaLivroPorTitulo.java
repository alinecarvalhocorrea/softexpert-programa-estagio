package com.biblioteca.console.pesquisa.livro;

import java.util.Scanner;
import java.util.Set;

import com.biblioteca.objetos.Livro;
import com.biblioteca.repositorios.memoria.BancoDeLivros;

public class PesquisaLivroPorTitulo {
	private Scanner scanner;
	private static BancoDeLivros bancoDeLivros;

	public PesquisaLivroPorTitulo(Scanner scanner, BancoDeLivros bancoDeLivros) {
		this.scanner = scanner;
		PesquisaLivroPorTitulo.bancoDeLivros = bancoDeLivros;
	}

	public void pesquisaLivroPorCodigoDeBarras() {
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
