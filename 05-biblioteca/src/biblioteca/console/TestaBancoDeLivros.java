package biblioteca.console;

/**
 * 
 * @author aline.correa
 * 
 */
import java.util.Collection;
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
		Autor autor1 = new Autor("Clarice Lispector", "Brasileira");
		Autor autor2 = new Autor("Nome", "alemã");
		Autor autor3 = new Autor("Antonio", "britânico");

		Categoria categoria1 = new Categoria("Drama");
		Categoria categoria2 = new Categoria("Ação");
		Categoria categoria3 = new Categoria("Suspense");

		// TESTE : Criando livros
		Livro a = new Livro();
		a.setTitulo("Aline 1");
		a.setAutor(autor1);
		a.setCategoria(categoria1);
		a.setResumo("safbfws fesfbuywsf firubfs ");
		a.setLocal("A3");
		System.out.println("Criando Livro: " + a.getTitulo());

		Livro b = new Livro();
		b.setTitulo("Aline testaando");
		b.setAutor(autor2);
		b.setCategoria(categoria2);
		b.setResumo("gnnfeiuaf");
		b.setLocal("B5");
		System.out.println("Criando Livro: " + b.getTitulo());

		Livro c = new Livro();
		c.setTitulo("SoftExpert");
		c.setAutor(autor3);
		c.setCategoria(categoria3);
		c.setResumo("hrsgeh5h");
		c.setLocal("D8");
		System.out.println("Criando Livro: " + c.getTitulo());

		Livro d = new Livro();
		d.setTitulo("livro teste");
		d.setAutor(autor3);
		d.setCategoria(categoria3);
		d.setResumo("hrsgeh5h");
		d.setLocal("A8");
		System.out.println("Criando Livro: " + d.getTitulo());

		Livro e = new Livro();
		e.setTitulo("afdvd");
		e.setAutor(autor3);
		e.setCategoria(categoria3);
		e.setResumo("hrsgeh5h");
		e.setLocal("C5");
		System.out.println("Criando Livro: " + e.getTitulo());

		Livro f = new Livro();
		f.setTitulo("aabdfbd");
		f.setAutor(autor3);
		f.setCategoria(categoria3);
		f.setResumo("hrsgeh5h");
		f.setLocal("D1");
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
		Collection<Livro> retornoTestePesquisaTitulo = bancoDeLivros.buscarPorTitulo(entradaPesquisaDeTituloUsuario);
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
