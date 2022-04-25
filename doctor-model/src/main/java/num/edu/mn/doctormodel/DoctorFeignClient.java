package num.edu.mn.doctormodel;

import num.edu.mn.doctormodel.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doctor-service" , url = "http://localhost:8082/doctor-service/api")
public interface DoctorFeignClient
{
    @GetMapping("/user/Inspection/{userid}")
    public ResponseEntity<Response> getInspections(@PathVariable("userid") long userid);
}
