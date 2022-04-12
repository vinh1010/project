package btl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Subjects")
public class Subjects {
	@Id
	@Column(name = "SubId")
	@NotEmpty(message = "Id is not empty!")
	private String subId;
	@Column(name = "SubName")
	@NotEmpty(message = "Name is not empty!")
	private String subName;
	@Column(name = "Status")
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "CoursesId",referencedColumnName = "CouId")
	private Courses objCourses;

	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subjects(String subId, String subName, boolean status, Courses objCourses) {
		super();
		this.subId = subId;
		this.subName = subName;
		this.status = status;
		this.objCourses = objCourses;
	}

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Courses getObjCourses() {
		return objCourses;
	}

	public void setObjCourses(Courses objCourses) {
		this.objCourses = objCourses;
	}
}
