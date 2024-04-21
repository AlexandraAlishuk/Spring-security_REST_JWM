package ru.spring.springboot.springsecurity_rest_jwm.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.spring.springboot.springsecurity_rest_jwm.entities.Role;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
