package app.ssecurity.v1.Service;

import app.ssecurity.v1.Domain.Role;
import app.ssecurity.v1.Domain.User;
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
