package btl.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btl.dao.LabsDAO;
import btl.entity.Labs;

@Repository
public class LabsDAOImpl implements LabsDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Labs> listLabAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<Labs> list = session.createQuery("from Labs").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}	finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Labs> listLab() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<Labs> list = session.createQuery("from Labs where Status = 1").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}	finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean addLab(Labs labs) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(labs);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateLab(Labs labs) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(labs);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteLab(String labId) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Labs findById(String labId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Labs labs = session.get(Labs.class, labId);
			return labs;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

}
