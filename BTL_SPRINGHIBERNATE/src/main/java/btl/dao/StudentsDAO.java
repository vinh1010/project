package btl.dao;

import java.util.List;

import btl.entity.Students;

public interface StudentsDAO {
	public List<Students> listStudents();
	public boolean addStudent(Students stu);
	public boolean updateStudent(Students stu);
	public boolean deleteStudent(String stuId);
	public Students findById(Integer stt);
	public List<Students> findByName(String stuName);
}
