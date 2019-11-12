package br.com.labexame.service.exception;

import org.springframework.http.HttpStatus;

public class LaboratorioInativoException extends BusinessException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1028633832568886475L;

	public LaboratorioInativoException() {
		super("labexame-lab-ina", HttpStatus.BAD_REQUEST);
	}

	public LaboratorioInativoException(Long codigo) {
		super("labexame-lab-ina-exc", HttpStatus.BAD_REQUEST, codigo);
	}

}