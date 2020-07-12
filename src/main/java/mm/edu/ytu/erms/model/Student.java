package mm.edu.ytu.erms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "student")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Student extends MainModel {
	public enum Gender{M, F};
	
	@Id
	private String entrance_id;
	private String name;
	private String name_mm;
	
	private String religion;
	private String ethnic;
	
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private Date dob;
	private String mat_seat_no;
	private Integer mat_year;
	private String mat_dept;
	private String phone;
	private String email;

	public Student() {
		
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "major_code", nullable = false)
	private Major major;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nrc_code", nullable = false)
	private Nrc nrc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "birth_place", nullable = false)
	private Address birth_place;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "current_address", nullable = false)
	private Address current_address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "permanent_address", nullable = false)
	private Address permanent_address;
	
	public String getEntrance_id() {
		return entrance_id;
	}
	public void setEntrance_id(String entrance_id) {
		this.entrance_id = entrance_id;
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
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getEthnic() {
		return ethnic;
	}
	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMat_seat_no() {
		return mat_seat_no;
	}
	public void setMat_seat_no(String mat_seat_no) {
		this.mat_seat_no = mat_seat_no;
	}
	public Integer getMat_year() {
		return mat_year;
	}
	public void setMat_year(Integer mat_year) {
		this.mat_year = mat_year;
	}
	public String getMat_dept() {
		return mat_dept;
	}
	public void setMat_dept(String mat_dept) {
		this.mat_dept = mat_dept;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Nrc getNrc() {
		return nrc;
	}
	public void setNrc(Nrc nrc) {
		this.nrc = nrc;
	}
	public Address getBirth_place() {
		return birth_place;
	}
	public void setBirth_place(Address birth_place) {
		this.birth_place = birth_place;
	}
	public Address getCurrent_address() {
		return current_address;
	}
	public void setCurrent_address(Address current_address) {
		this.current_address = current_address;
	}
	public Address getPermanent_address() {
		return permanent_address;
	}
	public void setPermanent_address(Address permanent_address) {
		this.permanent_address = permanent_address;
	}





	
	
	
}
