package biblioteca;

/**
 * 
 * @author aline.correa
 */
import java.util.Date;
import java.util.UUID;

public class Autor implements ItemBiblioteca,Comparable<Autor>{
	private String codigoSequencial;
	private String nome;
	private String nacionalidade;
	private Date dataDeNascimento;

	// Construtores
	public Autor(String nome, String nacionalidade) {
		setNome(nome);
		setNacionalidade(nacionalidade);
		setCodigoSequencial();
	}
	
	public Autor(String nome) {
		setNome(nome);
		setCodigoSequencial();
	}

	// Métodos da classe
	@Override
	public String toString() {
		return "Nome: " + nome +", Nacionalidade: " + nacionalidade + ", Data de Nascimento: " + dataDeNascimento + ", Código Sequencial: "+ codigoSequencial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoSequencial == null) ? 0 : codigoSequencial.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (codigoSequencial == null) {
			if (other.codigoSequencial != null)
				return false;
		} else if (!codigoSequencial.equals(other.codigoSequencial))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
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
		// TODO Autor: TEM que implementar a inserção da dataDeNascimento
		this.dataDeNascimento = dataDeNascimento;
	}

	@Override
		public int compareTo(Autor outroAutor) {

			if (this.nome != null) {
				int comparacao = this.nome.compareTo(outroAutor.getNome());

				if (comparacao != 0) {
					return comparacao;
				}
			}

			if (this.codigoSequencial != null) {
				int comparacaoCodigo = this.codigoSequencial.compareTo(outroAutor.getCodigoSequencial());

				if (comparacaoCodigo != 0) {
					return comparacaoCodigo;
				}
			}

			return 0;
		}
	}
