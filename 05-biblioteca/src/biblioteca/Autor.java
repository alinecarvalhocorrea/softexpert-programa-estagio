package biblioteca;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * 
 * @author aline.correa
 *
 *@Invocação
 * 1 - Autor(String nome, String nacionalidade,Date dataDeNascimento);<br>
 * 2 - Autor(String nome, String nacionalidade);<br>
 * 3 - Autor(String nome);<br>
 * 
 *@MétodosPublicos
 *+getCodigoSequencial();<br>
 *+setNome(String nome);<br>
 *+getNome();<br>
 *+setDataDeNascimento(Date dataDeNascimento);<br>
 *+getDataDeNascimento();<br>
 *+setNacionalidade(String nacionalidade);<br>
 *+getNacionalidade();<br>
 *
 *@Atributos
 *-codigoSequencial;<br>
 *-nome;<br>
 *-dataDeNascimento;<br>
 *-nacionalidade;<br>
 *
 *@MétodosPrivados
 *+setCodigoSequencial();<br>
 *
 */
public class Autor implements ItemDaBiblioteca {
	private long codigoSequencial; // Gerado automaticamente
	private String nome;
	private Date dataDeNascimento;
	private String nacionalidade;
	
	
	public Autor(String nome, String nacionalidade,Date dataDeNascimento){
		this.setNome(nome);
		this.setNacionalidade(nacionalidade);
		this.setDataDeNascimento(dataDeNascimento);
		this.setCodigoSequencial();
	}
	public Autor(String nome, String nacionalidade){
		this.setNome(nome);
		this.setNacionalidade(nacionalidade);
		this.setCodigoSequencial();
	}
	public Autor(String nome){
		this.setNome(nome);
		this.setCodigoSequencial();
	}
	
	public long getCodigoSequencial() {
		return codigoSequencial;
	}

	private void setCodigoSequencial() {
		this.codigoSequencial = this.hashCode();
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDeNascimento() {
		return this.dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public void listarAutores(Collection<Autor> colecao){
		Iterator<Autor> i = colecao.iterator();
		while (i.hasNext()) {
		// recebe o próximo objeto
		Autor palavra = i.next();
		System.out.println(palavra.getNome());
		}
	}
	public void buscar(Object object) {
		// 
		
	}
}
