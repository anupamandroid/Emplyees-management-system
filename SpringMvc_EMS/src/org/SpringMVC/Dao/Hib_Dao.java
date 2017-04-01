package org.SpringMVC.Dao;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.SpringMVC.Dto.SignUpDto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

@Repository
public class Hib_Dao {

	@Autowired
	private SessionFactory factory;

	//For mail.....
	@Autowired
	private JavaMailSender mailSender;

	//For random_password
	private SecureRandom random = new SecureRandom() ;

	public String getRandomPassword() {
		return new BigInteger(70, random).toString(32);
	}

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
			String hql = "select S from SignUpDto S where S.email ='" + name + "' and S.password ='" + pwd + "'";
			return (SignUpDto) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
	}

	public String reset(String name) {

		Session session = factory.openSession();
		Transaction transation = null;
		String s = null;
		try {
			transation = session.beginTransaction();
			s = getRandomPassword();
			String hql = "update SignUpDto S set S.password= '" + s + "' where S.email='" + name + "'";
			session.createQuery(hql).executeUpdate();
			transation.commit();
			System.out.println("Records updated sucessessfully");
			sendMail("pauldebraj7@outlook.com", name, "New Password ","This is new password for Login--> "+ s);
			
		} catch (HibernateException e) {
			transation.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return s;
	}

	public void sendMail(String from, String to, String subject, String msg) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		message.setReplyTo(to);
		// in order to send mail
		mailSender.send(message);
		
	}
	
	public boolean imageUrl(String url)
	{
		
		return true;
	}
}