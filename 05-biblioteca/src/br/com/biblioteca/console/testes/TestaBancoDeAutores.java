package br.com.biblioteca.console.testes;

import java.util.Set;

import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.repositorios.memoria.BancoDeAutoresEmMemoria;

public class TestaBancoDeAutores {

	public static void main(String[] args) {
		// TESTE : Criar autores
		System.out.println("Criando autores...");
		Autor a1 = new Autor("Bruna a clarice");
		a1.setDataDeNascimento("15/03/2010");
		a1.setNacionalidade("russo");
		Autor a2 = new Autor("Aline");
		a2.setDataDeNascimento("08/11/1997");
		a2.setNacionalidade("russo");
		Autor a3 = new Autor("Joaquim Teste");
		a3.setDataDeNascimento("10/10/2009");
		a3.setNacionalidade("russo");
		Autor a4 = new Autor("Joao Testando Nome");
		a4.setDataDeNascimento("08/11/1997");
		a4.setNacionalidade("russo");

		// TESTE : Criar Banco de Autores
		System.out.println("Criando Banco de Autores...");
		BancoDeAutoresEmMemoria bancoDeAutores = new BancoDeAutoresEmMemoria();

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

		// TESTE : Buscar Autor por Data de Nascimento
	}

}
