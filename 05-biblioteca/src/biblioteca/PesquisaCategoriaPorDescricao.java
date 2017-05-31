package biblioteca;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import biblioteca.memoria.BancoDeCategorias;

public class PesquisaCategoriaPorDescricao {
	private Scanner scanner;
	private static BancoDeCategorias bancoDeCategorias;

	public PesquisaCategoriaPorDescricao(Scanner scanner, BancoDeCategorias bancoDeCategorias) {
		this.scanner = scanner;
		PesquisaCategoriaPorDescricao.bancoDeCategorias = bancoDeCategorias;
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

	public boolean verificaExistenciaDeCategoriaPorDescricao(String descricao) {
		Set<Categoria> busca = new HashSet<>();
		busca = bancoDeCategorias.buscarCategoriaPorDescricao(descricao);
		if (!busca.isEmpty()) {
			return true;
		}
		return false;
	}
}
