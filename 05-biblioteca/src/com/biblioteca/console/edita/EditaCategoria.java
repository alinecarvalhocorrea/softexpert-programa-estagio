package com.biblioteca.console.edita;

import java.util.Scanner;

import com.biblioteca.console.cadastro.CadastroDeCategoria;
import com.biblioteca.console.confirmacao.Confirmacao;
import com.biblioteca.console.pesquisa.categoria.PesquisaCategoriaPorCodigoSequencial;
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
		System.out.println("Buscando categoria...");
		boolean pesquisa = new PesquisaCategoriaPorCodigoSequencial(scanner, bancoDeCategorias).verificaExistenciaDeCategoriaPorCodigoSequencial(codigoSequencial);
		if(pesquisa){
			Categoria categoria = bancoDeCategorias.buscarPorCodigoSequencial(codigoSequencial);
			System.out.println("Categoria Encontrada: " + categoria + " | Código Sequencial: " + categoria.getCodigoSequencial());
			boolean decisao = new Confirmacao(scanner, categoria).confirmaEdicao();
			if(decisao){
				bancoDeCategorias.editar(categoria);
				CadastroDeCategoria cadastraCategoriaNova = new CadastroDeCategoria(scanner,bancoDeCategorias);
				cadastraCategoriaNova.cadastrarCategoria();
			}else {
				return;
			}
		}else{
			System.out.println("Categoria não encontrada. Por favor, verifique o código informado e tente novamente.");
			return;
		}
			
	}
}
