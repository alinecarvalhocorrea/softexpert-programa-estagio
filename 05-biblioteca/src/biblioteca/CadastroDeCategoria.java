package biblioteca;

import java.util.Scanner;
import java.util.Set;

import biblioteca.memoria.BancoDeCategorias;

public class CadastroDeCategoria {
	private Scanner scanner;
	private static BancoDeCategorias bancoDeCategorias;

	public CadastroDeCategoria(Scanner scanner, BancoDeCategorias bancoDeCategorias) {
		this.scanner = scanner;
		CadastroDeCategoria.bancoDeCategorias = bancoDeCategorias;
	}

	public void cadastrarCategoria() {
		System.out.println("Insira a descrição da categoria: ");
		scanner.nextLine();
		String descricao = scanner.nextLine();
		Categoria novaCategoria = new Categoria(descricao);
		System.out.println("Verificando se categoria ja existe no banco...");
		
		boolean resultado = verificaExistênciaDeCategoriaPorDescricao(descricao);
		if(resultado){
			return;
		}else{
			System.out.println("Nova categoria criada: " + descricao.toUpperCase());
			bancoDeCategorias.adicionar(novaCategoria);
		}
	}
	
	private boolean verificaExistênciaDeCategoriaPorDescricao(String descricao){
		Set<Categoria> busca = bancoDeCategorias.buscarCategoriaPorDescricao(descricao);
		if(!busca.isEmpty()){
			return true;
		}
		return false;
	}
	
}
