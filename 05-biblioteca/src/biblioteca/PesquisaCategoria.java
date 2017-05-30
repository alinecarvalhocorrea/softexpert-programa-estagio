package biblioteca;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import biblioteca.memoria.BancoDeCategorias;

public class PesquisaCategoria {
	private Scanner scanner;
	private static BancoDeCategorias bancoDeCategorias;

	public PesquisaCategoria(Scanner scanner, BancoDeCategorias bancoDeCategorias) {
		this.scanner = scanner;
		PesquisaCategoria.bancoDeCategorias = bancoDeCategorias;
	}

	public void pesquisarCategoriaPorCodigoSequencial() {
		System.out.println("Insira o c�digo sequencial: ");
		scanner.nextLine();
		String codigoParaPesquisar = scanner.nextLine();
		boolean verifica = verificaExistenciaDeCategoriaPorCodigoSequencial(codigoParaPesquisar);

		if (verifica) {
			Categoria busca = bancoDeCategorias.buscarPorCodigoSequencial(codigoParaPesquisar);
			System.out.println("Categoria: " + busca + " | C�digo Sequencial: " + busca.getCodigoSequencial());
		} else {
			System.out.println("Categoria n�o encontrada, verifique o c�digo informado e tente novamente.");
			return;
		}
	}

	public void pesquisarCategoriaPorDescricao() {
		System.out.println("Insira a descri��o: ");
		scanner.nextLine();
		String descricaoParaPesquisar = scanner.nextLine();
		boolean verifica = verificaExistenciaDeCategoriaPorDescricao(descricaoParaPesquisar);

		if (verifica) {
			Set<Categoria> busca = new HashSet<>();
			busca = bancoDeCategorias.buscarCategoriaPorDescricao(descricaoParaPesquisar);
			for (Categoria categoria : busca) {
				System.out.println(
						"Categoria: " + categoria + " | C�digo Sequencial: " + categoria.getCodigoSequencial());
			}
		} else {
			System.out.println("Categoria n�o encontrada, verifique a descri��o informada e tente novamente.");
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

	public boolean verificaExistenciaDeCategoriaPorDescricao(String descricao) {
		Set<Categoria> busca = new HashSet<>();
		busca = bancoDeCategorias.buscarCategoriaPorDescricao(descricao);
		if (!busca.isEmpty()) {
			return true;
		}
		return false;
	}

}
