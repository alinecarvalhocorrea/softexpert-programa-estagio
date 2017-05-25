package biblioteca;

/**
 * 
 * @author aline.correa
 * 
 */
import java.util.Date;

public interface AutorAcessivel extends ItemBiblioteca {

	public void setNome(String nome);

	public String getNome();

	public void setNacionalidade(String nacionalidade);

	public String getNacionalidade();

	public void setDataDeNascimento(Date dataDeNascimento);

	public Date getDataDeNascimento();

}
