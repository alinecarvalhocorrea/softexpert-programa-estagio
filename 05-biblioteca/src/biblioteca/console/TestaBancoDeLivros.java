package biblioteca.console;

import java.util.List;
import java.util.Set;

import biblioteca.Autor;
import biblioteca.Categoria;
import biblioteca.Livro;
import biblioteca.Livros;
import biblioteca.memoria.BancoDeLivros;

public class TestaBancoDeLivros {
	public static void main(String[] args) {
		// TESTE : Inicializando Banco de Livros
		System.out.println("Inicializando Banco de Livros...");
		Livros bancoDeLivros = new BancoDeLivros();
		// Livros bl = new livrosEmBancoDeDados();

		// TESTE : Inicializando alguns autores(as) e categorias
		Autor autor1 = new Autor("Clarice Lispector");
		autor1.setNacionalidade("brasileira");
		autor1.setDataDeNascimento("08/10/2010");
		Autor autor2 = new Autor("Nome");
		autor2.setNacionalidade("francês");
		autor2.setDataDeNascimento("08/11/1997");
		Autor autor3 = new Autor("Antonio");
		autor3.setNacionalidade("alemão");
		autor3.setDataDeNascimento("02/03/2012");

		Categoria categoria1 = new Categoria("Drama");
		Categoria categoria2 = new Categoria("Ação");
		Categoria categoria3 = new Categoria("Suspense");

		// TESTE : Criando livros
		Livro a = new Livro(autor1,categoria1,"Aline 1","A3");
		a.setDataDeAquisicao("10/07/2015");
		a.setResumo("safbfws fesfbuywsf firubfs ");
		System.out.println("Criando Livro: " + a.getTitulo());

		Livro b = new Livro(autor2,categoria2,"Aline testaando","B5");
		b.setDataDeAquisicao("2015/10/07");
		b.setResumo("gnnfeiuaf");
		System.out.println("Criando Livro: " + b.getTitulo());

		Livro c = new Livro(autor3,categoria3,"SoftExpert","D8");
		c.setDataDeAquisicao("25/08/2017");
		c.setResumo("hrsgeh5h");
		System.out.println("Criando Livro: " + c.getTitulo());

		Livro d = new Livro(autor3,categoria3,"livro teste","A8");
		d.setDataDeAquisicao("01/01/2017");
		d.setResumo("hrsgeh5h");
		System.out.println("Criando Livro: " + d.getTitulo());
		
		Livro e = new Livro(autor3,categoria3,"afdvd","C5");
		e.setDataDeAquisicao("25/02/2017");
		e.setResumo("hrsgeh5h");
		System.out.println("Criando Livro: " + e.getTitulo());

		Livro f = new Livro(autor3,categoria3,"aabdfbd","D1");
		f.setDataDeAquisicao("03/05/2017");
		f.setResumo("hrsgeh5h");
		System.out.println("Criando Livro: " + f.getTitulo());

		// TESTE : Adicionando livros no banco
		System.out.println("Adicionando Livros no Banco...");
		bancoDeLivros.adicionar(b);
		bancoDeLivros.adicionar(a);
		bancoDeLivros.adicionar(c);
		bancoDeLivros.adicionar(d);
		bancoDeLivros.adicionar(e);
		bancoDeLivros.adicionar(f);

		System.out.println("\n");

		// TESTE : Listar Banco de Livros
		Set<Livro> listaDeLivros = bancoDeLivros.listar();
		System.out.println("Listando Banco de Livros:");
		for (Livro livro : listaDeLivros) {
			System.out.println(livro);
		}

		System.out.println("\n");

		// TESTE : Excluir Livro
		System.out.println("Excluindo Livro: " + b.getTitulo());
		bancoDeLivros.excluir(b);

		System.out.println("\n");

		// TESTE : Buscar por título
		System.out.println("Resultado pesquisa por título: A");
		String entradaPesquisaDeTituloUsuario = " " + "A"; // Vem do usuario
		Set<Livro> retornoTestePesquisaTitulo = bancoDeLivros.buscarPorTitulo(entradaPesquisaDeTituloUsuario);
		for (Livro livro : retornoTestePesquisaTitulo) {
			System.out.println(livro);
		}

		System.out.println("\n");

		// TESTE : Buscar por codigo sequencial não existente:
		// retornoTestePesquisaTitulo.iterator().next().getCodigoSequencial());
		System.out.println("Resultado pesquisa por código sequencial(Não Existente):");
		Livro resultado1 = bancoDeLivros.buscarPorCodigoSequencial("gjgyututuyuy");
		if (resultado1 == null) {
			System.out.println("Nenhum livro encontrado");
		} else {
			System.out.println(resultado1);
		}

		System.out.println("\n");

		// TESTE : Buscar por codigo sequencial existente:
		System.out.println("Resultado pesquisa por código sequencial(Existente):");
		Livro resultado2 = bancoDeLivros
				.buscarPorCodigoSequencial(retornoTestePesquisaTitulo.iterator().next().getCodigoSequencial());
		System.out.println(resultado2);

		System.out.println("\n");

		// TESTE : Encontrar livros por categoria
		System.out.println("Resultado pesquisa por categoria: Suspense");
		List<Livro> livrosEncontrados = bancoDeLivros.buscarPorCategoria("Suspense");
		if (livrosEncontrados.isEmpty()) {
			System.out.println("Nenhum livro encontrado");
		} else {
			for (Livro livro : livrosEncontrados) {
				System.out.println(livro);
			}
		}

		System.out.println("\n");

		System.out.println("Resultado pesquisa por categoria: Drama");
		List<Livro> livrosEncontrados2 = bancoDeLivros.buscarPorCategoria("drama");
		if (livrosEncontrados2.isEmpty()) {
			System.out.println("Nenhum livro encontrado");
		} else {
			for (Livro livro : livrosEncontrados2) {
				System.out.println(livro);
			}
		}

		System.out.println("\n");

		System.out.println("Resultado pesquisa por categoria: ação");
		List<Livro> livrosEncontrados3 = bancoDeLivros.buscarPorCategoria("ação");
		if (livrosEncontrados3.isEmpty()) {
			System.out.println("Nenhum livro encontrado");
		} else {
			for (Livro livro : livrosEncontrados3) {
				System.out.println(livro);
			}
		}

	}

}
