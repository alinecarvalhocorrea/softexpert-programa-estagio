package biblioteca.console;

import java.util.Set;

/**
 * 
 * @author aline.correa
 * 
 */
import biblioteca.Autor;
import biblioteca.memoria.BancoDeAutores;

public class TestaBancoDeAutores {

	public static void main(String[] args) {
		// TESTE : Criar autores
		System.out.println("Criando autores...");
		Autor a1 = new Autor("Bruna a clarice", "brasileira");
		Autor a2 = new Autor("Aline", "britânica");
		Autor a3 = new Autor("Joaquim Teste", "alemã");
		Autor a4 = new Autor("Joao Testando Nome", "francês");

		// TESTE : Criar Banco de Autores
		System.out.println("Criando Banco de Autores...");
		BancoDeAutores bancoDeAutores = new BancoDeAutores();

		// TESTE : Adicionar Autores no Banco
		System.out.println("Adicionando Autores no Banco...");
		System.out.println("Adicionando Autor(a):" + a1.getNome());
		bancoDeAutores.adicionar(a1);
		System.out.println("Adicionando Autor(a):" + a2.getNome());
		bancoDeAutores.adicionar(a2);
		System.out.println("Adicionando Autor(a):" + a3.getNome());
		bancoDeAutores.adicionar(a3);
		System.out.println("Adicionando Autor(a):" + a4.getNome());
		bancoDeAutores.adicionar(a4);

		System.out.println("\n");

		// TESTE : Listar Banco de Autores
		System.out.println("Listando Banco de Autores...");
		Set<Autor> listarBanco = bancoDeAutores.listar();
		for (Autor autor : listarBanco) {
			System.out.println(autor);
		}

		System.out.println("\n");

		// TESTE : Excluir Autor
		System.out.println("Excluindo Autor(a): " + a2.getNome());
		bancoDeAutores.excluir(a2);

		System.out.println("\n");

		// TESTE : Buscar Autor por Nome
		System.out.println("Resultado de Busca por Nome: clarice");
		Set<Autor> listaAutores1 = bancoDeAutores.buscarPorNome("clarice");
		for (Autor autor : listaAutores1) {
			System.out.println(autor);
		}

		System.out.println("\n");

		// TESTE : Buscar Autor por Código Sequencial(Existente)
		System.out.println("Resultado de Busca por Codigo Sequencial Existente: " + a4.getCodigoSequencial());
		Autor autorEncontrado1 = bancoDeAutores.buscarPorCodigoSequencial(a4.getCodigoSequencial());
		if (autorEncontrado1 == null) {
			System.out.println("Autor(a) não encontrado(a). Código sequencial não existe");
		} else {
			System.out.println(autorEncontrado1);
		}

		System.out.println("\n");

		// TESTE : Buscar Autor por Código Sequencial(Não Existente)
		System.out.println("Resultado de Busca por Codigo Sequencial Não Existente: bsgdss");
		Autor autorEncontrado2 = bancoDeAutores.buscarPorCodigoSequencial("bsgdss");
		if (autorEncontrado2 == null) {
			System.out.println("Autor(a) não encontrado(a). Código sequencial não existe");
		} else {
			System.out.println(autorEncontrado2);
		}

		System.out.println("\n");

		// TESTE : Buscar Autor por Nacionalidade
		System.out.println("Resultado de Busca por nacionalidade:");
		Set<Autor> autorEncontrado3 = bancoDeAutores.buscarPorNacionalidade("alemã");
		if (autorEncontrado3.isEmpty()) {
			System.out.println("Nenhum(a) autor(a) não encontrado(a)");
		} else {
			for (Autor autor : autorEncontrado3) {
				System.out.println(autor);
			}
		}

		System.out.println("\n");

		// TODO TESTE : Buscar Autor por Data de Nascimento
	}

}
