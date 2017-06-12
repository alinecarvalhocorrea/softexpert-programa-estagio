package br.com.biblioteca.console.pesquisa.autor;

import java.util.Scanner;

import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.repositorios.interfaces.Autores;

/**
 * 
 * @author aline.correa
 *
 *         Script de integra��o de pesquisa: Intera��o com o usu�rio e
 *         pesquisa de Autores pelo c�digo sequencial no banco
 *
 */

public class PesquisaAutorPorCodigoSequencial {
	private Scanner scanner;
	private static Autores bancoDeAutores;

	public PesquisaAutorPorCodigoSequencial(Scanner scanner, Autores bancoDeAutores) {
		this.scanner = scanner;
		PesquisaAutorPorCodigoSequencial.bancoDeAutores = bancoDeAutores;
	}

	public void pesquisarAutorPorCodigoSequencial() {
		System.out.println("Insira o c�digo sequencial: ");
		scanner.nextLine();
		String codigoParaPesquisar = scanner.nextLine();
		System.out.println("Pesquisando autor(es) no banco...");
		boolean verifica = verificaExistenciaDeAutorPorCodigoSequencial(codigoParaPesquisar);

		if (verifica) {
			Autor busca = bancoDeAutores.buscarPorCodigoSequencial(codigoParaPesquisar);
			System.out.println("Autor(a) encontrado(a):");
			System.out.println(busca);
		} else {
			System.out.println("Categoria n�o encontrada, verifique o c�digo informado e tente novamente.");
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
