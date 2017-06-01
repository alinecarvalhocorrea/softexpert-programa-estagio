package com.biblioteca.console.pesquisa.autor;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import com.biblioteca.objetos.Autor;
import com.biblioteca.repositorios.memoria.BancoDeAutores;

public class PesquisaAutorPorDataDeNascimento {
	private Scanner scanner;
	private static BancoDeAutores bancoDeAutores;
	
	public PesquisaAutorPorDataDeNascimento(Scanner scanner, BancoDeAutores bancoDeAutores){
		this.scanner = scanner;
		PesquisaAutorPorDataDeNascimento.bancoDeAutores = bancoDeAutores;
	}
	
	public void pesquisarAutorPorDataDeNascimento(){
		scanner.nextLine();
		System.out.println("Insira a data de nascimento: ");
		String dataPesquisa = scanner.nextLine();
		System.out.println("Pesquisando autor(es) no banco...");
		boolean verifica = verificaExistenciaDeAutorPorDataDeNascimento(dataPesquisa);
		if(verifica){
			Set<Autor> banco = bancoDeAutores.listar();
			System.out.println("Autor(es) encontrado(s):");
				for (Autor autor : banco) {
					if(autor.getDataDeNascimento().equals(dataPesquisa)){
						System.out.println(autor);
					}
				}
		}else{
			System.out.println("Nenhum autor(a) encontrado(a). Por favor verifique a data de nascimento inserida e tente novamente.");
		}
	}

	private boolean verificaExistenciaDeAutorPorDataDeNascimento(String data) {
		Set<Autor> busca = new TreeSet<>();
		busca = (bancoDeAutores.buscarPorDataDeNascimento(data));
		if (!busca.isEmpty()) {
			return true;
		}
		return false;
	}
	
}
