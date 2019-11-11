package br.com.labexame.service.exception;

import org.springframework.http.HttpStatus;

public class LaboratorioExisteException extends BusinessException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1028633832568886475L;

	public LaboratorioExisteException() {
		super("labexame-lab-exc", HttpStatus.BAD_REQUEST);
	}

}