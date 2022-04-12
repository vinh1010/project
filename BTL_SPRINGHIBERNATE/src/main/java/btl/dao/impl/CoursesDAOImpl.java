package btl.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btl.dao.CoursesDAO;
import btl.entity.Courses;

@Repository
public class CoursesDAOImpl implements CoursesDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Courses> listCourses() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<Courses> list = session.createQuery("from Courses").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean addCourses(Courses courses) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(courses);
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
	public boolean update(Courses courses) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(courses);
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
	public boolean delete(String couId) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Courses findById(String couId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Courses courses = session.get(Courses.class, couId);
			return courses;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Courses> findByName(String couName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			if (couName.length() == 0) {
				couName = "%";
				@SuppressWarnings("unchecked")
				List<Courses> list = session.createQuery("from Courses where CouName like :name")
				.setParameter("name", couName)
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

	@Override
	public List<Courses> listCus() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<Courses> list = session.createQuery("from Courses where Status = 1").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}
}
