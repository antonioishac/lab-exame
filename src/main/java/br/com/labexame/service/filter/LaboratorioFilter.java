package br.com.labexame.service.filter;

import br.com.labexame.domain.Status;

/**
 * @author aishac
 *
 * Classe que cont\u00e9m os atributos para realizar a busca de laborat\u00f3rios.
 *
 */
public class LaboratorioFilter {

	private String nome;

	private Status status;

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

}
