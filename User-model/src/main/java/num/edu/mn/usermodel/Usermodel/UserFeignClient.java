package num.edu.mn.usermodel.Usermodel;

import num.edu.mn.usermodel.Usermodel.Model.ResGenaral;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service" , url = "http://localhost:8081/user-service/api")
public interface UserFeignClient
{
    @GetMapping("/allUser")
    ResponseEntity<ResGenaral> getUsers();
}
