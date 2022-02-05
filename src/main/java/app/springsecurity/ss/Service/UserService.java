package app.springsecurity.ss.Service;

import app.springsecurity.ss.Domain.Role;
import app.springsecurity.ss.Domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
