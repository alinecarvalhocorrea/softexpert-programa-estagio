package biblioteca;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import biblioteca.memoria.BancoDeAutores;

public class CadastroDeAutor {
	private Scanner scanner;
	private static BancoDeAutores bancoDeAutores;
	
	public CadastroDeAutor(Scanner scanner, BancoDeAutores bancoDeAutores){
		this.scanner = scanner;
		CadastroDeAutor.bancoDeAutores = bancoDeAutores;
	}
	
	public void cadastrarAutor(){
		System.out.println("Insira o nome do(a) autor(a): ");
		scanner.nextLine();
		String nome = scanner.nextLine();
		System.out.println("Insira a nacionalidade do(a) autor(a): ");
		scanner.nextLine();
		String nacionalidade = scanner.nextLine();
		System.out.println("Insira a data de nascimento do(a) autor(a)(dd/mm/aaaa): ");
		scanner.nextLine();
		String dataDeNascimento = scanner.nextLine();
		
		Autor novoAutor = new Autor(nome);
		
		if(nacionalidade != null){
			novoAutor.setNacionalidade(nacionalidade);
		}
		if (dataDeNascimento != null) {
			novoAutor.setDataDeNascimento(dataDeNascimento);
		}
		
		System.out.println("Verificando se autor ja existe no banco...");
		boolean verifica = verificarExistênciaDeAutor(novoAutor);
		if(verifica){
			System.out.println("Autor(a) ja existe no banco.");
		}else{
			System.out.println("Autor(a):"+ novoAutor.getNome() +" adicionado ao banco.");
			bancoDeAutores.adicionar(novoAutor);
		}
		
	}
	
	private boolean verificarExistênciaDeAutor(Autor autor){
		Set<Autor> autores = new HashSet<>();
		for (Autor autorEmBanco : autores) {
			if(autor.getNome().equals(autorEmBanco.getNome())){
				return true;
			}
		}
		return false;
	}
}
