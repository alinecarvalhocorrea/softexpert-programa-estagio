package br.com.biblioteca.console.lista;

import java.util.Set;

import br.com.biblioteca.objetos.Categoria;
import br.com.biblioteca.repositorios.interfaces.Categorias;

public class ListaDeCategorias {
	private static Categorias bancoDeCategorias;
	
	public  ListaDeCategorias(Categorias bancoDeCategorias2){
		ListaDeCategorias.bancoDeCategorias = bancoDeCategorias2;
	}
	
	public void listarCategorias(){
		Set<Categoria> listaDeCategorias = bancoDeCategorias.listar();
		for (Categoria categoria : listaDeCategorias) {
			System.out.println("Categoria: " + categoria + " | Código Sequencial: " + categoria.getCodigoSequencial());
		}
		
	}
	
	
}
