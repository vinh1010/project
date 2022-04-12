package btl.dao;

import java.util.List;

import btl.entity.Courses;

public interface CoursesDAO {
	public List<Courses> listCourses();
	public List<Courses> listCus();
	public boolean addCourses(Courses courses);
	public boolean update(Courses courses);
	public boolean delete(String couId);
	public Courses findById(String couId);
	public List<Courses> findByName(String couName);
}
