package btl.dao;

import java.util.List;

import btl.entity.Register_Course;

public interface Register_CourseDAO {
	public List<Register_Course> list();
	public boolean add(Register_Course rc);
	public boolean update(Register_Course rc);
	public boolean delete(Integer id);
	public Register_Course findById(Integer id);
}
