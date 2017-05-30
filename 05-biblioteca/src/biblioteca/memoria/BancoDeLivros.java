package biblioteca.memoria;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author aline.correa
 *
 */
import java.util.Set;
import java.util.TreeSet;
import biblioteca.Livro;
import biblioteca.Livros;

public class BancoDeLivros implements Livros {

	private static Set<Livro> banco = new TreeSet<>();

	public void adicionar(Livro livro) {
		// TODO BancoLivros: pensar em mais validações para adição de livros
		/*if (livro.getTitulo() == null) {
			throw new NullPointerException("O livro está sem titulo, favor colocar");
		}
		if (livro.getAutor() == null) {
			throw new NullPointerException("O livro está sem autor, favor colocar");
		}
		if (livro.getCategoria() == null) {
			throw new NullPointerException("O livro está sem categoria, favor colocar");
		}*/
		banco.add(livro);

	}

	public void excluir(Livro livro) {
		banco.remove(livro);
	}

	public void editar(Livro livroParaEditar) {
		// TODO BancoLivros: PENSAR forma de enviar livro para edição
		excluir(livroParaEditar);
		adicionar(livroParaEditar);
	}

	public Set<Livro> listar() {
		return banco;
	}

	@Override
	public Set<Livro> buscarPorTitulo(String titulo) {
		// TODO BancoLivros: TEM que alterar estrutura de pesquisa por titulo de livro
		// TODO BancoLivros : pesquisar e implementar forma de pesquisa ignorando acentos
		Set<Livro> livrosEncontrados = new TreeSet<>();
		titulo = titulo.toUpperCase();
		String[] tituloArray = titulo.split(" ");
		
		for (int contador = 0; contador < tituloArray.length; contador++) {
			for (Livro livro : banco) {
				String livroTitulo = livro.getTitulo();
				String tituloArraySistema[] = livroTitulo.split(" ");
				int i = 0;
				while (i < tituloArraySistema.length) {
					if (tituloArraySistema[i].contains(tituloArray[contador])) {
						livrosEncontrados.add(livro);
					}
					i++;
				}
			}
		}
		if (!livrosEncontrados.isEmpty()) {
			return livrosEncontrados;
		}
		return null;
	}

	@Override
	public Livro buscarPorCodigoSequencial(String codigoSequencial) {
		for (Livro livro : banco) {
			String codigoLivro = livro.getCodigoSequencial();
			if (codigoLivro.equals(codigoSequencial)) {
				return livro;
			}
		}
		return null;
	}

	@Override
	public Livro buscarPorCodigoDeBarras(String codigoDeBarras) {
		for (Livro livro : banco) {
			String codigoLivro = livro.getCodigoDeBarras();
			if (codigoLivro.equals(codigoDeBarras)) {
				return livro;
			}
		}
		return null;
	}

	@Override
	public List<Livro> buscarPorCategoria(String descricaoCategoria) {
		// TODO BancoLivros : pesquisar e implementar forma de pesquisa ignorando acentos
		descricaoCategoria = descricaoCategoria.toUpperCase();
		List<Livro> livrosEncontrados = new ArrayList<>();
		for (Livro livro : banco) {
			String descricaoLivro = livro.getCategoria();
			descricaoLivro = descricaoLivro.toUpperCase();
			if (descricaoLivro.equals(descricaoCategoria)) {
				livrosEncontrados.add(livro);
			}
		}
		return livrosEncontrados;
	}
	
	@Override
	public List<Livro> buscarPorAutor(String nomeAutor) {
		// TODO BancoLivros : verificar pesquisa de livros por autor
		nomeAutor = nomeAutor.toUpperCase();
		List<Livro> livrosEncontrados = new ArrayList<>();
		for (Livro livro : banco) {
			String nomeAutorLivro = livro.getAutor();
			nomeAutorLivro = nomeAutorLivro.toUpperCase();
			if (nomeAutorLivro.contains(nomeAutor)) {
				livrosEncontrados.add(livro);
			}
		}
		return livrosEncontrados;
		
	}

}
