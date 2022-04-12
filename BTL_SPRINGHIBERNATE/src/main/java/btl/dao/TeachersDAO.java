package btl.dao;

import java.util.List;

import btl.entity.Teachers;

public interface TeachersDAO {
	public List<Teachers> listAdmin();
	public List<Teachers> listCus();
	public boolean addTeacher(Teachers teachers);
	public boolean updateTeacher(Teachers teachers);
	public boolean deleteTeacher(Integer stt);
	public Teachers findByStt(Integer stt);
	public List<Teachers> findByName(String fullName);
}
