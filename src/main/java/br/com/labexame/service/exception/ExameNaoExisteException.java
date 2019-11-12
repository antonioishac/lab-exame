package br.com.labexame.service.exception;

import org.springframework.http.HttpStatus;

public class ExameNaoExisteException extends BusinessException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1028633832568886475L;

	public ExameNaoExisteException() {
		super("labexame-exe-not", HttpStatus.BAD_REQUEST);
	}

}