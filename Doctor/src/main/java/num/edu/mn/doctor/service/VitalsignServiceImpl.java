package num.edu.mn.doctor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import num.edu.mn.doctor.domain.Vitalsigns;
import num.edu.mn.doctor.repo.VitalsignsRepo;
import num.edu.mn.doctormodel.model.ResVitalsigns;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VitalsignServiceImpl implements VitalsignsService
{
    private final VitalsignsRepo vitalsignsRepo;
    @Override
    public ResponseEntity<ResVitalsigns> saveVitalsigns(Vitalsigns vitalsigns) {
        ResVitalsigns resVitalsigns = new ResVitalsigns();
        try {
            resVitalsigns.setCode(200);
            resVitalsigns.setStatus("Success");
            resVitalsigns.setMessage("Амжилтай");
            resVitalsigns.setVitalsignid(vitalsignsRepo.save(vitalsigns).getVitalsignid());
        }catch (Exception e)
        {
            resVitalsigns.setCode(300);
            resVitalsigns.setStatus("Fail");
            resVitalsigns.setMessage(e.getMessage());
        }

        return ResponseEntity.ok().body(resVitalsigns);
    }

    @Override
    public ResponseEntity<List<Vitalsigns>> getVitalsigns(long userid)
    {
        return ResponseEntity.ok().body(vitalsignsRepo.findByUserid(userid));
    }

    @Override
    public ResponseEntity<Vitalsigns> getOneVitalsigns(Long vitalsignid)
    {
        return ResponseEntity.ok().body(vitalsignsRepo.findByVitalsignid(vitalsignid));
    }
}
