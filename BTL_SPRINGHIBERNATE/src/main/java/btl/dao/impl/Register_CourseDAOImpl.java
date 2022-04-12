package btl.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btl.dao.Register_CourseDAO;
import btl.entity.Register_Course;

@Repository
public class Register_CourseDAOImpl implements Register_CourseDAO{
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public List<Register_Course> list() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<Register_Course> list = session.createQuery("from Register_Course order by Status asc").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean add(Register_Course rc) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(rc);
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
	public boolean update(Register_Course rc) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(rc);
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
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(findById(id));
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
	public Register_Course findById(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Register_Course rc = session.get(Register_Course.class, id);
			return rc;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

}
