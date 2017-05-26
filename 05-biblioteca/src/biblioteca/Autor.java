package biblioteca;

/**
 * 
 * @author aline.correa
 */
import java.util.Date;
import java.util.UUID;

public class Autor implements ItemBiblioteca {
	private String codigoSequencial;
	private String nome;
	private String nacionalidade;
	private Date dataDeNascimento;

	// Construtores
	public Autor(String nome, String nacionalidade) {
		setNome(nome);
		setNacionalidade(nacionalidade);
	}

	// Métodos da classe
	@Override
	public String toString() {
		return "Autor [codigoSequencial=" + codigoSequencial + ", nome=" + nome + "]";
	}

	// Getters e Setters
	public String getCodigoSequencial() {
		return this.codigoSequencial;
	}

	public void setCodigoSequencial() {
		UUID idOne = UUID.randomUUID();
		this.codigoSequencial = idOne.toString().replaceAll("-", "");
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Date getDataDeNascimento() {
		return this.dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		// TODO Autor: tem que implementar a inserção da dataDeNascimento
		this.dataDeNascimento = dataDeNascimento;
	}

}
