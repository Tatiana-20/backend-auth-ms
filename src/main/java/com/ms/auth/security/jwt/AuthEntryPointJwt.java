package com.ms.auth.security.jwt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    @Override
    public void commence(HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException)
            throws IOException, ServletException {

        logger.error("Unauthorized error: {}", authException.getMessage());

        String errorMessage = "Unauthorized";
        Throwable cause = authException.getCause();

        // Extraer causa si está disponible
        if (cause instanceof ExpiredJwtException) {
            errorMessage = "Token expirado";
        } else if (cause instanceof MalformedJwtException) {
            errorMessage = "Token mal formado";
        } else if (cause instanceof UnsupportedJwtException) {
            errorMessage = "Token no soportado";
        } else if (cause instanceof SecurityException) {
            errorMessage = "Firma inválida";
        } else if (cause instanceof IllegalArgumentException) {
            errorMessage = "Token vacío o nulo";
        } else if (cause != null) {
            errorMessage = cause.getMessage();
        }

        // Respuesta estructurada
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
        body.put("error", "Unauthorized");
        body.put("message", errorMessage);
        body.put("path", request.getServletPath());

        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), body);
    }
}
