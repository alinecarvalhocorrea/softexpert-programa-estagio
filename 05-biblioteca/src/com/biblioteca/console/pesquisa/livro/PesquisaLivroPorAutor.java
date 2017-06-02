package com.biblioteca.console.pesquisa.livro;

import java.util.Scanner;
import java.util.Set;

import com.biblioteca.objetos.Livro;
import com.biblioteca.repositorios.memoria.BancoDeLivros;

public class PesquisaLivroPorAutor {
	private Scanner scanner;
	private static BancoDeLivros bancoDeLivros;
	
	public PesquisaLivroPorAutor(Scanner scanner, BancoDeLivros bancoDeLivros){
		this.scanner = scanner;
		PesquisaLivroPorAutor.bancoDeLivros = bancoDeLivros;
	}
	
	public void pesquisaLivroPorCodigoDeBarras() {
		System.out.println("Insira o titulo:");
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
			System.out.println("Livro não encontrado, verifique o autor informado e tente novamente.");
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
