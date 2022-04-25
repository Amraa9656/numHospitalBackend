package num.edu.mn.service;

import num.edu.mn.domain.User;
import num.edu.mn.usermodel.Usermodel.Model.ResGenaral;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService
{
    ResponseEntity<ResGenaral> saveUser (User user);
    ResponseEntity<ResGenaral> getuser (String requestry);
    ResponseEntity<ResGenaral> getusers();
}
