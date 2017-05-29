package biblioteca;

import java.util.Set;

public interface AcoesEmMemoria<T> {

	void adicionar(T registro);

	void excluir(T registro);
	
	void editar(T registro);

	Set<T> listar();

}
