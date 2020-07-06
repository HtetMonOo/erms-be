package mm.edu.ytu.erms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity (name = "major")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Major extends MainModel {
    @Id
    private String code;
    private String name;
    @Column(name = "name_mm")
    private String nameMm;
    private String type;
    private Short status=1;
    private Short position;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "department_code", nullable = false)
//    @JsonIgnoreProperties("major")
//    private Department department;

    public Major(){}

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

    public String getNameMm() {
        return nameMm;
    }

    public void setNameMm(String nameMm) {
        this.nameMm = nameMm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    //    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }
}

