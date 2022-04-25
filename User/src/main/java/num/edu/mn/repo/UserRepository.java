package num.edu.mn.repo;

import num.edu.mn.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    User findByRequestry(String requestry);
}
