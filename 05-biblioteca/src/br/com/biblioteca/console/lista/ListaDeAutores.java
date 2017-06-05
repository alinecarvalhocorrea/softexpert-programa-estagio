package br.com.biblioteca.console.lista;

import java.util.Set;

import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.repositorios.memoria.BancoDeAutores;

public class ListaDeAutores {
	private static BancoDeAutores bancoDeAutores;
	
	public  ListaDeAutores(BancoDeAutores bancoDeAutores){
		ListaDeAutores.bancoDeAutores = bancoDeAutores;
	}
	
	public void listarAutores(){
		Set<Autor> listaDeAutores = bancoDeAutores.listar();
		for (Autor autor : listaDeAutores) {
			System.out.println("Nome: " + autor.getNome() + " | Nacionalidade: " + autor.getNacionalidade() + " | Data De Nascimento: " + autor.getDataDeNascimento() + " | C�digo Sequencial: " + autor.getCodigoSequencial());
		}
		
	}
}
