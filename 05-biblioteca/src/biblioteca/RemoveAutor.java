package biblioteca;

import java.util.Scanner;

import biblioteca.memoria.BancoDeAutores;

public class RemoveAutor {
	private static BancoDeAutores bancoDeAutores;
	private Scanner scanner;

	public RemoveAutor(Scanner scanner, BancoDeAutores bancoDeAutores) {
		this.scanner = scanner;
		RemoveAutor.bancoDeAutores = bancoDeAutores;
	}

	public void removerAutor() {
		System.out.println("Insira o código sequencial da Autor: ");
		scanner.nextLine();
		String codigoSequencial = scanner.nextLine();
		System.out.println("Buscando Autor...");
		boolean verifica = new PesquisaAutorPorCodigoSequencial(scanner, bancoDeAutores).verificaExistenciaDeAutorPorCodigoSequencial(codigoSequencial);
		if(verifica){
			Autor autor = bancoDeAutores.buscarPorCodigoSequencial(codigoSequencial);
			System.out.println("Autor(a) Encontrado(a): " + autor);
			boolean decisao = confirmacaoRemoção(autor);
				if (decisao) {
						bancoDeAutores.excluir(autor);
						System.out.println("Autor(a) " + autor + " removido(a).");
				} else {
					return;
		}
		}else{
			System.out.println("Autor(a) não encontrado(a). Por favor, verifique o código sequencial informado e tente novamente.");
			return;
		}
	}

	private boolean confirmacaoRemoção(Autor autor) {
		System.out.println("Excluir Autor " + autor + " ?");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.println("Digite: ");
		String decisao = scanner.next();
		if (decisao.equals("1")) {
			return true;
		} else {
			System.out.println("Opção inválida. Por favor, digite novamente.");
			confirmacaoRemoção(autor);
		}
		return false;

	}
}
