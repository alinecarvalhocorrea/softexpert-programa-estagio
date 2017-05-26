package biblioteca.console;

/**
 * 
 * @author aline.correa
 * 
 */
import java.util.Collection;
import java.util.Set;
import biblioteca.Autor;
import biblioteca.Categoria;
import biblioteca.Livro;
import biblioteca.Livros;
import biblioteca.memoria.BancoDeLivros;

public class TestaBancoDeLivros {
	public static void main(String[] args) {

		Livros bl = new BancoDeLivros();
		// Livros bl = new livrosEmBancoDeDados();

		Autor autor1 = new Autor("Clarice Lispector", "Brasileira");
		Autor autor2 = new Autor("Nome", "alemã");
		Autor autor3 = new Autor("Antonio", "britânico");

		Categoria categoria1 = new Categoria("Drama");
		Categoria categoria2 = new Categoria("Ação");
		Categoria categoria3 = new Categoria("Suspense");

		Livro a = new Livro();
		a.setTitulo("Aline 1");
		a.setAutor(autor1);
		a.setCategoria(categoria1);
		a.setResumo("safbfws fesfbuywsf firubfs ");
		a.setLocal("A3");

		Livro b = new Livro();
		b.setTitulo("Aline testaando");
		b.setAutor(autor2);
		b.setCategoria(categoria2);
		b.setResumo("gnnfeiuaf");
		b.setLocal("B5");

		Livro c = new Livro();
		c.setTitulo("SoftExpert");
		c.setAutor(autor3);
		c.setCategoria(categoria3);
		c.setResumo("hrsgeh5h");
		c.setLocal("D8");

		Livro d = new Livro();
		d.setTitulo("livro teste");
		d.setAutor(autor3);
		d.setCategoria(categoria3);
		d.setResumo("hrsgeh5h");
		d.setLocal("A8");

		Livro e = new Livro();
		e.setTitulo("afdvd");
		e.setAutor(autor3);
		e.setCategoria(categoria3);
		e.setResumo("hrsgeh5h");
		e.setLocal("C5");

		Livro f = new Livro();
		f.setTitulo("aabdfbd");
		f.setAutor(autor3);
		f.setCategoria(categoria3);
		f.setResumo("hrsgeh5h");
		f.setLocal("D1");

		adicionar(bl, b);
		adicionar(bl, a);
		adicionar(bl, c);
		adicionar(bl, d);
		adicionar(bl, e);
		adicionar(bl, f);

		Set<Livro> listaDeLivros = bl.listar();

		for (Livro livro : listaDeLivros) {
			System.out.println(livro);
		}

		bl.excluir(b);

		System.out.println("\nResultado pesquisa por título:");
		String entradaPesquisaDeTituloUsuario = "testa"; // Vem do usuario
		Collection<Livro> retornoTestePesquisaTitulo = bl.buscarPorTitulo(entradaPesquisaDeTituloUsuario);
		if (!retornoTestePesquisaTitulo.isEmpty()) {
			System.out.println("Livro(s) Encontrado(s):");
			for (Livro livro : retornoTestePesquisaTitulo) {
				System.out.println(livro);
			}
		} else {
			System.out.println("Não foram encontrados livros");
		}
			
		System.out.println("\nResultado pesquisa por código sequencial:");
		// para buscar por codigo valido: retornoTestePesquisaTitulo.iterator().next().getCodigoSequencial());
		Livro test = bl.buscarPorCodigoSequencial("gjgyututuyuy"); 
		System.out.println("#####" + test);

	}

	private static boolean adicionar(Livros banco, Livro livro) {

		try {
			banco.adicionar(livro);
			return true;

		} catch (NullPointerException e) {
			System.out.println("Nao foi possivel criar com o autor: " + livro.getAutor());
			System.out.println(e.getMessage());
			return false;
		}
	}

}
