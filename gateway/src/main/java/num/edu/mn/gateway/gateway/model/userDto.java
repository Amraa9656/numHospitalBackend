package num.edu.mn.gateway.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class userDto
{
    private Long id;
    private String name;
    private String username;
    private String password;
    private Collection<Role> roles = new ArrayList<>();
}
