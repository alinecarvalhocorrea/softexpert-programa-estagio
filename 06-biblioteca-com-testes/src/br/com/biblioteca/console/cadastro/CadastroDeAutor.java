package br.com.biblioteca.console.cadastro;

import java.util.Scanner;
import java.util.Set;

import br.com.biblioteca.console.confirmacao.Confirmacao;
import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.objetos.DataInvalidaException;
import br.com.biblioteca.objetos.FormatoDeDataInvalidoException;
import br.com.biblioteca.objetos.NomeAutorNuloException;
import br.com.biblioteca.repositorios.interfaces.Autores;

public class CadastroDeAutor {
	private Scanner scanner;
	private static Autores bancoDeAutores;

	public CadastroDeAutor(Scanner scanner, Autores bancoDeAutores) {
		this.scanner = scanner;
		CadastroDeAutor.bancoDeAutores = bancoDeAutores;
	}

	public void cadastrarAutor(){
		scanner.nextLine();
		Autor novoAutor = new Autor();
		
		try{
			System.out.println("Insira o nome do(a) autor(a): ");
			String nome = scanner.nextLine();
			novoAutor.setNome(nome);
			
			System.out.println("Insira a nacionalidade do(a) autor(a): ");
			String nacionalidade = scanner.nextLine();
			novoAutor.setNacionalidade(nacionalidade);
			
			System.out.println("Insira a data de nascimento do(a) autor(a)(dd/mm/aaaa): ");
			String dataDeNascimento = scanner.nextLine();
			novoAutor.setDataDeNascimento(dataDeNascimento);

			System.out.println("Verificando se autor ja existe no banco...");
			Autor verifica = verificarExistenciaDeAutor(novoAutor);
	
			if (verifica != null) {
				System.out.println("Autor(a) ja existe no banco.");
				System.out.println(verifica);
				boolean verificarDecisaoParaEdicao = new Confirmacao(scanner,verifica).confirmaEdicao();
				if (verificarDecisaoParaEdicao) {
					bancoDeAutores.excluir(verifica);
					bancoDeAutores.excluir(novoAutor);
					cadastrarAutor();
				}else{
					System.out.println("Retornando...");
					return;
				}
			}
			
			bancoDeAutores.adicionar(novoAutor);
			
			System.out.println("Autor(a) adicionado ao banco:");
			System.out.println("Nome: " + novoAutor.getNome() + " | Nacionalidade: " + novoAutor.getNacionalidade() + " | Data De Nascimento: " + novoAutor.getDataDeNascimento() + " | Código Sequencial: " + novoAutor.getCodigoSequencial());
			
		}catch (NullPointerException e) {
			e.printStackTrace();
			cadastrarAutor();
		}catch (NomeAutorNuloException e){
			System.out.println(e.getMessage());
			cadastrarAutor();
		} catch (FormatoDeDataInvalidoException e) {
			System.out.println(e.getMessage());
			System.out.println("\nAutor(a) adicionado ao banco:");
			bancoDeAutores.adicionar(novoAutor);
			System.out.println("Nome: " + novoAutor.getNome() + " | Nacionalidade: " + novoAutor.getNacionalidade() + " | Data De Nascimento: " + novoAutor.getDataDeNascimento() + " | Código Sequencial: " + novoAutor.getCodigoSequencial());
		} catch (DataInvalidaException e) {
			System.out.println(e.getMessage());
			cadastrarAutor();
		}
		return;
	}

	private Autor verificarExistenciaDeAutor(Autor autor) {
		Set<Autor> banco = bancoDeAutores.listar();
		String nomeVerifica = "";
		String nacionalidadeVerifica = "";
		String dataVerifica = "";

		String nomeAutorPesquisado = autor.getNome();
		nomeAutorPesquisado = nomeAutorPesquisado.toUpperCase();
		String nacionalidadeAutorPesquisado = autor.getNacionalidade();
		nacionalidadeAutorPesquisado = nacionalidadeAutorPesquisado.toUpperCase();
		String dataDeNascAutorPesquisado = autor.getDataDeNascimento();

		for (Autor autorEmBanco : banco) {
			String nomeAutorEmBanco = autorEmBanco.getNome();
			nomeAutorEmBanco = nomeAutorEmBanco.toUpperCase();
			String nacionalidadeAutorEmBanco = autorEmBanco.getNacionalidade();
			nacionalidadeAutorEmBanco = nacionalidadeAutorEmBanco.toUpperCase();
			String dataDeNascAutorEmBanco = autorEmBanco.getDataDeNascimento();

			if (nomeAutorPesquisado.equalsIgnoreCase(nomeAutorEmBanco)) {
				nomeVerifica = "OK";
			}
			if (dataDeNascAutorPesquisado.equals(dataDeNascAutorEmBanco)) {
				dataVerifica = "OK";
			}
			if (nacionalidadeAutorPesquisado.equals(nacionalidadeAutorEmBanco)) {
				nacionalidadeVerifica = "OK";
			}
			if (nomeVerifica.equals("OK")) {
				if (dataVerifica.equals("OK")) {
					if (nacionalidadeVerifica.equals("OK")) {
						return autorEmBanco;
					}
				}
			}
		}
		return null;
	}
}
