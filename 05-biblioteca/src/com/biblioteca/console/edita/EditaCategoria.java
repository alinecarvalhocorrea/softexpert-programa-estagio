package com.biblioteca.console.edita;

import java.util.Scanner;

import com.biblioteca.console.cadastro.CadastroDeCategoria;
import com.biblioteca.objetos.Categoria;
import com.biblioteca.repositorios.memoria.BancoDeCategorias;

public class EditaCategoria {
	private Scanner scanner;
	private static BancoDeCategorias bancoDeCategorias;
	
	public EditaCategoria(Scanner scanner, BancoDeCategorias bancoDeCategorias){
		this.scanner = scanner;
		EditaCategoria.bancoDeCategorias = bancoDeCategorias;
	}
	
	public void editarCategoria(){
		System.out.println("Insira o código sequencial da categoria: ");
		scanner.nextLine();
		String codigoSequencial = scanner.nextLine();
		//TODO verificar existencia de categoria
		Categoria categoria = bancoDeCategorias.buscarPorCodigoSequencial(codigoSequencial);
		System.out.println("Buscando categoria...");
		System.out.println("Categoria Encontrada: " + categoria + " | Código Sequencial: " + categoria.getCodigoSequencial());
		boolean decisao = confirmacaoEdicao(categoria);
		if(decisao){
			bancoDeCategorias.editar(categoria);
			CadastroDeCategoria cadastraCategoriaNova = new CadastroDeCategoria(scanner,bancoDeCategorias);
			cadastraCategoriaNova.cadastrarCategoria();
		}else {
			return;
		}
			
	}
	
	private boolean confirmacaoEdicao(Categoria categoria) {
		System.out.println("Editar categoria " + categoria + " ?");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.println("Digite: ");
		String decisao = scanner.next();
		if (decisao.equals("1")) {
			return true;
		}if (decisao.equals("2")) {
			return false;
		}else{
			System.out.println("Opção inválida. Por favor, digite novamente.");
			confirmacaoEdicao(categoria);
		}
		return false;

	}
}
