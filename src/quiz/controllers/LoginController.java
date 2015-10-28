package quiz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping("/redirectToLogin.do")
	public ModelAndView quizLogin() {
//		System.out.println("Inside LoginController");
		return new ModelAndView("login");
	}
	@RequestMapping("/SDQuizProject/postLoginRequest.do")
	public ModelAndView verifyLogin(@RequestParam("userName") String userName, @RequestParam("password") String password) {
//		System.out.println("Inside verifyLogin method");

		String userNameRef = "pparonson";
		String passwordRef = "letMeIn999";
		
		if (userName == null || password == null) {
			return new ModelAndView("invalidLogin");
		}//end: if
		
		if(password.length() < 8) {
			return new ModelAndView("invalidLogin");
		}//end: if
		if (userName.equals(userNameRef) && password.equals(passwordRef)) {
			return new ModelAndView("quizStartOptions");
//			return new ModelAndView("quizForm");
		} else {
			return new ModelAndView("invalidLogin");
		}//end: if
	}//end: m
}//end: c
