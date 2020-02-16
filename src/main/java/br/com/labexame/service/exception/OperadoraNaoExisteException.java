package br.com.labexame.service.exception;

import org.springframework.http.HttpStatus;

public class OperadoraNaoExisteException extends BusinessException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1028633832568886475L;

	public OperadoraNaoExisteException() {
		super("labexame-operadora-nao-existe", HttpStatus.BAD_REQUEST);
	}

}