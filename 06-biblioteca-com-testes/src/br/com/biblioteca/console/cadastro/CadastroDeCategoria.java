package br.com.biblioteca.console.cadastro;

import java.util.Scanner;
import java.util.Set;

import br.com.biblioteca.objetos.Categoria;
import br.com.biblioteca.objetos.DescricaoCategoriaNulaException;
import br.com.biblioteca.repositorios.interfaces.Categorias;

public class CadastroDeCategoria {
	private Scanner scanner;
	private static Categorias bancoDeCategorias;

	public CadastroDeCategoria(Scanner scanner, Categorias bancoDeCategorias) {
		this.scanner = scanner;
		CadastroDeCategoria.bancoDeCategorias = bancoDeCategorias;
	}

	public void cadastrarCategoria() {
		scanner.nextLine();
		try{
			System.out.println("Insira a descrição da categoria: ");
			String descricao = scanner.nextLine();
			Categoria novaCategoria = new Categoria(descricao);
			
			System.out.println("Verificando se categoria ja existe no banco...");
			
			boolean resultado = verificaExistenciaDeCategoriaPorDescricao(descricao);
			if(resultado){
				System.out.println("*** Categoria:" + descricao.toUpperCase() + " ja existe ***");
				return;
			}else{
				System.out.println("Nova categoria criada: " + descricao.toUpperCase());
				bancoDeCategorias.adicionar(novaCategoria);
			}
		}catch(DescricaoCategoriaNulaException e){
			System.out.println(e.getMessage());
			cadastrarCategoria();
		}
	}
	
	private boolean verificaExistenciaDeCategoriaPorDescricao(String descricao){
		try{
			@SuppressWarnings("unused")
			Set<Categoria> busca = bancoDeCategorias.buscarCategoriaPorDescricao(descricao);
			return true;
		}catch(NullPointerException e){
			return false;
		}
		
	}
	
}
