package num.edu.mn.doctor.domain;

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
public class Vitalsigns
{
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long vitalsignid;
    private Long userid;
    private String arterialbloodpressure;
    private int head;
    private String bloodoxysupply;
    private int numberofbreaths;
    private String createdate;
}
