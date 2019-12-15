package plus.planner.subpartservice.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subpart")
@EntityListeners(AuditingEntityListener.class)
public class SubPart {
    @Id
    private String subpartid;
    private Long partid;
    private String subpartname;
    private String description;
    private String state;
    private String enddate;
}
