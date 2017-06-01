package com.biblioteca.console.pesquisa.autor;

import java.util.Scanner;

import com.biblioteca.objetos.Autor;
import com.biblioteca.repositorios.memoria.BancoDeAutores;

public class PesquisaAutorPorCodigoSequencial {
	private Scanner scanner;
	private static BancoDeAutores bancoDeAutores;

	public PesquisaAutorPorCodigoSequencial(Scanner scanner, BancoDeAutores bancoDeAutores) {
		this.scanner = scanner;
		PesquisaAutorPorCodigoSequencial.bancoDeAutores = bancoDeAutores;
	}
	
	public void pesquisarAutorPorCodigoSequencial() {
		System.out.println("Insira o código sequencial: ");
		scanner.nextLine();
		String codigoParaPesquisar = scanner.nextLine();
		System.out.println("Pesquisando autor(es) no banco...");
		boolean verifica = verificaExistenciaDeAutorPorCodigoSequencial(codigoParaPesquisar);

		if (verifica) {
			Autor busca = bancoDeAutores.buscarPorCodigoSequencial(codigoParaPesquisar);
			System.out.println("Autor(a) encontrado(a):");
			System.out.println(busca);
		} else {
			System.out.println("Categoria não encontrada, verifique o código informado e tente novamente.");
			return;
		}
	}
	public boolean verificaExistenciaDeAutorPorCodigoSequencial(String codigo) {
		Autor busca = bancoDeAutores.buscarPorCodigoSequencial(codigo);
		if (busca != null) {
			return true;
		}
		return false;
	}
}
