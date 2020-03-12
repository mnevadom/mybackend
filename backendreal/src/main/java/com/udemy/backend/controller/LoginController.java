package com.udemy.backend.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.backend.constant.ViewConstant;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	/**
	 * Login check.
	 *
	 * @return the string
	 */
	// este es agregando spring security (quito los dos metodos de abajo que ya no necesito (redirectToLogin, loginCheck y login)
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck() {
		LOG.info("METHOD: logincheck()");
		LOG.info("Returning to contacts view");
		
		return "redirect:/contacts/showcontacts";
	}
	
	/**
	 * Show login form.
	 *
	 * @param mav the mav
	 * @param error the error
	 * @param logout the logout
	 * @return the string
	 */
	@GetMapping("/login")
	// tiene que obtener un modelandview. porque desde la vista login, reenvio a login
	// y no se le está pasando el objeto de tipo userCredential que en teoría está gestionando la vista
	public String showLoginForm(
			Model mav,
			@RequestParam(name="error", required = false) String error,
			@RequestParam(name="logout", required = false) String logout
			) {
		
		LOG.info("ERROR is  " + error);
		LOG.info("LOGOUT is  " + logout);
		
		mav.addAttribute("error", error);
		mav.addAttribute("logout", logout);
		
		return ViewConstant.LOGIN;
	}
	
	
//	@GetMapping("/login")
//	// tiene que obtener un modelandview. porque desde la vista login, reenvio a login
//	// y no se le está pasando el objeto de tipo userCredential que en teoría está gestionando la vista
//	public String showLoginForm(
//			Model mav,
//			@RequestParam(name="error", required = false) String error,
//			@RequestParam(name="logout", required = false) String logout
//			) {
//		
//		LOG.info("ERROR is  " + error);
//		LOG.info("LOGOUT is  " + logout);
//		
//		mav.addAttribute("error", error);
//		mav.addAttribute("logout", logout);
//		mav.addAttribute("userCredential", new UserCredential());
//		
//		return ViewConstant.LOGIN;
//	}
	
	
//	@GetMapping("/")
//	public String redirectToLogin() {
//		LOG.info("METHOD: redirect:/redirectToLogin()");
//		return "redirect:/login";
//	}
	
//	@PostMapping("/logincheck")
//	public String loginCheck(
//			@ModelAttribute("userCredential") UserCredential userCredential
//			) {
//		
//		LOG.info("METHOD: logincheck --PARAMS " + userCredential.toString());
//		
//		if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("password")){
//			LOG.info("Returning to contacts view");
//			return "redirect:/contacts/showcontacts";
//		}
//		
//		LOG.info("Returning to redirect:/login?error");
//		return "redirect:/login?error";
//	}

}
