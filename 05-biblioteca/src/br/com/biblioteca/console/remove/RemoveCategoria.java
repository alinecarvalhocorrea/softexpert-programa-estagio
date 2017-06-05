package br.com.biblioteca.console.remove;

import java.util.Scanner;

import br.com.biblioteca.console.confirmacao.Confirmacao;
import br.com.biblioteca.console.pesquisa.categoria.PesquisaCategoriaPorCodigoSequencial;
import br.com.biblioteca.objetos.Categoria;
import br.com.biblioteca.repositorios.memoria.BancoDeCategorias;

public class RemoveCategoria {
	private static BancoDeCategorias bancoDeCategorias;
	private Scanner scanner;

	public RemoveCategoria(Scanner scanner, BancoDeCategorias bancoDeCategorias) {
		this.scanner = scanner;
		RemoveCategoria.bancoDeCategorias = bancoDeCategorias;
	}

	public void removerCategoria() {
		System.out.println("Insira o c�digo sequencial da categoria: ");
		scanner.nextLine();
		String codigoSequencial = scanner.nextLine();
		System.out.println("Buscando categoria...");
		boolean verifica = new PesquisaCategoriaPorCodigoSequencial(scanner, bancoDeCategorias).verificaExistenciaDeCategoriaPorCodigoSequencial(codigoSequencial);
		if(verifica){
			Categoria categoria = bancoDeCategorias.buscarPorCodigoSequencial(codigoSequencial);
			System.out.println("Categoria Encontrada: " + categoria + " | C�digo Sequencial: " + categoria.getCodigoSequencial());
			boolean decisao = new Confirmacao(scanner, categoria).confirmaRemocao();
				if (decisao) {
						bancoDeCategorias.excluir(categoria);
						System.out.println("Categoria " + categoria + " removida.");
				} else {
					return;
		}
		}else{
			System.out.println("Categoria n�o encontrada. Por favor, verifique o c�digo sequencial informado e tente novamente.");
			return;
		}
	}
}
