package br.com.labexame.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.http.HttpStatus;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

import java.util.Collections;
import java.util.List;

@JsonAutoDetect(fieldVisibility = ANY)
public class ErrorResponse {

    private final int statusCode;
    private final List<ApiError> errors;

    public ErrorResponse(int statusCode, List<ApiError> errors) {
		this.statusCode = statusCode;
		this.errors = errors;
	}

	public static ErrorResponse of(HttpStatus status, List<ApiError> errors) {
        return new ErrorResponse(status.value(), errors);
    }

    public static ErrorResponse of(HttpStatus status, ApiError error) {
        return of(status, Collections.singletonList(error));
    }

    public int getStatusCode() {
		return statusCode;
	}

	public List<ApiError> getErrors() {
		return errors;
	}

	@JsonAutoDetect(fieldVisibility = ANY)
    static class ApiError {
        private final String code;
        private final String message;

        public ApiError(String code, String message) {
			this.code = code;
			this.message = message;
		}

		public String getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}
    }
}