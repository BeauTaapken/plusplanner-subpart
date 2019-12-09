package plus.planner.subpartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import plus.planner.subpartservice.model.SubPart;

import java.util.List;

@Repository
public interface SubPartRepository extends JpaRepository<SubPart, Long> {
    @Query("SELECT s FROM SubPart s WHERE s.partid = :partid")
    List<SubPart> findByPartId(@Param("partid") Long partid);
}
