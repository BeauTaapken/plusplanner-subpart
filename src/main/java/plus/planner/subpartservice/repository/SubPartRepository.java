package plus.planner.subpartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plus.planner.subpartservice.model.SubPart;

@Repository
public interface SubPartRepository extends JpaRepository<SubPart, Long> {
}
