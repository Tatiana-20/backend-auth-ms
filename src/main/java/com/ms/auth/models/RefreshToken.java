package com.ms.auth.models;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "refresh_token")
public class RefreshToken {

    @Id
    private String id;

    @DBRef
    private User user;

    @NotBlank
    private String token;

    @NotNull
    private Instant expiryDate;

    // Removed duplicate no-argument constructor
    public RefreshToken(String token, User user, Instant expiryDate, String id) {
        this.id = id;
        this.token = token;
        this.user = user;
        this.expiryDate = expiryDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "RefreshToken{"
                + "id='" + id + '\''
                + ", userId=" + user.getId()
                + ", token='" + token + '\''
                + ", expiryDate=" + expiryDate
                + '}';
    }
}
