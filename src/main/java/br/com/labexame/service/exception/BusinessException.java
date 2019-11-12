package br.com.labexame.service.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -8018814316437365030L;

	private final String code;
    private final HttpStatus status;
    private final Long[] value;

    public BusinessException(String code, HttpStatus status, Long... value) {
    	super();
    	this.code = code;
    	this.status = status;
    	this.value = value;
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

	/**
	 * @return the value
	 */
	public Long[] getValue() {
		return value;
	}
}