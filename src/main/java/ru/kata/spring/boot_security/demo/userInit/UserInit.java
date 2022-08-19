package ru.kata.spring.boot_security.demo.userInit;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;

@Component
public class UserInit{

    private final UserService userService;

    public UserInit(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    private void userInit(){
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");

        Collection<Role> admins = new HashSet<>();
        Collection<Role> users = new HashSet<>();

        admins.add(adminRole);
        users.add(userRole);

        User admin = new User("Admin", "Admin", "admin@mail.ru", 54, "admin", admins);
        User user = new User("User", "User", "user@mail.ru", 54,"user", users);

        userService.saveUser(admin);
        userService.saveUser(user);
    }

}
