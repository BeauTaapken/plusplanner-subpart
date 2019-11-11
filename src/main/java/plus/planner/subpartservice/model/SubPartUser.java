package plus.planner.subpartservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_subpart")
public class SubPartUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long usid;
    @NotBlank
    Long userid;
    @NotBlank
    Long subpartid;

    public Long getUsid() {
        return usid;
    }

    public void setUsid(Long usid) {
        this.usid = usid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getSubpartid() {
        return subpartid;
    }

    public void setSubpartid(Long subpartid) {
        this.subpartid = subpartid;
    }
}
