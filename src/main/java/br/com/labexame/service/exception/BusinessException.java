package br.com.labexame.service.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -8018814316437365030L;

	private final String code;
    private final HttpStatus status;

    public BusinessException(String code, HttpStatus status) {
    	super();
    	this.code = code;
    	this.status = status;
    }

    /**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}
}