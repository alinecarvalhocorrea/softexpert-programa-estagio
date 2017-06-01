package com.biblioteca.console.pesquisa.autor;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.biblioteca.objetos.Autor;
import com.biblioteca.repositorios.memoria.BancoDeAutores;

public class PesquisaAutorPorNacionalidade {
	private Scanner scanner;
	private static BancoDeAutores bancoDeAutores;
	
	public PesquisaAutorPorNacionalidade(Scanner scanner, BancoDeAutores bancoDeAutores){
		this.scanner = scanner;
		PesquisaAutorPorNacionalidade.bancoDeAutores = bancoDeAutores;
	}
	
	public void pesquisarAutorPorNacionalidade() {
		String nacionalidade = scanner.nextLine();
		System.out.println("Insira a nacionalidade do(a) autor(a):");
		nacionalidade = scanner.nextLine();
		System.out.println("Pesquisando autor(es) no banco...");
		boolean verifica = verificaExistenciaDeAutorPorNacionalidade(nacionalidade);

		if (verifica) {
			Set<Autor> busca = new HashSet<>();
			busca = bancoDeAutores.buscarPorNacionalidade(nacionalidade);
			for (Autor autor : busca) {
				System.out.println("Autor(a): " + autor);
			}
		} else {
			System.out.println("Autor(a) não encontrado(a), verifique a nacionalidade informada e tente novamente.");
			return;
		}
	}

	private boolean verificaExistenciaDeAutorPorNacionalidade(String nacionalidade) {
		Set<Autor> busca = new HashSet<>();
		busca = bancoDeAutores.buscarPorNacionalidade(nacionalidade);
		if (!busca.isEmpty()) {
			return true;
		}
		return false;
	}
}
