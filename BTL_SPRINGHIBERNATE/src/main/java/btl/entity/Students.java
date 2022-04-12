package btl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Students")
public class Students {
	@Id
	@Column(name = "STT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stt;
	@Column(name = "StuId")
	@NotEmpty(message = "Id is not empty!")
	private String stuId;
	@Column(name = "FullName")
	@NotEmpty(message = "Name is not empty!")
	private String fullName;
	@Column(name = "Avartar")
	private String avartar;
	@Column(name = "Phone")
	@NotEmpty(message = "Phone is not empty!")
	@Pattern(regexp="(^$|[0-9]{10})", message = "Phone wrong format!")
	private String phone;
	@Column(name = "BirthDay")
	@NotNull(message = "BirthDay is not null!")
	private Date birthDay;
	@Column(name = "Gender")
	private boolean gender;
	@Column(name = "Address")
	@NotEmpty(message = "Address is not empty!")
	private String address;
	@Column(name = "Status")
	private boolean status;
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Students(Integer stt, String stuId, String fullName, String avartar, String phone, Date birthDay,
			boolean gender, String address, boolean status) {
		super();
		this.stt = stt;
		this.stuId = stuId;
		this.fullName = fullName;
		this.avartar = avartar;
		this.phone = phone;
		this.birthDay = birthDay;
		this.gender = gender;
		this.address = address;
		this.status = status;
	}

	public Integer getStt() {
		return stt;
	}

	public void setStt(Integer stt) {
		this.stt = stt;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
