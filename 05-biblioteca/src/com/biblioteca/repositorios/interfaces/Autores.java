package com.biblioteca.repositorios.interfaces;

import java.util.Set;

import com.biblioteca.objetos.Autor;

public interface Autores extends AcoesNoRepositorio<Autor> {

	Set<Autor> buscarPorNome(String nome);

	Set<Autor> buscarPorNacionalidade(String nacionalidade);

	Set<Autor> buscarPorDataDeNascimento(String dataDeNascimento);
	
	Autor buscarPorCodigoSequencial(String codigoSequencial);
}
