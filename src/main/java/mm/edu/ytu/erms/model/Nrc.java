package mm.edu.ytu.erms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "nrc")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Nrc extends MainModel{
    @Id
    private String code;
    private String type;
    private int digit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "town_pcode")
    private Town town;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public Nrc() {
    }

    public Nrc(String code, String type, int digit) {
        this.code = code;
        this.type = type;
        this.digit = digit;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
    
    
}