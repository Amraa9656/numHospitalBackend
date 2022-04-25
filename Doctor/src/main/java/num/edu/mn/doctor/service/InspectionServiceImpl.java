package num.edu.mn.doctor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import num.edu.mn.doctor.domain.Inspection;
import num.edu.mn.doctor.domain.Vitalsigns;
import num.edu.mn.doctor.repo.InspectionRepo;
import num.edu.mn.doctor.repo.VitalsignsRepo;
import num.edu.mn.doctormodel.model.Response;
import num.edu.mn.doctormodel.model.ResponseInspection;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class InspectionServiceImpl implements InspectionService
{

    private final InspectionRepo inspectionRepo;
    private final VitalsignServiceImpl vitalsignService;
    private final VitalsignsRepo vitalsignsRepo;

    @Override
    public ResponseEntity<Response> saveInspection(Inspection inspection) {
        Response resSend  = new Response();
        try {
            resSend.setCode(200);
            resSend.setStatus("Success");
            resSend.setMessage("Амжилтай");
            Inspection i = inspectionRepo.save(inspection);
            resSend.setData(i);
        }catch (Exception e)
        {
            resSend.setCode(300);
            resSend.setStatus("fail");
            resSend.setMessage(e.getMessage());
        }

//        inspectionRepo.save(inspection)
        return ResponseEntity.ok().body(resSend);
    }

    @Override
    public ResponseEntity<Response> getInspection(long userid) {
        Response response = new Response();
        List<ResponseInspection> responseInspections = new ArrayList<>();
        try {
            ResponseEntity<List<Vitalsigns>> resVitalsigns = vitalsignService.getVitalsigns(userid);
            if (resVitalsigns.getStatusCodeValue() == 200) {
                List<Inspection> inspections = inspectionRepo.findByUserid(userid);
                for (Inspection i : inspections) {
                    ResponseInspection res = new ResponseInspection();
                    Vitalsigns vitalsigns = vitalsignsRepo.findByVitalsignid(i.getVitalsignid());
                    res.setVitalsigns(vitalsigns);
                    res.setInspectionid(i.getInspectionid());
                    res.setUserid(i.getUserid());
                    res.setInspectiontype(i.getInspectiontype());
                    res.setDiagnosis(i.getDiagnosis());
                    res.setReason(i.getReason());
                    res.setIsdisease(i.getIsdisease());
                    res.setIsAm13(i.getIsAm13());
                    res.setTreatment(i.getTreatment());
                    res.setIsdisease(i.getIsdisease());
                    res.setIsparalyzed(i.getIsparalyzed());
                    responseInspections.add(res);
                }
                response.setCode(200);
                response.setStatus("Success");
                response.setMessage("Амжилтай");
                response.setData(responseInspections);
            } else {
                response.setCode(301);
                response.setStatus("Fail");
                response.setMessage("Амиан үзүүлэлт дээр алдаа гарлаа");
                return ResponseEntity.ok().body(response);
            }
        } catch (Exception e) {
            response.setCode(300);
            response.setStatus("Fail");
            response.setMessage(e.getMessage());
        }

        return ResponseEntity.ok().body(response);
    }
}
