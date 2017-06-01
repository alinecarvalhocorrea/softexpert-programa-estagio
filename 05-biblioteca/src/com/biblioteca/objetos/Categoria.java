package com.biblioteca.objetos;

import java.util.UUID;

import com.biblioteca.objetos.interfaces.ItemBiblioteca;

/**
 * 
 * @author aline.correa
 *
 */

public class Categoria implements ItemBiblioteca {
	private String codigoSequencial;
	private String descricao;

	// Construtores
	public Categoria(String descricao) {
		setDescricao(descricao);
		setCodigoSequencial();

	}

	// Métodos da classe

	@Override
	public String toString() {
		return descricao;
	}

	// Getters e Setters
	public void setCodigoSequencial() {
		UUID idOne = UUID.randomUUID();
		this.codigoSequencial = idOne.toString().replaceAll("-", "");
	}

	public String getCodigoSequencial() {
		return this.codigoSequencial;
	}

	public void setDescricao(String descricao) {
		descricao = descricao.toUpperCase();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
