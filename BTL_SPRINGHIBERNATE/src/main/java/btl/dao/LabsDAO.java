package btl.dao;

import java.util.List;

import btl.entity.Labs;

public interface LabsDAO {
	public List<Labs> listLabAll();
	public List<Labs> listLab();
	public boolean addLab(Labs labs);
	public boolean updateLab(Labs labs);
	public boolean deleteLab(String labId);
	public Labs findById(String labId);
}
