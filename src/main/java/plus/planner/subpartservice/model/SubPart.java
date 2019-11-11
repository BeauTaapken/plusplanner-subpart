package plus.planner.subpartservice.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subpart")
@EntityListeners(AuditingEntityListener.class)
public class SubPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subpartid;
    @NotBlank
    private String subpartname;
    @NotBlank
    private String description;
    @NotBlank
    private String state;
    @NotBlank
    private String enddate;
    @NotNull
    private Long partid;

    public SubPart(){
    }

    public Long getSubpartid() {
        return subpartid;
    }

    public void setSubpartid(Long subpartid) {
        this.subpartid = subpartid;
    }

    public String getSubpartname() {
        return subpartname;
    }

    public void setSubpartname(String subpartname) {
        this.subpartname = subpartname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Long getPartid() {
        return partid;
    }

    public void setPartid(Long partid) {
        this.partid = partid;
    }
}
