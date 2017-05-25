package biblioteca;

/**
 * 
 * @author aline.correa
 *
 */
import java.util.Date;

public class Livro implements LivroAcessivel, Comparable<Livro> {
	private long codigoSequencial;
	private String titulo;
	private String resumo;
	private long codigoDeBarras;
	private int quantidadeDePaginas;
	private String local;
	private Date dataDeAquisicao;
	private Autor autor;
	private Categoria categoria;

	// Construtores

	// Métodos da classe

	@Override
	public int compareTo(Livro o) {

		if (this.titulo != null) {
			int comparacao = this.titulo.compareTo(o.getTitulo());

			if (comparacao != 0) {
				return comparacao;
			}
		}

		if (this.resumo != null) {
			int comparacaoResumo = this.resumo.compareTo(o.getResumo());

			if (comparacaoResumo != 0) {
				return comparacaoResumo;
			}
		}

		return 0;
	}

	@Override
	public String toString() {
		return "Livro: " + codigoSequencial + " - '" + titulo + "', Local: " + local + ", Autor: " + autor.getNome()
				+ ", " + categoria + ", Data de aquisição: " + dataDeAquisicao + ",[ Código de barras: "
				+ codigoDeBarras + "].";
	}

	// titulo e codSequencial
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigoSequencial ^ (codigoSequencial >>> 32));
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (codigoSequencial != other.codigoSequencial)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	// Getters e Setters
	public void setCodigoSequencial() {
		// TODO tem que implementar a criacao do codSequencial
		long codigoSequencial = 000;
		this.codigoSequencial = codigoSequencial;
	}

	public long getCodigoSequencial() {
		return this.codigoSequencial;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public void setCodigoDeBarras() {
		// TODO tem que implementar a criacao do codDeBarras
		long codigoDeBarras = 000;
		this.codigoDeBarras = codigoDeBarras;
	}

	public long getCodigoDeBarras() {
		return this.codigoDeBarras;
	}

	public void setQuantidadeDePaginas(int quantidadeDePaginas) {
		this.quantidadeDePaginas = quantidadeDePaginas;
	}

	public int getQuantidadeDePaginas() {
		return this.quantidadeDePaginas;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getLocal() {
		return this.local;
	}

	public void setDataDeAquisicao(Date dataDeAquisicao) {
		// TODO tem que implementar a inserção da data de aquisicao
		this.dataDeAquisicao = dataDeAquisicao;
	}

	public Date getDataDeAquisicao() {
		return this.dataDeAquisicao;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getAutor() {
		Autor autorDesseLivro = this.autor;
		String nomeDoAutorDesseLivro = autorDesseLivro.getNome();
		return nomeDoAutorDesseLivro;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getCategoria() {
		Categoria categoriaDesseLivro = this.categoria;
		String descricaoCategoriaDesseLivro = categoriaDesseLivro.getDescricao();
		return descricaoCategoriaDesseLivro;
	}

}
