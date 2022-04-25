package num.edu.mn.doctor.repo;


import num.edu.mn.doctor.domain.Vitalsigns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VitalsignsRepo extends JpaRepository<Vitalsigns, Long>
{
    List<Vitalsigns> findByUserid(Long userid);
    Vitalsigns findByVitalsignid(Long vitalsignid);
}
