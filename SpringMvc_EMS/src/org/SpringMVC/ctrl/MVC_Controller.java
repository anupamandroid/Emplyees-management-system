package org.SpringMVC.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.SpringMVC.Dto.SignUpDto;
import org.SpringMVC.Ser.MVC_Services;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class MVC_Controller {
	@Autowired
	private MVC_Services service;

	private Logger logger = Logger.getLogger(this.getClass());

	public MVC_Controller() {
		System.out.println(this.getClass().getSimpleName() + "created ...");
	}

	//spring + java mail.
	//activated=false
	//url run app , get id
	
	// For Sign Up......
	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
	public String signup(SignUpDto dto, HttpServletRequest request) {
		request.setAttribute("dto", dto);
		if (service.saveSignUp(dto))
			return "/SuccessPage";
		return "redirect:/";
	}

	// For Logging.....
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String Login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
		if (!service.loginValidation(email, password)) {
			model.addAttribute("loginError", "Error logging in, Please try again");
			return "redirect:/";
		}
		logger.info("Hello");
		session.setAttribute("loginUser", email);
		return "/HomePage";
	}

	// For Logout....
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loginUser");
		System.out.println("You are successfully logged out!");
		return "/LoginPage";
	}

	// For Reset password
	@RequestMapping(value = "/reset.do", method = RequestMethod.POST)
	public String reset(@RequestParam String email) {
		if (service.reset(email))
			return "/SuccessPage";
		return "redirect:/";
	}

	// For Image upload
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public String upload(@RequestParam CommonsMultipartFile file) {
		if (service.saveImage(file))
			return "/SuccessPage";
		return "redirect:/";
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String update(HttpSession session) {
		String uEmail = (String) session.getAttribute("loginUser");
		if (service.Retrive(uEmail))
			return "/SuccessPage";
		return "redirect:/";
	}
	
	// *************************************************************************//
		// For call SignUpPage
		@RequestMapping(value = "/callsignup.do", method = RequestMethod.GET)
		public String callsignup() {
			return "/SignUpPage";
		}

		// For call resetPage
		@RequestMapping(value = "/callforget.do", method = RequestMethod.GET)
		public String callforgot() {
			return "/ResetPage";
		}

		// For call loginPage
		@RequestMapping(value = "/calllogin.do", method = RequestMethod.GET)
		public String calllogin() {
			return "/LoginPage";
		}

		// For call updatePage
		@RequestMapping(value = "/callupdate.do", method = RequestMethod.GET)
		public String callupdate() {
			return "/UpdatePage";
		}
		// ***************************************************************************//


}
