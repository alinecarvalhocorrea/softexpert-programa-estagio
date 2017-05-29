package biblioteca;

/**
 * 
 * @author aline.correa
 *
 */
import java.util.Date;
import java.util.Set;

public interface Autores extends AcoesEmMemoria<Autor> {

	Set<Autor> buscarPorNome(String nome);

	Set<Autor> buscarPorNacionalidade(String nacionalidade);

	Set<Autor> buscarPorDataDeNascimento(Date dataDeNascimento);
	
	Autor buscarPorCodigoSequencial(String codigoSequencial);
}
