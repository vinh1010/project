package btl.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btl.dao.TeachersDAO;
import btl.entity.Teachers;

@Repository
public class TeachersDAOImpl implements TeachersDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Teachers> listAdmin() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<Teachers> list = session.createQuery("from Teachers").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean addTeacher(Teachers teachers) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(teachers);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean updateTeacher(Teachers teachers) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(teachers);
			session.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteTeacher(Integer stt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Teachers findByStt(Integer stt) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Teachers teachers = session.get(Teachers.class, stt);
			return teachers;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Teachers> findByName(String fullName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			if(fullName.length() == 0) {
				fullName = "%";
			}
			@SuppressWarnings("unchecked")
			List<Teachers> list = session.createQuery("from Teachers where FullName like :fullName")
			.setParameter("fullName", fullName)
			.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Teachers> listCus() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<Teachers> list = session.createQuery("from Teachers where Status = 1").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}
	
}
