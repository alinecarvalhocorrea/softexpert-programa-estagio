package biblioteca;

import java.util.Set;

import biblioteca.memoria.BancoDeCategorias;

public class ListaDeCategorias {
	private static BancoDeCategorias bancoDeCategorias;
	
	public  ListaDeCategorias(BancoDeCategorias bancoDeCategorias){
		ListaDeCategorias.bancoDeCategorias = bancoDeCategorias;
	}
	
	public void listarCategorias(){
		Set<Categoria> listaDeCategorias = bancoDeCategorias.listar();
		for (Categoria categoria : listaDeCategorias) {
			System.out.println("Categoria: " + categoria + " | C�digo Sequencial: " + categoria.getCodigoSequencial());
		}
		
	}
	
	
}
