package num.edu.mn.doctor.repo;

import num.edu.mn.doctor.domain.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InspectionRepo extends JpaRepository<Inspection, Long>
{
    List<Inspection> findByUserid(Long userid);
}
