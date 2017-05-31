package biblioteca;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Autor implements ItemBiblioteca,Comparable<Autor>{
	private String codigoSequencial;
	private String nome;
	private String nacionalidade;
	private Calendar dataDeNascimento;
	private static final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

	// Construtores
	public Autor(String nome) {
		setNome(nome);
		setCodigoSequencial();
	}

	// Métodos da classe
	@Override
	public String toString() {
		return "Nome: " + nome +", Nacionalidade: " + nacionalidade + ", Data de Nascimento: " + getDataDeNascimento() + ", Código Sequencial: "+ codigoSequencial;
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

	public String getDataDeNascimento() {
		String dataUserString = formatoData.format(this.dataDeNascimento.getTime());
		return dataUserString;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		try {
			Date date = formatoData.parse(dataDeNascimento);
			Calendar dataVerifica = Calendar.getInstance();
			dataVerifica.setTime(date);
			if (verificarDataDeNascimento(dataVerifica)) {
				this.dataDeNascimento = Calendar.getInstance();
				this.dataDeNascimento.setTime(date);
			} else {
				throw new IllegalArgumentException("Data inserida invalida : Data posterior a atual. Por favor, tente novamente.");
			}
		} catch (ParseException e) {
			throw new IllegalArgumentException("Data inserida invalida, por favor tente novamente e utilize o formato (dd/mm/yyyy)");
		}
	}
	
	private boolean verificarDataDeNascimento(Calendar dataVerifica) {
		Calendar dataDeHoje = Calendar.getInstance();
		if (dataVerifica.getTime().before(dataDeHoje.getTime())) {
			return true;
		}
		return false;
	}
	
	@Override
		public int compareTo(Autor outroAutor) {

			if (this.nome != null) {
				int comparacao = this.nome.compareTo(outroAutor.getNome());
				if (comparacao != 0) {
					return comparacao;
				}
			}
			
			if (this.dataDeNascimento != null) {
				int comparacao = this.getDataDeNascimento().compareTo(outroAutor.getDataDeNascimento());
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

	
