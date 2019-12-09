package plus.planner.subpartservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subpartid;
    @Null
    @JsonIgnore
    private Long partid;
    @NotBlank
    private String subpartname;
    @NotBlank
    private String description;
    @NotBlank
    private String state;
    @NotBlank
    private String enddate;
}
