package btl.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btl.dao.SubjectsDAO;
import btl.entity.Subjects;

@Repository
public class SubjectsDAOImpl implements SubjectsDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Subjects> listSubAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<Subjects> list = session.createQuery("from Subjects").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Subjects> list() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<Subjects> list = session.createQuery("from Subjects where Status = 1").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean addSub(Subjects subjects) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(subjects);
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
	public boolean updateSub(Subjects subjects) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(subjects);
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
	public boolean deleteSub(String subId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Subjects findById(String subId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Subjects subjects = session.get(Subjects.class, subId);
			return subjects;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Subjects> findByName(String subName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			if (subName.length() == 0) {
				subName = "%";
				@SuppressWarnings("unchecked")
				List<Subjects> list = session.createQuery("from Subjects where SubName like :name")
				.setParameter("name", subName)
				.list();
				return list;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

}
