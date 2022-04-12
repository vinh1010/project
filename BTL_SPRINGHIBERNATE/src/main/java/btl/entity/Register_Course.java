package btl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Register_Course")
public class Register_Course {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "FullName")
	@NotEmpty(message = "Name is not empty!")
	private String fullName;
	@Column(name = "Email")
	@NotEmpty(message = "Email is not empty!")
	@Pattern(regexp="[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",message = "Wrong email format!")
	private String email;
	@Column(name = "Phone")
	@NotEmpty(message = "Phone is not empty!")
	@Pattern(regexp="(^$|[0-9]{10})", message = "Phone wrong format!")
	private String phone;
	@Column(name = "Status")
	private boolean status;
	@Column(name = "CoursesId")
	private String coursesId;
	
	public Register_Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Register_Course(Integer id, String fullName, String email, String phone, boolean status,
			String coursesId) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.coursesId = coursesId;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCoursesId() {
		return coursesId;
	}
	public void setCoursesId(String coursesId) {
		this.coursesId = coursesId;
	}
}
