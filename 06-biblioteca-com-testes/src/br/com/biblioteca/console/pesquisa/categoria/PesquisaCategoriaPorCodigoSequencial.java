package br.com.biblioteca.console.pesquisa.categoria;

import java.util.Scanner;

import br.com.biblioteca.objetos.Categoria;
import br.com.biblioteca.repositorios.interfaces.Categorias;

/**
 * 
 * @author aline.correa
 *
 *         Script de integração de pesquisa: Interação com o usuário e pesquisa
 *         de Categorias pelo código sequencial no banco
 *
 */

public class PesquisaCategoriaPorCodigoSequencial {
	private Scanner scanner;
	private static Categorias bancoDeCategorias;

	public PesquisaCategoriaPorCodigoSequencial(Scanner scanner, Categorias bancoDeCategorias) {
		this.scanner = scanner;
		PesquisaCategoriaPorCodigoSequencial.bancoDeCategorias = bancoDeCategorias;
	}

	public void pesquisarCategoriaPorCodigoSequencial() {
		System.out.println("Insira o código sequencial: ");
		scanner.nextLine();
		String codigoParaPesquisar = scanner.nextLine();
		System.out.println("Pesquisando categoria(s) no banco...");
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
