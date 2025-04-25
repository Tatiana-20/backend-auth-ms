package com.ms.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class TokenRefreshException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String token;

    /**
     * @param token The token that caused the exception.
     * @param message The exception message.
     */
    public TokenRefreshException(String token, String message) {
        super(String.format("Failed for [%s]: %s", token, message));
        this.token = token;
    }

    /**
     * Obtiene el token que causó la excepción.
     *
     * @return El token.
     */
    public String getToken() {
        return token;
    }
}
