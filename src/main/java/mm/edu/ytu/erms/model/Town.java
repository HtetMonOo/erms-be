package mm.edu.ytu.erms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "town")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Town {
    @Id
    private String pcode;
    private String code;
    private String codeMm;
    private String name;
    private String nameMm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_or_region_id")
    private StateOrRegion stateOrRegion;

    public Town() {
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeMm() {
        return codeMm;
    }

    public void setCodeMm(String codeMm) {
        this.codeMm = codeMm;
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

    public Town(String pcode, String code, String codeMm, String name, String nameMm) {
        this.pcode = pcode;
        this.code = code;
        this.codeMm = codeMm;
        this.name = name;
        this.nameMm = nameMm;
    }

    public StateOrRegion getStateOrRegion() {
        return stateOrRegion;
    }

    public void setStateOrRegion(StateOrRegion stateOrRegion) {
        this.stateOrRegion = stateOrRegion;
    }
    
}