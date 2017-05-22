package biblioteca;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 
 * @author aline.correa
 * 
 * @Invoca��o
 * Categoria(String descricao);
 * 
 * @M�todosP�blicos
 * +getCodigoSequencial();<br>
 * +getDescricao();<br>
 * +setDescricao(String descricao);<br>
 * 
 * @Atributos
 * - codigoSequencial;<br>
 * - descricao;
 * 
 * @M�todosPrivados
 * +setCodigoSequencial();<br>
 * 
 *Criar Mapa entre (Categoria, Livro)
 */
public class Categoria {
	private long codigoSequencial;	//Gerado automaticamente
	private String descricao;
	
	public Categoria(String descricao){
		this.setDescricao(descricao);
		this.setCodigoSequencial();
	}
	
	public long getCodigoSequencial() {
		return this.codigoSequencial;
	}

	private void setCodigoSequencial() {
		this.codigoSequencial = this.hashCode();
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
