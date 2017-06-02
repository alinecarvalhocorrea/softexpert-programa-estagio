package com.biblioteca.objetos;

import java.util.UUID;

import com.biblioteca.objetos.interfaces.ItemBiblioteca;

/**
 * 
 * @author aline.correa
 *
 */

public class Categoria implements ItemBiblioteca, Comparable<Categoria> {
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

		public int compareTo(Categoria outraCategoria) {

			if (this.descricao != null) {
				int comparacao = this.descricao.compareTo(outraCategoria.getDescricao());

				if (comparacao != 0) {
					return comparacao;
				}
			}

			if (this.codigoSequencial != null) {
				int comparacaoCodigo = this.codigoSequencial.compareTo(outraCategoria.getCodigoSequencial());

				if (comparacaoCodigo != 0) {
					return comparacaoCodigo;
				}
			}

			return 0;
		}
	
	
}
