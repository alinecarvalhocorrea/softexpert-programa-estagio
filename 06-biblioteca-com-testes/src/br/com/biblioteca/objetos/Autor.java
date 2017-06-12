package br.com.biblioteca.objetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.biblioteca.objetos.exceptions.DataInvalidaException;
import br.com.biblioteca.objetos.exceptions.FormatoDeDataInvalidoException;
import br.com.biblioteca.objetos.exceptions.NomeAutorNuloException;
import br.com.biblioteca.objetos.interfaces.ItemBiblioteca;

/**
 * 
 * @author aline.correa
 *
 */

public class Autor implements Comparable<Autor>, ItemBiblioteca {
	private CodigoSequencial codigo = new CodigoSequencial();
	private String codigoSequencial;
	private String nome;
	private String nacionalidade;
	private Calendar dataDeNascimento;
	private static final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

	// Construtores

	public Autor(String nome) throws NomeAutorNuloException {
		setCodigoSequencial(codigo.criarCodigoAutor());
		setNome(nome);
	}

	public Autor() {
		setCodigoSequencial(codigo.criarCodigoAutor());
	}

	// Métodos Private

	private void setCodigoSequencial(int contador) {
		this.codigoSequencial = String.valueOf(contador);
	}

	private void verificarDataDeNascimento(Calendar dataVerifica) throws DataInvalidaException {
		Calendar dataDeHoje = Calendar.getInstance();
		if (dataVerifica.getTime().after(dataDeHoje.getTime())) {
			throw new DataInvalidaException("*** ERRO: Data inserida posterior a data atual! ***");
		}
	}

	// Métodos Public

	public String getCodigoSequencial() {
		return this.codigoSequencial;
	}

	public void setNome(String nome) throws NomeAutorNuloException {
		try {
			if (nome.equals("")) {
				throw new NomeAutorNuloException(
						"*** ERRO: Nome de autor(a) nulo. Por favor, informe o nome do(a) autor(a). ***");
			}
			this.nome = nome;
		} catch (NullPointerException e) {
			throw new NomeAutorNuloException(
					"*** ERRO: Nome de autor(a) nulo. Por favor, informe o nome do(a) autor(a). ***");
		}
	}

	public String getNome() {
		return this.nome;
	}

	public void setNacionalidade(String nacionalidade) {
		try {
			if (nacionalidade.equals("")) {
				this.nacionalidade = "*** Nacionalidade não informada ***";
			} else {
				this.nacionalidade = nacionalidade;
			}
		} catch (NullPointerException e) {
			this.nacionalidade = "*** Nacionalidade não informada ***";
		}
	}

	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public void setDataDeNascimento(String dataDeNascimento)
			throws DataInvalidaException, FormatoDeDataInvalidoException {
		try {
			Date date = formatoData.parse(dataDeNascimento);
			Calendar dataVerifica = Calendar.getInstance();
			dataVerifica.setTime(date);
			verificarDataDeNascimento(dataVerifica);
			this.dataDeNascimento = Calendar.getInstance();
			this.dataDeNascimento.setTime(date);
		} catch (ParseException e) {
			throw new FormatoDeDataInvalidoException(
					"Data inserida invalida ou nula, por favor utilize o formato (dd/mm/yyyy)");
		} catch (NullPointerException e) {
			return;
		}
	}

	public String getDataDeNascimento() {
		try {
			String dataUserString = formatoData.format(this.dataDeNascimento.getTime());
			return dataUserString;
		} catch (NullPointerException e) {
			return "*** Data de nascimento não informada ***";
		}

	}

	// Métodos da Classe

	@Override
	public String toString() {
		return "Nome: " + nome + " | Código Sequencial: " + codigoSequencial;
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
			if (codigoSequencial != null)
				return false;
		} else if (!codigoSequencial.equals(codigoSequencial))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
