package mm.edu.ytu.erms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity(name = "department")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department extends MainModel {
    @Id
    @Column(name="code", updatable=false, nullable=false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    private String name_mm;

    @Column(name = "status")
    private Short status = 1;

    @Column(name = "position", unique = true, updatable = false)
    @Generated(GenerationTime.INSERT)
    private Short position;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_mm() {
        return name_mm;
    }

    public void setName_mm(String name_mm) {
        this.name_mm = name_mm;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getPosition() {
        return position;
    }

    public void setPosition(Short position) {
        this.position = position;
    }
}