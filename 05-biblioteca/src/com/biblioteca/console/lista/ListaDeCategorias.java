package com.biblioteca.console.lista;

import java.util.Set;

import com.biblioteca.objetos.Categoria;
import com.biblioteca.repositorios.memoria.BancoDeCategorias;

public class ListaDeCategorias {
	private static BancoDeCategorias bancoDeCategorias;
	
	public  ListaDeCategorias(BancoDeCategorias bancoDeCategorias){
		ListaDeCategorias.bancoDeCategorias = bancoDeCategorias;
	}
	
	public void listarCategorias(){
		Set<Categoria> listaDeCategorias = bancoDeCategorias.listar();
		for (Categoria categoria : listaDeCategorias) {
			System.out.println("Categoria: " + categoria + " | Código Sequencial: " + categoria.getCodigoSequencial());
		}
		
	}
	
	
}
