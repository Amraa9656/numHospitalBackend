package num.edu.mn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long userid;
    private String firstname;
    private String lastname;
    private String requestry;
    private String allergies;
    private String address;
    private String education;
    private String profession;
    private String jobaddress;
}
