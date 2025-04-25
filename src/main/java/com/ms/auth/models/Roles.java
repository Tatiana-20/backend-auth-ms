package com.ms.auth.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Roles {

    @Id
    private String id;

    private ERole name;

    public Roles() {
    }

    public Roles(String id, ERole name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Roles{"
                + "id='" + id + '\''
                + ", name=" + name
                + '}';
    }
}
