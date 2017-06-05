package br.com.biblioteca.console.pesquisa.livro;

import java.util.Scanner;

import br.com.biblioteca.objetos.Livro;
import br.com.biblioteca.repositorios.memoria.BancoDeLivros;

public class PesquisaLivroPorCodigoDeBarras {
	private Scanner scanner;
	private static BancoDeLivros bancoDeLivros;
	
	public PesquisaLivroPorCodigoDeBarras( Scanner scanner,BancoDeLivros bancoDeLivros){
		this.scanner = scanner;
		PesquisaLivroPorCodigoDeBarras.bancoDeLivros = bancoDeLivros;
	}
	
	public void pesquisaLivroPorCodigoDeBarras(){
		System.out.println("Insira o c�digo de barras:");
		scanner.nextLine();
		String codigoParaPesquisar = scanner.nextLine();
		boolean verifica = verificarExistenciaDeLivroPorCodigoDeBarras(codigoParaPesquisar);
		
		if(verifica){
			Livro livroEncontrado = bancoDeLivros.buscarPorCodigoDeBarras(codigoParaPesquisar);
			System.out.println("Livro encontrado:");
			System.out.println(livroEncontrado);
		}else{
			System.out.println("Livro n�o encontrado, verifique o c�digo informado e tente novamente.");
			return;
		}
	}

	private boolean verificarExistenciaDeLivroPorCodigoDeBarras(String codigo) {
		Livro busca = bancoDeLivros.buscarPorCodigoDeBarras(codigo);
		if(busca != null){
			return true;
		}
		return false;
	}
}
