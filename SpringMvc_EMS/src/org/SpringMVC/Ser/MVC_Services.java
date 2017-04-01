package org.SpringMVC.Ser;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.SpringMVC.Dao.Hib_Dao;

import org.SpringMVC.Dto.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class MVC_Services {
	@Autowired
	private Hib_Dao signupdao;

	public MVC_Services() {
		System.out.println(this.getClass().getSimpleName() + "created ...");
	}

	public boolean saveSignUp(SignUpDto dto) {
		System.out.println("inside the service");
		if (dto != null) {
			System.out.println("can be given to dao");
			signupdao.save(dto);
			return true;
		}
		System.out.println("cannot call DAO");
		return false;
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
		if (signupdao.reset(name) != null) {
			System.out.println("Reset is Success");
			return true;
		}
		System.out.println("Failed");
		return false;
	}

	public boolean saveImage(CommonsMultipartFile file) {
		
		String path = "C:/workspace/SpringMvc_EMS/WebContent/Image";
		System.out.println(path+" "+ file.getOriginalFilename());

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = null;
		try {
			stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + file.getOriginalFilename())));
			stream.write(bytes);
			stream.flush();
			
			System.out.println("File is successfully saved !!");
			return true;
		   } 
		catch (Exception e) {e.printStackTrace(); return false;}
		finally 
		{
			try   {if (stream != null) { stream.close();}} 
			catch (Exception e) {e.printStackTrace();}
		}
		
	}

	public boolean Retrive(String uEmail) 
	{
		
		return false;
	}

}