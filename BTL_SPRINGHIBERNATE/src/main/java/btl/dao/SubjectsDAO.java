package btl.dao;

import java.util.List;

import btl.entity.Subjects;

public interface SubjectsDAO {
	public List<Subjects> listSubAll();
	public List<Subjects> list();
	public boolean addSub(Subjects subjects);
	public boolean updateSub(Subjects subjects);
	public boolean deleteSub(String subId);
	public Subjects findById(String subId);
	public List<Subjects> findByName(String subName);
}
