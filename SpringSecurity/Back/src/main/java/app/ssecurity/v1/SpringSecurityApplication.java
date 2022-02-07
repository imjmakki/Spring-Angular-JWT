package app.ssecurity.v1;

import app.ssecurity.v1.Domain.Role;
import app.ssecurity.v1.Domain.User;
import app.ssecurity.v1.Service.UserService;
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
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null, "USER"));
            userService.saveRole(new Role(null, "MANAGER"));
            userService.saveRole(new Role(null, "ADMIN"));
            userService.saveRole(new Role(null, "SUPER_ADMIN"));

            userService.saveUser(new User(null, "Rita Reed", "Rita", "password", new HashSet<Role>()));
            userService.saveUser(new User(null, "Chris Banner", "Chris", "password", new HashSet<Role>()));
            userService.saveUser(new User(null, "Claudia Turner", "Claudia", "password", new HashSet<Role>()));
            userService.saveUser(new User(null, "Isla Clipper", "Isla", "password", new HashSet<Role>()));

            userService.addRoleToUser("Claudia", "USER");
            userService.addRoleToUser("Isla", "MANAGER");
            userService.addRoleToUser("Rita", "ADMIN");
            userService.addRoleToUser("Chris", "ADMIN");
            userService.addRoleToUser("Isla", "SUPER_ADMIN");
        };
    }

}
