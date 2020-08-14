package mm.edu.ytu.erms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "enrollment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Enrollment extends MainModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "roll_no")
	private Integer rollNo;
	
	private Short status = 1;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classes_id", nullable = false)
	private Classes classes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_entrance_id", nullable = false)
	private Student student;
	
	public Enrollment() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}