package com.biblioteca.console.pesquisa.categoria;

import java.util.Scanner;

import com.biblioteca.objetos.Categoria;
import com.biblioteca.repositorios.memoria.BancoDeCategorias;

public class PesquisaCategoriaPorCodigoSequencial {
	private Scanner scanner;
	private static BancoDeCategorias bancoDeCategorias;

	public PesquisaCategoriaPorCodigoSequencial(Scanner scanner, BancoDeCategorias bancoDeCategorias) {
		this.scanner = scanner;
		PesquisaCategoriaPorCodigoSequencial.bancoDeCategorias = bancoDeCategorias;
	}

	public void pesquisarCategoriaPorCodigoSequencial() {
		System.out.println("Insira o c�digo sequencial: ");
		scanner.nextLine();
		String codigoParaPesquisar = scanner.nextLine();
		System.out.println("Pesquisando categoria(s) no banco...");
		boolean verifica = verificaExistenciaDeCategoriaPorCodigoSequencial(codigoParaPesquisar);

		if (verifica) {
			Categoria busca = bancoDeCategorias.buscarPorCodigoSequencial(codigoParaPesquisar);
			System.out.println("Categoria: " + busca + " | C�digo Sequencial: " + busca.getCodigoSequencial());
		} else {
			System.out.println("Categoria n�o encontrada, verifique o c�digo informado e tente novamente.");
			return;
		}
	}

	public boolean verificaExistenciaDeCategoriaPorCodigoSequencial(String codigo) {
		Categoria busca = bancoDeCategorias.buscarPorCodigoSequencial(codigo);
		if (busca != null) {
			return true;
		}
		return false;
	}

}
