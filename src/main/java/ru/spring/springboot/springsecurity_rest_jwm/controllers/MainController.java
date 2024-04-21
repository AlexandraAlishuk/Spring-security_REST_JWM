package ru.spring.springboot.springsecurity_rest_jwm.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.spring.springboot.springsecurity_rest_jwm.entities.User;
import ru.spring.springboot.springsecurity_rest_jwm.service.RoleService;
import ru.spring.springboot.springsecurity_rest_jwm.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/unsecured")
    public String unsecuredData() {
        return "Unsecured Data";
    }

    @GetMapping("/secured")
    public String securedData() {
        return "Secured Data";
    }

    @GetMapping("/admin")
    public String adminData() {
        return "Admin Data";
    }

    @GetMapping("/info")
    public String userData(/*Principal principal,*/ SecurityContextHolder contextHolder) {
//        String userName = principal.getName();
//        UserDetails user = userService.loadUserByUsername(principal.getName());
//        Collection<? extends GrantedAuthority> userRole = user.getAuthorities();

        String userName = contextHolder.getContext().getAuthentication().getName();
        Collection<? extends GrantedAuthority> userRole = contextHolder.getContext().getAuthentication().getAuthorities();
        return "Пользователь: %s \nРоль: %s".formatted(userName, userRole);
    }

    @GetMapping("/allUserData")
    public List<User> allUserData() {
        Iterable<User> users = userService.getAllUsers();
        List<User> userList = new ArrayList<>((Collection) users);
        return userList;
    }
}
