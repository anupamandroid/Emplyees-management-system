package org.SpringMVC.Ser;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;

import org.SpringMVC.Dao.Hib_Dao;

import org.SpringMVC.Dto.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class MVC_Services {
	@Autowired
	private Hib_Dao signupdao;

	// For mail.....
	@Autowired
	private JavaMailSender mailSender;

	// For random_password
	private SecureRandom random = new SecureRandom();

	public String getRandomPassword() {
		return new BigInteger(70, random).toString(32);
	}

	public MVC_Services() {
		System.out.println(this.getClass().getSimpleName() + "created ...");
	}

	public boolean saveSignUp(String fname, String lname, long mobile, int age, String email, String password) {
		System.out.println("inside the service");
		SignUpDto dto = new SignUpDto();
		dto.setFname(fname);
		dto.setLname(fname);
		dto.setMobile(mobile);
		dto.setAge(age);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setActive(false);

		sendMail("pauldebraj7@outlook.com", email, "Activation Email ",
				"http://localhost:8080/SpringMvc_EMS/active.do?email=" + email);
		System.out.println("Activation is Success");
		signupdao.save(dto);
		return true;

	}

	public boolean loginValidation(String name, String pwd) {
		System.out.println("Vatidation inside the service");
		if (signupdao.validation(name, pwd) != null) {
			System.out.println("Valid User");
			return true;
		}
		System.out.println(" Invalid User");
		return false;
	}

	public boolean reset(String name) {
		System.out.println("Vatidation inside the service");
		String s = getRandomPassword();
		if (signupdao.reset(name, s)) {
			sendMail("pauldebraj7@outlook.com", name, "New Password ", "This is new password for Login--> " + s);
			System.out.println("Reset is Success");
			return true;
		}
		System.out.println("Failed");
		return false;
	}

	public void activeIt(String email) {
		signupdao.activeNow(email);
	}

	public boolean saveImage(CommonsMultipartFile file) {

		String path = "C:/workspace/SpringMvc_EMS/WebContent/Image";
		System.out.println(path + " " + file.getOriginalFilename());

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = null;
		try {
			stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + file.getOriginalFilename())));
			stream.write(bytes);
			stream.flush();

			System.out.println("File is successfully saved !!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

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

	public boolean Retrive(String uEmail) {

		return false;
	}

}