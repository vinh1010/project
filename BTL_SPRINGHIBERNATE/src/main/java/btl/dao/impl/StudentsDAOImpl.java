package btl.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btl.dao.StudentsDAO;
import btl.entity.Students;

@Repository
public class StudentsDAOImpl implements StudentsDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Students> listStudents() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<Students> list = session.createQuery("from Students").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean addStudent(Students stu) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(stu);
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
	public boolean updateStudent(Students stu) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(stu);
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
	public boolean deleteStudent(String stuId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.createQuery("update Students set Students.Status = 0 where Students.StuId = ?")
			.setParameter(0, stuId);
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
	public Students findById(Integer stt) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Students stu = session.get(Students.class, stt);
			return stu;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Students> findByName(String stuName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			if (stuName.length() == 0) {
				stuName = "%";
			}
			else {
				stuName = "%:name%";
			}
			@SuppressWarnings("unchecked")
			List<Students> list = session.createQuery("from Students where FullName like :name")
			.setParameter("name", stuName)
			.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return null;
	}
	
}
