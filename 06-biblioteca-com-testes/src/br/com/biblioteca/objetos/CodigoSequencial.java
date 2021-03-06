package br.com.biblioteca.objetos;

public class CodigoSequencial {
	private static int codigoLivro = 0;
	private static int codigoAutor = 0;
	private static int codigoCategoria = 0;

	// M�todos Public

	public int criarCodigoLivro() {
		setCodigoLivro(getCodigoLivro() + 1);
		return getCodigoLivro();
	}

	public int criarCodigoAutor() {
		setCodigoAutor(getCodigoAutor() + 1);
		return getCodigoAutor();
	}

	public int criarCodigoCategoria() {
		setCodigoCategoria(getCodigoCategoria() + 1);
		return getCodigoCategoria();
	}

	public void zerar() {
		setCodigoAutor(0);
		setCodigoCategoria(0);
		setCodigoLivro(0);
	}

	// M�todos Private

	private int getCodigoCategoria() {
		return codigoCategoria;
	}

	private void setCodigoCategoria(int codigoCategoria) {
		CodigoSequencial.codigoCategoria = codigoCategoria;
	}

	private int getCodigoAutor() {
		return codigoAutor;
	}

	private void setCodigoAutor(int codigoAutor) {
		CodigoSequencial.codigoAutor = codigoAutor;
	}

	private int getCodigoLivro() {
		return CodigoSequencial.codigoLivro;
	}

	private void setCodigoLivro(int codigoLivro) {
		CodigoSequencial.codigoLivro = codigoLivro;
	}

}
