package biblioteca;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 
 * @author aline.correa
 * 
 * @Invocação
 * 1 - Livro(String titulo, Autor autor, Categoria categoria,int quantidadeDePaginas);
 * 
 * @MétodosPúblicos
 * +getCodigoSequencial();<br>
 * +getCodigoDeBarras();<br>
 * +setTitulo(String titulo);<br>
 * +getTitulo();<br>
 * +setResumo(String resumo);<br>
 * +getResumo();<br>
 * +setQuantidadeDePaginas(int quantidadeDePaginas);<br>
 * +getQuantidadeDePaginas();<br>
 * +getAutor();<br>
 * +setCategoria(Categoria categoria);<br>
 * +getCategoria();<br>
 * 
 * @Atributos
 * -codigoSequencial;<br>
 * -titulo;<br>
 * -resumo;<br>
 * -codigoDeBarras;<br>
 * -quantidadeDePaginas;<br>
 * -local;<br>
 * -dataDeAquisicao;<br>
 * -categoria(Categoria);<br>
 * -autor(Autor);<br>
 * 
 * @MétodosPrivados
 * +setCodigoSequencial();<br>
 * +setCodigoDeBarras();<br>
 */
public class Livro implements ItemDaBiblioteca{
	private long codigoSequencial; // Gerado automaticamente
	private String titulo;
	private String resumo;
	private long codigoDeBarras; 	// Gerado auomaticamente
	private int quantidadeDePaginas;
	private String local; 			// na biblioteca. Ex.: Prateleira b3
	private Date dataDeAquisicao; 	// Usuario insere
	private Categoria categoria;
	private Autor autor;
	
	public Livro(String titulo,int quantidadeDePaginas){
		this.setTitulo(titulo);
		this.setQuantidadeDePaginas(quantidadeDePaginas);
		this.setCodigoSequencial();
	}
	
	public Livro(String titulo, Autor autor, Categoria categoria,int quantidadeDePaginas){
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setCategoria(categoria);
		this.setQuantidadeDePaginas(quantidadeDePaginas);
		this.setCodigoSequencial();
	}
	
	public long getCodigoSequencial() {
		return this.codigoSequencial;
	}

	private void setCodigoSequencial() {
		this.codigoSequencial = this.hashCode();
	}

	public long getCodigoDeBarras() {
		return this.codigoDeBarras;
	}

	private void setCodigoDeBarras() {
		this.codigoDeBarras = this.hashCode();
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public int getQuantidadeDePaginas() {
		return this.quantidadeDePaginas;
	}

	public void setQuantidadeDePaginas(int quantidadeDePaginas) {
		this.quantidadeDePaginas = quantidadeDePaginas;
	}

	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getDataDeAquisicao() {
		return this.dataDeAquisicao;
	}

	public void setDataDeAquisicao(Date dataDeAquisicao) {
		this.dataDeAquisicao = dataDeAquisicao;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public void buscar(Object object){
		
	}

}
