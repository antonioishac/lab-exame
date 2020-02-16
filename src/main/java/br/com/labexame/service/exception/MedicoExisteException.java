package br.com.labexame.service.exception;

import org.springframework.http.HttpStatus;

public class MedicoExisteException extends BusinessException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1028633832568886475L;

	public MedicoExisteException() {
		super("labexame-med-existe", HttpStatus.BAD_REQUEST);
	}

}