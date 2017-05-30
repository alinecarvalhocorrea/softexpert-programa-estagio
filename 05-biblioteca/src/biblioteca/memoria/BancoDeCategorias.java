package biblioteca.memoria;

/**
 * 
 * @author aline.correa
 * 
 */
import java.util.HashSet;
import java.util.Set;
import biblioteca.Categoria;
import biblioteca.Categorias;

public class BancoDeCategorias implements Categorias {

	private static Set<Categoria> banco = new HashSet<>();

	@Override
	public void adicionar(Categoria categoria) {
		// TODO BancoCategorias: pensar em mais validações para adição de categorias
		if (categoria.getDescricao() == null) {
			throw new NullPointerException("A categoria está sem descrição, favor colocar");
		}
		banco.add(categoria);
	}
	
	@Override
	public void excluir(Categoria categoria) {
		banco.remove(categoria);

	}

	@Override
	public void editar(Categoria categoriaParaEditar) {
		excluir(categoriaParaEditar);
	}

	@Override
	public Set<Categoria> listar() {
		return banco;
	}

	@Override
	public Set<Categoria> buscarCategoriaPorDescricao(String descricao) {
		// TODO BancoCategorias : pesquisar e implementar forma de pesquisa ignorando acentos
		Set<Categoria> categoriasEncontradas = new HashSet<>();
		descricao = descricao.toUpperCase();
		for (Categoria categoria : banco) {
			String descricaoCategoria = categoria.getDescricao();
			if (descricaoCategoria.contains(descricao)) {
				categoriasEncontradas.add(categoria);
			}
		}
		return categoriasEncontradas;
	}

	@Override
	public Categoria buscarPorCodigoSequencial(String codigoSequencial) {
		for (Categoria categoria : banco) {
			String codigoCategoria = categoria.getCodigoSequencial();
			if (codigoCategoria.equals(codigoSequencial)) {
				return categoria;
			}
		}
		return null;
	}

}
