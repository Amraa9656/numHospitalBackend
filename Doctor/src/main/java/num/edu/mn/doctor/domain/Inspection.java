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
public class Inspection
{
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long inspectionid;
    private Long userid;
    private Long vitalsignid;
    private String inspectiontype;
    private String diagnosis;
    private String reason;
    private String isdisease;
    private int isAm13;
    private String treatment;
    private String isparalyzed;
}
