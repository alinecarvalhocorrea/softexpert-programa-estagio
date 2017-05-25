package biblioteca;

/**
 * 
 * @author aline.correa
 *
 */

public class Categoria implements CategoriaAcessivel {
	private long codigoSequencial;
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
		long codigoSequencial = 000;
		this.codigoSequencial = codigoSequencial;
	}

	public long getCodigoSequencial() {
		return this.codigoSequencial;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
