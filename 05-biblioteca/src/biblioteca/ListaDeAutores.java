package biblioteca;

import java.util.Set;

import biblioteca.memoria.BancoDeAutores;

public class ListaDeAutores {
	private static BancoDeAutores bancoDeAutores;
	
	public  ListaDeAutores(BancoDeAutores bancoDeAutores){
		ListaDeAutores.bancoDeAutores = bancoDeAutores;
	}
	
	public void listarAutores(){
		Set<Autor> listaDeAutores = bancoDeAutores.listar();
		for (Autor autor : listaDeAutores) {
			System.out.println("Nome: " + autor.getNome() + " | Nacionalidade: " + autor.getNacionalidade() + " | Data De Nascimento: " + autor.getDataDeNascimento() + " | Código Sequencial: " + autor.getCodigoSequencial());
		}
		
	}
}
