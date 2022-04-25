package num.edu.mn.doctor.controller;

import lombok.RequiredArgsConstructor;
import num.edu.mn.doctor.domain.Inspection;
import num.edu.mn.doctor.domain.Vitalsigns;
import num.edu.mn.doctor.service.InspectionService;
import num.edu.mn.doctor.service.VitalsignServiceImpl;
import num.edu.mn.doctormodel.DoctorFeignClient;
import num.edu.mn.doctormodel.model.ResVitalsigns;
import num.edu.mn.doctormodel.model.Response;
import num.edu.mn.usermodel.Usermodel.Model.ResGenaral;
import num.edu.mn.usermodel.Usermodel.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
//@RequiredArgsConstructor
public class DoctorController
{
    @Autowired
    private  InspectionService inspectionService;
    @Autowired
    private  VitalsignServiceImpl vitalsignService;

    @Autowired
    private DoctorFeignClient feignClient;


    @PostMapping("/inspection/saveInspection")
    public ResponseEntity<Response> saveInspection(@RequestBody Inspection inspection)
    {
        return inspectionService.saveInspection(inspection);
    }
    @PostMapping("/vitalsigns/saveVitalsigns")
    public ResponseEntity<ResVitalsigns> saveVitalsigns(@RequestBody Vitalsigns vitalsigns)
    {
        return vitalsignService.saveVitalsigns(vitalsigns);
    }

    @GetMapping("/user/Inspection/{userid}")
    public ResponseEntity<Response> getInspections(@PathVariable("userid") long userid)
    {
        return inspectionService.getInspection(userid);
    }
    @GetMapping("/test/{userid}")
    public ResponseEntity<Response> getTest(@PathVariable("userid") long userid)
    {
        return feignClient.getInspections(userid);
    }


}
