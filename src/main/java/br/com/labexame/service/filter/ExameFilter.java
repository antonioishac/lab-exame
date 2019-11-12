package br.com.labexame.service.filter;

import br.com.labexame.domain.Status;
import br.com.labexame.domain.TipoExame;

/**
 * @author aishac
 *
 * Classe que cont\u00e9m os atributos para realizar a busca de exames.
 *
 */
public class ExameFilter {

	private String nome;

	private Status status;

	private TipoExame tipo;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the tipo
	 */
	public TipoExame getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoExame tipo) {
		this.tipo = tipo;
	}
}
