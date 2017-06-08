package br.com.biblioteca.console.pesquisa.categoria;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import br.com.biblioteca.objetos.Categoria;
import br.com.biblioteca.repositorios.interfaces.Categorias;

public class PesquisaCategoriaPorDescricao {
	private Scanner scanner;
	private static Categorias bancoDeCategorias;

	public PesquisaCategoriaPorDescricao(Scanner scanner, Categorias bancoDeCategorias) {
		this.scanner = scanner;
		PesquisaCategoriaPorDescricao.bancoDeCategorias = bancoDeCategorias;
	}

	public void pesquisarCategoriaPorDescricao() {
		System.out.println("Insira a descrição: ");
		scanner.nextLine();
		String descricaoParaPesquisar = scanner.nextLine();
		System.out.println("Pesquisando categoria(s) no banco...");
		boolean verifica = verificaExistenciaDeCategoriaPorDescricao(descricaoParaPesquisar);
		if (verifica) {
			Set<Categoria> busca = new HashSet<>();
			busca = bancoDeCategorias.buscarCategoriaPorDescricao(descricaoParaPesquisar);
			for (Categoria categoria : busca) {
				System.out.println(
						"Categoria: " + categoria + " | Código Sequencial: " + categoria.getCodigoSequencial());
			}
		} else {
			System.out.println("Categoria não encontrada, verifique a descrição informada e tente novamente.");
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
