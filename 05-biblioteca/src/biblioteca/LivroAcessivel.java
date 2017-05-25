package biblioteca;

/**
 * 
 * @author aline.correa
 *
 */
import java.util.Date;

public interface LivroAcessivel extends ItemBiblioteca {
	
	public void setTitulo(String titulo);

	public String getTitulo();

	public void setResumo(String resumo);

	public String getResumo();

	public void setCodigoDeBarras();

	public long getCodigoDeBarras();

	public void setQuantidadeDePaginas(int quantidadeDePaginas);

	public int getQuantidadeDePaginas();

	public void setLocal(String local);

	public String getLocal();

	public void setDataDeAquisicao(Date dataDeAquisicao);

	public Date getDataDeAquisicao();

	public void setAutor(Autor autor);

	public String getAutor();

	public void setCategoria(Categoria categoria);

	public String getCategoria();
}
