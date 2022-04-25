package num.edu.mn.doctor.service;

import num.edu.mn.doctor.domain.Vitalsigns;
import num.edu.mn.doctormodel.model.ResVitalsigns;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VitalsignsService
{
    ResponseEntity<ResVitalsigns> saveVitalsigns(Vitalsigns vitalsigns);
    ResponseEntity<List<Vitalsigns>> getVitalsigns(long userid);
    ResponseEntity<Vitalsigns> getOneVitalsigns(Long vitalsignid);

}
