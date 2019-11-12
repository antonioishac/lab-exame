package br.com.labexame.service.exception;

import org.springframework.http.HttpStatus;

public class LaboratorioNaoExisteException extends BusinessException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1028633832568886475L;

	public LaboratorioNaoExisteException() {
		super("labexame-lab-not", HttpStatus.BAD_REQUEST);
	}

}