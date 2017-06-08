package br.com.biblioteca.objetos;

import java.io.Serializable;

import br.com.biblioteca.objetos.interfaces.ItemBiblioteca;

/**
 * 
 *author aline.correa
 *
 */

public class Categoria implements ItemBiblioteca, Comparable<Categoria>,Serializable{
	private static final long serialVersionUID = 1L;
	private String codigoSequencial;
	private CodigoSequencial codigo = new CodigoSequencial();
	private String descricao;
	
	// Construtores 
	
	public Categoria(String descricao) throws DescricaoCategoriaNulaException{
		setDescricao(descricao);
		setCodigoSequencial(codigo.criarCodigoAutor());
	}
	
	public Categoria() {
		setCodigoSequencial(codigo.criarCodigoAutor());
	}
	
	// Métodos Private
	
	private void setCodigoSequencial(int contador) {
		String codigoString = String.valueOf(contador);
		this.codigoSequencial = codigoString;
	}
	
	// Métodos Public

	public String getCodigoSequencial() {
		return this.codigoSequencial;
	}

	public void setDescricao(String descricao) throws DescricaoCategoriaNulaException {
		try{
			if(descricao.equals("")){
				throw new DescricaoCategoriaNulaException("*** ERRO: Descrição de categoria nula. Por favor, informe a decrição da categoria. ***");
			}
			descricao = descricao.toUpperCase();
			this.descricao = descricao;
		}catch(NullPointerException e){
			throw new DescricaoCategoriaNulaException("*** ERRO: Descrição de categoria nula. Por favor, informe a decrição da categoria. ***");
		}
	}
	
	public String getDescricao() {
		return this.descricao;
	}

	// Métodos da Classe
	
		@Override
	public String toString() {
			return this.getDescricao();
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
