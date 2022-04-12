package btl.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Courses")
public class Courses {
	@Id
	@Column(name = "CouId")
	@NotEmpty(message = "Id is not empty!")
	private String couId;
	@Column(name = "CouName")
	@NotEmpty(message = "Name is not empty!")
	private String couName;
	@Column(name =  "StartDay")
	@NotNull(message = "Start Day is not null!")
	private Date startDay;
	@Column(name = "HoursStudy")
	@NotNull(message = "Hours Study is not null!")
	private Integer hoursStudy;
	@Column(name = "Images")
	private String images;
	@Column(name = "Description")
	private String description;
	@Column(name = "Price")
	@NotNull(message = "Price is not null!")
	private Double price;
	@Column(name = "Status")
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "LabId",referencedColumnName = "LabId")
	private Labs objLLap;
	
	@ManyToOne
	@JoinColumn(name = "TeaId",referencedColumnName = "STT")
	private Teachers objTeacher;
	
	@OneToMany(mappedBy = "objCourses")
	private Set<Subjects> listSubjects;

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(String couId, String couName, Date startDay, Integer hoursStudy, String images, String description,
			Double price, boolean status, Labs objLLap, Teachers objTeacher, Set<Subjects> listSubjects) {
		super();
		this.couId = couId;
		this.couName = couName;
		this.startDay = startDay;
		this.hoursStudy = hoursStudy;
		this.images = images;
		this.description = description;
		this.price = price;
		this.status = status;
		this.objLLap = objLLap;
		this.objTeacher = objTeacher;
		this.listSubjects = listSubjects;
	}

	public String getCouId() {
		return couId;
	}

	public void setCouId(String couId) {
		this.couId = couId;
	}

	public String getCouName() {
		return couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Integer getHoursStudy() {
		return hoursStudy;
	}

	public void setHoursStudy(Integer hoursStudy) {
		this.hoursStudy = hoursStudy;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Labs getObjLLap() {
		return objLLap;
	}

	public void setObjLLap(Labs objLLap) {
		this.objLLap = objLLap;
	}

	public Teachers getObjTeacher() {
		return objTeacher;
	}

	public void setObjTeacher(Teachers objTeacher) {
		this.objTeacher = objTeacher;
	}

	public Set<Subjects> getListSubjects() {
		return listSubjects;
	}

	public void setListSubjects(Set<Subjects> listSubjects) {
		this.listSubjects = listSubjects;
	}
}
