package app.springsecurity.ss;

import app.springsecurity.ss.Domain.Role;
import app.springsecurity.ss.Domain.User;
import app.springsecurity.ss.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "USER"));
            userService.saveRole(new Role(null, "MANAGER"));
            userService.saveRole(new Role(null, "ADMIN"));
            userService.saveRole(new Role(null, "SUPER_ADMIN"));

            userService.saveUser(new User(null, "Roberta Bryant", "Roberta", "password", new HashSet<Role>()));
            userService.saveUser(new User(null, "Luis Bowen", "Luis", "password", new HashSet<Role>()));
            userService.saveUser(new User(null, "Claude Carty", "Claude", "password", new HashSet<Role>()));
            userService.saveUser(new User(null, "Nayan Mcclure", "Nayan", "password", new HashSet<Role>()));

            userService.addRoleToUser("Claude", "USER");
            userService.addRoleToUser("Nayan", "MANAGER");
            userService.addRoleToUser("Roberta", "ADMIN");
            userService.addRoleToUser("Luis", "ADMIN");
            userService.addRoleToUser("Nayan", "SUPER_ADMIN");
        };
    }
}
