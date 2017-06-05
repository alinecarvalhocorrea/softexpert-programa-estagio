package br.com.biblioteca.repositorios.interfaces;

import java.util.Set;

public interface AcoesNoRepositorio<T> {

	void adicionar(T registro);

	void excluir(T registro);
	
	void editar(T registro);

	Set<T> listar();

}
