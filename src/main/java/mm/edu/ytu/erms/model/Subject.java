package mm.edu.ytu.erms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity (name = "subject")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Subject extends MainModel{
    @Id
    private String code;
    private String name;
    private Integer pass=50;
    private Integer distinction=70;
    private Integer excellent=85;
    private Integer maximum=100;
    private Short status=1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_code", nullable = false)
    private Department department;

    public Subject(){}

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

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public Integer getDistinction() {
        return distinction;
    }

    public void setDistinction(Integer distinction) {
        this.distinction = distinction;
    }

    public Integer getExcellent() {
        return excellent;
    }

    public void setExcellent(Integer excellent) {
        this.excellent = excellent;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

