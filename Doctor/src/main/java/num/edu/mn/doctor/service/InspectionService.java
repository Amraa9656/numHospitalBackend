package num.edu.mn.doctor.service;

import num.edu.mn.doctor.domain.Inspection;
import num.edu.mn.doctormodel.model.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InspectionService
{
    ResponseEntity<Response> saveInspection(Inspection inspection);
    ResponseEntity<Response> getInspection(long userid);
}
