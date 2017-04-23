package org.SpringMVC.Ser;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;

import org.SpringMVC.Dao.Hib_Dao;

import org.SpringMVC.Dto.SignUpDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class MVC_Services {
	
	@Autowired
	private Hib_Dao signupdao;
	
	// For logger
	private final Logger logger = Logger.getLogger(this.getClass());
	
	// For mail.....
	@Autowired
	private JavaMailSender mailSender;
	
	// For random_password
	private SecureRandom random = new SecureRandom();

	public String getRandomPassword() {
		return new BigInteger(40, random).toString(32);
	}

	public MVC_Services() {
		logger.info(this.getClass().getSimpleName() + "created ...");
	}

	public boolean saveSignUp(String fname, String lname, long mobile, int age, String email, String password) {
		logger.info("inside the service");
		SignUpDto dto = new SignUpDto();
		dto.setFname(fname);
		dto.setLname(lname);
		dto.setMobile(mobile);
		dto.setAge(age);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setActive(false);
		//For Activation Email
		sendMail("pauldebraj7@outlook.com", email, "Activation Email ",
				"http://localhost:8080/SpringMvc_EMS/active.do?email=" + email);
		signupdao.save(dto);
		logger.info("Activation is Successfully send");
		return true;

	}

	public boolean loginValidation(String name, String pwd) {
		logger.info("Vatidation inside the service");
		if (signupdao.validation(name, pwd) != null) {
			logger.info("Valid User");
			return true;
		}
		logger.warn("Invalid User");
		return false;
	}

	public boolean reset(String name) {
		String s = getRandomPassword();
		if (signupdao.reset(name, s)) {
			sendMail("pauldebraj7@outlook.com", name, "New Password ", "This is new password for Login--> " + s);
			logger.info("Reset is Success");
			return true;
		}
		logger.warn("Error while Reset !");
		return false;
	}

	public void activeIt(String email) {
		signupdao.activeNow(email);
	}

	public boolean saveImage(CommonsMultipartFile file) {

		String path = "C:/workspace/SpringMvc_EMS/WebContent/Image";
		logger.info(path + " " + file.getOriginalFilename());

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = null;
		try {
			stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + file.getOriginalFilename())));
			stream.write(bytes);
			stream.flush();
			logger.info("File is successfully saved !!");
			return true;
		} catch (Exception e) {
			logger.error("Error while Uploading ! "+e.getMessage() );
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (Exception e) {
				logger.error("Error while closing BufferedOutputStream object ! "+e.getMessage() );
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

	public SignUpDto retrive(String uEmail) {
		logger.info("Retrive in service class");
		 return signupdao.retriveDto(uEmail);
	}

	public boolean updateProfile(String fname, String lname, long mobile, int age, String uEmail, String password) {
		if(signupdao.updateData(fname,lname,mobile,age,uEmail,password)) return true;
		return false;
	}

}