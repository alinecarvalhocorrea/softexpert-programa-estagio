package biblioteca;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import biblioteca.memoria.BancoDeAutores;

public class PesquisaAutorPorNome {
	private Scanner scanner;
	private static BancoDeAutores bancoDeAutores;

	public PesquisaAutorPorNome(Scanner scanner, BancoDeAutores bancoDeAutores) {
		this.scanner = scanner;
		PesquisaAutorPorNome.bancoDeAutores = bancoDeAutores;
	}

	public void pesquisarAutorPorNome() {
		String nome = scanner.nextLine();
		System.out.println("Insira o nome do(a) autor(a):");
		nome = scanner.nextLine();
		boolean verifica = verificaExistenciaDeAutorPorNome(nome);

		if (verifica) {
			Set<Autor> busca = new HashSet<>();
			busca = bancoDeAutores.buscarPorNome(nome);
			for (Autor autor : busca) {
				System.out.println("Autor(a): " + autor);
			}
		} else {
			System.out.println("Autor(a) não encontrado(a), verifique o nome informado e tente novamente.");
			return;
		}
	}

	private boolean verificaExistenciaDeAutorPorNome(String nome) {
		Set<Autor> busca = new HashSet<>();
		busca = bancoDeAutores.buscarPorNome(nome);
		if (!busca.isEmpty()) {
			return true;
		}
		return false;
	}
}
