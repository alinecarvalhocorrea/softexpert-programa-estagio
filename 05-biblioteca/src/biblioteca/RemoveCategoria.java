package biblioteca;

import java.util.Scanner;

import biblioteca.memoria.BancoDeCategorias;

public class RemoveCategoria {
	private static BancoDeCategorias bancoDeCategorias;
	private Scanner scanner;

	public RemoveCategoria(Scanner scanner, BancoDeCategorias bancoDeCategorias) {
		this.scanner = scanner;
		RemoveCategoria.bancoDeCategorias = bancoDeCategorias;
	}

	public void removerCategoria() {
		System.out.println("Insira o c�digo sequencial da categoria: ");
		scanner.nextLine();
		String codigoSequencial = scanner.nextLine();
		System.out.println("Buscando categoria...");
		boolean verifica = new PesquisaCategoria(scanner, bancoDeCategorias).verificaExistenciaDeCategoriaPorCodigoSequencial(codigoSequencial);
		if(verifica){
			Categoria categoria = bancoDeCategorias.buscarPorCodigoSequencial(codigoSequencial);
			System.out.println("Categoria Encontrada: " + categoria + " | C�digo Sequencial: " + categoria.getCodigoSequencial());
			boolean decisao = confirmacaoRemo��o(categoria);
				if (decisao) {
						bancoDeCategorias.excluir(categoria);
						System.out.println("Categoria " + categoria + " removida.");
				} else {
					return;
		}
		}else{
			System.out.println("Categoria n�o encontrada. Por favor, verifique o c�digo sequencial informado e tente novamente.");
			return;
		}
	}

	private boolean confirmacaoRemo��o(Categoria categoria) {
		System.out.println("Excluir categoria " + categoria + " ?");
		System.out.println("1 - Sim");
		System.out.println("2 - N�o");
		System.out.println("Digite: ");
		String decisao = scanner.next();
		if (decisao.equals("1")) {
			return true;
		} else {
			System.out.println("Op��o inv�lida. Por favor, digite novamente.");
			confirmacaoRemo��o(categoria);
		}
		return false;

	}
}
