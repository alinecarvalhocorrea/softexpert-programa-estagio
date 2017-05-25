package biblioteca.memoria;

/**
 * 
 * @author aline.correa
 *
 */
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import biblioteca.Livro;
import biblioteca.Livros;

public class BancoDeLivros implements Livros {

	private static Set<Livro> banco = new TreeSet<>();

	public void adicionar(Livro livro) {

		// TODO tem que colocar mais validações para adição de livros
		if (livro.getTitulo() == null) {
			throw new NullPointerException("O livro está sem titulo, favor colocar");
		}
		banco.add(livro);
	}

	public void excluir(Livro livro) {
		banco.remove(livro);
	}

	public void editar(Livro livroParaEditar) {
		excluir(livroParaEditar);
		adicionar(livroParaEditar);
	}

	public Set<Livro> listar() {
		return banco;
	}

	@Override
	public List<Livro> buscarPorTitulo(String titulo) {
		// TODO tem que implementar busca por titulo

		List<Livro> livrosEncontrados = new ArrayList<>();

		for (Livro livro : banco) {
			String livroTitulo = livro.getTitulo();

			if (livroTitulo.toLowerCase().contains(titulo.toLowerCase())) {
				livrosEncontrados.add(livro);
			}
		}
		if (!livrosEncontrados.isEmpty()) {
			return livrosEncontrados;
		}
		return null;
	}

	@Override
	public Livro buscarPorCodigoSequencial(long codigoSequencial) {
		for (Livro livro : banco) {
			long codigoLivro = livro.getCodigoSequencial();
			if (codigoLivro == codigoSequencial) {
				return livro;
			}
		}
		return null;
	}

	@Override
	public Livro buscarPorCodigoDeBarras(long codigoDeBarras) {
		// TODO tem que implementar busca por codDeBarras
		return null;
	}

}
