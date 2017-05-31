package biblioteca;

import java.util.Scanner;

import biblioteca.memoria.BancoDeAutores;

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
