package biblioteca;

import java.util.Scanner;

import biblioteca.memoria.BancoDeCategorias;

public class PesquisaCategoriaPorCodigoSequencial {
	private Scanner scanner;
	private static BancoDeCategorias bancoDeCategorias;

	public PesquisaCategoriaPorCodigoSequencial(Scanner scanner, BancoDeCategorias bancoDeCategorias) {
		this.scanner = scanner;
		PesquisaCategoriaPorCodigoSequencial.bancoDeCategorias = bancoDeCategorias;
	}

	public void pesquisarCategoriaPorCodigoSequencial() {
		System.out.println("Insira o código sequencial: ");
		scanner.nextLine();
		String codigoParaPesquisar = scanner.nextLine();
		boolean verifica = verificaExistenciaDeCategoriaPorCodigoSequencial(codigoParaPesquisar);

		if (verifica) {
			Categoria busca = bancoDeCategorias.buscarPorCodigoSequencial(codigoParaPesquisar);
			System.out.println("Categoria: " + busca + " | Código Sequencial: " + busca.getCodigoSequencial());
		} else {
			System.out.println("Categoria não encontrada, verifique o código informado e tente novamente.");
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
