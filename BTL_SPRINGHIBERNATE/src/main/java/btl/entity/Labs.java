package btl.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Labs")
public class Labs {
	@Id
	@Column(name = "LabId")
	private String labId;
	@Column(name = "LabName")
	private String labName;
	@Column(name = "Status")
	private boolean status;
	
	@OneToMany(mappedBy = "objLLap")
	private Set<Courses> listCourses;

	public Labs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Labs(String labId, String labName, boolean status, Set<Courses> listCourses) {
		super();
		this.labId = labId;
		this.labName = labName;
		this.status = status;
		this.listCourses = listCourses;
	}

	public String getLabId() {
		return labId;
	}

	public void setLabId(String labId) {
		this.labId = labId;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<Courses> getListCourses() {
		return listCourses;
	}

	public void setListCourses(Set<Courses> listCourses) {
		this.listCourses = listCourses;
	}
}
