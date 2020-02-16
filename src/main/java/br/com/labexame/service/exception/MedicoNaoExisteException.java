package br.com.labexame.service.exception;

import org.springframework.http.HttpStatus;

public class MedicoNaoExisteException extends BusinessException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1028633832568886475L;

	public MedicoNaoExisteException() {
		super("labexame-med-not", HttpStatus.BAD_REQUEST);
	}

}