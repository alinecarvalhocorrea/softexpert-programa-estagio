package biblioteca;

import java.util.Set;

public interface Autores extends AcoesEmMemoria<Autor> {

	Set<Autor> buscarPorNome(String nome);

	Set<Autor> buscarPorNacionalidade(String nacionalidade);

	Set<Autor> buscarPorDataDeNascimento(String dataDeNascimento);
	
	Autor buscarPorCodigoSequencial(String codigoSequencial);
}
