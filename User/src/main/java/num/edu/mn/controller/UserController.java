package num.edu.mn.controller;

import lombok.RequiredArgsConstructor;
//import num.edu.mn.UserFeignClient;
import num.edu.mn.domain.User;
import num.edu.mn.service.UserService;
import num.edu.mn.usermodel.Usermodel.Model.ResGenaral;
//import num.edu.mn.usermodel.Usermodel.UserFeignClient;
import num.edu.mn.usermodel.Usermodel.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@RequiredArgsConstructor
public class UserController
{
    @Autowired
    private UserService userService;
    @Autowired
    private UserFeignClient feignClient;

    @GetMapping("/allUser")
    public ResponseEntity<ResGenaral> getUsers()
    {
        return userService.getusers();
    }

    @GetMapping("/user/{requestry}")
    public ResponseEntity<ResGenaral> getuser(@PathVariable("requestry") String requestry)
    {
        return userService.getuser(requestry);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<ResGenaral> saveUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }

    @GetMapping("/test")
    public ResponseEntity<ResGenaral> data()
    {
        return feignClient.getUsers();
    }

}
