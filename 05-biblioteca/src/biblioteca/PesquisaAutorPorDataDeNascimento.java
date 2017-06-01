package biblioteca;

import java.util.Scanner;
import java.util.Set;

import biblioteca.memoria.BancoDeAutores;

public class PesquisaAutorPorDataDeNascimento {
	private Scanner scanner;
	private static BancoDeAutores bancoDeAutores;
	
	public PesquisaAutorPorDataDeNascimento(Scanner scanner, BancoDeAutores bancoDeAutores){
		this.scanner = scanner;
		PesquisaAutorPorDataDeNascimento.bancoDeAutores = bancoDeAutores;
	}
	
	// TODO Pesquisa de Autor por Data de Nascimento
	// Método ja criado : Set<Autor> buscarPorDataDeNascimento(String dataDeNascimento)
}
