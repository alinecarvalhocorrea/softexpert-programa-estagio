package biblioteca;

/**
 * 
 * @author aline.correa
 *
 */

public class Categoria implements ItemBiblioteca {
	private int codigoSequencial;
	private String descricao;

	//Construtores
	public Categoria(String descricao) {
		setDescricao(descricao);
	}
	
	//Métodos da classe
	
	@Override
	public String toString() {
		return "Categoria: " + descricao;
	}
	
	//Getters e Setters
	public void setCodigoSequencial() {
		//TODO Categoria: tem que implementar a criacao do codSequencial
		
		int codigoSequencial = 000;
		this.codigoSequencial = codigoSequencial;
	}

	public int getCodigoSequencial() {
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
