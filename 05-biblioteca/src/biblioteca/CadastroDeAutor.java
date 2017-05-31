package biblioteca;

import java.util.Scanner;
import java.util.Set;

import biblioteca.memoria.BancoDeAutores;

public class CadastroDeAutor {
	private Scanner scanner;
	private static BancoDeAutores bancoDeAutores;

	public CadastroDeAutor(Scanner scanner, BancoDeAutores bancoDeAutores) {
		this.scanner = scanner;
		CadastroDeAutor.bancoDeAutores = bancoDeAutores;
	}

	public void cadastrarAutor() {
		scanner.nextLine();
		System.out.println("Insira o nome do(a) autor(a): ");
		String nome = scanner.nextLine();
		System.out.println("Insira a nacionalidade do(a) autor(a): ");
		String nacionalidade = scanner.nextLine();
		System.out.println("Insira a data de nascimento do(a) autor(a)(dd/mm/aaaa): ");
		String dataDeNascimento = scanner.nextLine();
		Autor novoAutor = new Autor(nome);
		if (nacionalidade != null) {
			novoAutor.setNacionalidade(nacionalidade);
		}
		if (dataDeNascimento != null) {
			try {
				novoAutor.setDataDeNascimento(dataDeNascimento);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				cadastrarAutor();
			}
		}

		Autor verifica = verificarExistênciaDeAutor(novoAutor);
		System.out.println("Verificando se autor ja existe no banco...");
		if (verifica != null) {
			System.out.println("Autor(a) ja existe no banco.");
			System.out.println(verifica);
			boolean verificarDecisaoParaEdicao = confirmacaoEdicao(verifica);
			if (verificarDecisaoParaEdicao) {
				bancoDeAutores.excluir(verifica);
				bancoDeAutores.excluir(novoAutor);
				cadastrarAutor();
			}
		}
		bancoDeAutores.adicionar(novoAutor);
		System.out.println("Autor(a) adicionado ao banco:");
		System.out.println(novoAutor);
		return;
	}

	private Autor verificarExistênciaDeAutor(Autor autor) {
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

	private boolean confirmacaoEdicao(Autor autor) {
		System.out.println("Editar autor ?");
		System.out.println(autor);
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.println("Digite: ");
		String decisao = scanner.next();
		if (decisao.equals("1")) {
			return true;
		}
		if (decisao.equals("2")) {
			return false;
		} else {
			System.out.println("Opção inválida. Por favor, digite novamente.");
			confirmacaoEdicao(autor);
		}
		return false;

	}
}
