package com.biblioteca.console.pesquisa.livro;

import java.util.Scanner;

import com.biblioteca.objetos.Livro;
import com.biblioteca.repositorios.memoria.BancoDeLivros;

public class PesquisaLivroPorCodigoSequencial {
		private Scanner scanner;
		private static BancoDeLivros bancoDeLivros;
		
		public PesquisaLivroPorCodigoSequencial(Scanner scanner, BancoDeLivros bancoDeLivros){
			this.scanner = scanner;
			PesquisaLivroPorCodigoSequencial.bancoDeLivros = bancoDeLivros;
		}
		
		public void pesquisarLivroPorCodigoSequencial(){
			System.out.println("Insira o código sequencial: ");
			scanner.nextLine();
			String codigoParaPesquisar = scanner.nextLine();
			System.out.println("Pesquisando livro no banco...");
			boolean verifica = verificaExistenciaDeLivroPorCodigoSequencial(codigoParaPesquisar);
			
			if(verifica){
				Livro busca = bancoDeLivros.buscarPorCodigoSequencial(codigoParaPesquisar);
				System.out.println("Livro Encontrado:");
				System.out.println(busca);
			}else{
				System.out.println("Livro não encontrado, verifique o código informado e tente novamente.");
				return;
			}
		}

		public boolean verificaExistenciaDeLivroPorCodigoSequencial(String codigo) {
			Livro busca = bancoDeLivros.buscarPorCodigoSequencial(codigo);
			if (busca != null) {
				return true;
			}
			return false;
		}
}
