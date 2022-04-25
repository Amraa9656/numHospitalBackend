package num.edu.mn.auth.service;

import num.edu.mn.auth.domain.Role;
import num.edu.mn.auth.domain.User;

import java.util.List;

public interface UserService
{
    User saveUser (User user);
    Role saveRole(Role role);
    void addRoleToUser (String username, String roleName);
    User getuser (String username);
    List<User> getusers();

    User validateToken(String token);
}
