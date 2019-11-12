package br.com.labexame.service.exception;

import org.springframework.http.HttpStatus;

public class ExameInativoException extends BusinessException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1028633832568886475L;

	public ExameInativoException() {
		super("labexame-exe-ina", HttpStatus.BAD_REQUEST);
	}


}