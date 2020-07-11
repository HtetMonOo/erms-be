package mm.edu.ytu.erms.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StateOrRegion {
    @Id
    private Integer id;
    private String name;
    public enum Suffix{
        State,
        Region;
    }
    @Enumerated(EnumType.STRING)
    private Suffix suffix;
    private String code;
    private String idMm;
    private String nameMm;
    private String suffixMm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Suffix getSuffix() {
        return suffix;
    }

    public void setSuffix(Suffix suffix) {
        this.suffix = suffix;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIdMm() {
        return idMm;
    }

    public void setIdMm(String idMm) {
        this.idMm = idMm;
    }

    public String getNameMm() {
        return nameMm;
    }

    public void setNameMm(String nameMm) {
        this.nameMm = nameMm;
    }

    public String getSuffixMm() {
        return suffixMm;
    }

    public void setSuffixMm(String suffixMm) {
        this.suffixMm = suffixMm;
    }

    public StateOrRegion(Integer id, String name, Suffix suffix, String code, String idMm, String nameMm,
            String suffixMm) {
        this.id = id;
        this.name = name;
        this.suffix = suffix;
        this.code = code;
        this.idMm = idMm;
        this.nameMm = nameMm;
        this.suffixMm = suffixMm;
    }

    public StateOrRegion() {
    }
    
}