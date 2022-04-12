package btl.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Teachers")	
public class Teachers {
	@Id
	@Column(name = "STT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stt;
	@Column(name = "TeaId")
	@NotEmpty(message = "Id is not empty!")
	private String teaId;
	@Column(name = "FullName")
	@NotEmpty(message = "Name is not empty!")
	private String fullName;
	@Column(name = "Avartar")
	private String avartar;
	@Column(name = "BirthDay")
	@NotNull(message = "BirthDay is not null!")
	private Date birthDay;
	@Column(name = "Gender")
	private boolean gender;
	@Column(name = "Slogan")
	@NotEmpty(message = "Slogan is not empty!")
	private String slogan;
	@Column(name = "Degree")
	@NotEmpty(message = "Degree is not empty!")
	private String degree;
	@Column(name = "Status")
	private boolean status;
	
	@OneToMany(mappedBy = "objTeacher")
	private Set<Courses> listCourse;

	public Teachers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teachers(Integer stt, String teaId, String fullName, String avartar, Date birthDay, boolean gender,
			String slogan, String degree, boolean status, Set<Courses> listCourse) {
		super();
		this.stt = stt;
		this.teaId = teaId;
		this.fullName = fullName;
		this.avartar = avartar;
		this.birthDay = birthDay;
		this.gender = gender;
		this.slogan = slogan;
		this.degree = degree;
		this.status = status;
		this.listCourse = listCourse;
	}

	public Integer getStt() {
		return stt;
	}

	public void setStt(Integer stt) {
		this.stt = stt;
	}

	public String getTeaId() {
		return teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAvartar() {
		return avartar;
	}

	public void setAvartar(String avartar) {
		this.avartar = avartar;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<Courses> getListCourse() {
		return listCourse;
	}

	public void setListCourse(Set<Courses> listCourse) {
		this.listCourse = listCourse;
	}
}
