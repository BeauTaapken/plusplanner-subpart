package plus.planner.subpartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import plus.planner.subpartservice.model.SubPartUser;

public interface SubPartUserRepository extends JpaRepository<SubPartUser, Long> {
}
