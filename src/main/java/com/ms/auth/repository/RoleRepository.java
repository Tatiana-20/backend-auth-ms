package com.ms.auth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.ms.auth.models.ERole;
import com.ms.auth.models.Roles;

@Repository
public interface RoleRepository extends MongoRepository<Roles, String> {

    Optional<Roles> findByName(ERole name);

    @Override
    @NonNull
    List<Roles> findAll();
}
