package org.SpringMVC.ctrl;

import javax.servlet.http.HttpSession;

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

	// For logger
	private final Logger logger = Logger.getLogger(this.getClass());

	public MVC_Controller() {
		logger.info(this.getClass().getSimpleName() + "created ...");
	}

	// For Sign Up......
	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
	public String signup(Model model, @RequestParam String fname, @RequestParam String lname, @RequestParam long mobile,
			@RequestParam int age, @RequestParam String email, @RequestParam String password) {
		model.addAttribute("Email", email);
		if (service.saveSignUp(fname, lname, mobile, age, email, password))
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
		session.setAttribute("loginUser", email);
		return "/HomePage";
	}

	// For Logout....
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loginUser");
		logger.info("You are successfully logged out!");
		return "/LoginPage";
	}

	// For Reset password
	@RequestMapping(value = "/reset.do", method = RequestMethod.POST)
	public String reset(@RequestParam String email) {
		if (service.reset(email))
			return "/SuccessPage";
		return "redirect:/";
	}

	// For calling the Activation
	@RequestMapping(value = "/active.do", method = RequestMethod.GET)
	public String activeIt(@RequestParam String email) {
		service.activeIt(email);
		return "/ActivationPage";
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
