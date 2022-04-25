package num.edu.mn.auth.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import num.edu.mn.auth.domain.Role;
import num.edu.mn.auth.domain.User;
import num.edu.mn.auth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource
{

    private final UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers() {
        return ResponseEntity.ok().body (userService.getusers());
    }

    @GetMapping("/aaa")
    public ResponseEntity<String> aaa() {
        System.out.println("[+] Hi");
        userService.saveRole(new Role( null, "ROLE_USER"));
        userService.saveRole(new Role( null, "ROLE_MANAGER"));
        userService.saveRole(new Role( null, "ROLE_ADMIN"));
        userService.saveRole (new Role(  null, "ROLE_SUPER_ADMIN"));


        userService.saveUser(new User(null, "John Travolta", "john",  "1234", new ArrayList<>()));
        userService.saveUser(new User(null, "Bat", "bat",  "1234", new ArrayList<>()));
        userService.saveUser(new User(null, "Amar", "amar",  "1234", new ArrayList<>()));
        userService.saveUser(new User(null, "green", "gre",  "1234", new ArrayList<>()));


        userService.addRoleToUser( "john", "ROLE_USER");
        userService.addRoleToUser (  "john", "ROLE_MANAGER");
        userService.addRoleToUser( "amar", "ROLE_MANAGER");
        userService.addRoleToUser (  "bat",  "ROLE ADMIN");
        userService.addRoleToUser( "gre", "ROLE_SUPER ADMIN");
        return ResponseEntity.ok("welcome");
    }
    @PostMapping("/validateToken")
    public ResponseEntity<User> signIn(@RequestParam String token) {
        System.out.println("[+] token :" + token);
        return ResponseEntity.ok(userService.validateToken(token));
    }


    @PostMapping("/user/save")
    public ResponseEntity<User>saveUser (@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<?>saveRole(@RequestBody Role role)
    {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created (uri).body (userService.saveRole(role));
    }
    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToForm form) {
        userService.addRoleToUser(form.getUsername(),form.getPassword());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader!=null && authorizationHeader.startsWith("Bearer "))
        {
            try{
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = userService.getuser(username);
                String access_token = JWT.create ()
                        .withSubject(user.getUsername ())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer (request.getRequestURL ().toString ())
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token" , access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),tokens);
            }catch (Exception e )
            {
                response.setHeader("Error", e.getMessage());
                response.setStatus(FORBIDDEN.value());
//                        response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message" , e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),error);
            }

        }
        else {
            new RuntimeException("Refresh token is missing");
        }
    }
}

@Data
class RoleToForm
{
    private String username;
    private String password;
}