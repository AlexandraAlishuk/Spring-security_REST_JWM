package ru.spring.springboot.springsecurity_rest_jwm.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.spring.springboot.springsecurity_rest_jwm.entities.Role;
import ru.spring.springboot.springsecurity_rest_jwm.repositories.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService{
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}
