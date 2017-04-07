package org.SpringMVC.Dao;

import org.SpringMVC.Dto.SignUpDto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Hib_Dao {

	@Autowired
	private SessionFactory factory;

	public Hib_Dao() {
		System.out.println(this.getClass().getSimpleName() + "created ...");
	}

	public boolean save(SignUpDto dto) {

		Session session = factory.openSession();
		Transaction transation = null;
		try {
			transation = session.beginTransaction();
			session.save(dto);
			transation.commit();
			System.out.println("Records inserted sucessessfully");
		} catch (HibernateException e) {
			transation.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public SignUpDto validation(String name, String pwd) {

		Session session = factory.openSession();

		try {
			String hql = "select S from SignUpDto S where S.email ='" + name + "' and S.password ='" + pwd + "'and S.active = 1 ";
			return (SignUpDto) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
	}

	public boolean reset(String name,String s) {

		Session session = factory.openSession();
		Transaction transation = null;
		try {
			transation = session.beginTransaction();
			String hql = "update SignUpDto S set S.password= '" + s + "' where S.email='" + name + "'";
			session.createQuery(hql).executeUpdate();
			transation.commit();
			System.out.println("Records updated sucessessfully");
			return true;
			
		} catch (HibernateException e) {
			transation.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public void activeNow(String email_id) {
		
		Session session = factory.openSession();
		Transaction transation = null;
		try {
			transation = session.beginTransaction();
			String hql = "update SignUpDto S set S.active = 1 where S.email='" + email_id + "'";
			session.createQuery(hql).executeUpdate();
			transation.commit();
			System.out.println("Records updated sucessessfully");
			
		} catch (HibernateException e) {
			transation.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}