package edu.bit.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) throws Exception {
		
		return "login/loginForm";
		
	}
	
	@PostMapping("/login")
	public String login(Model model) throws Exception {
		
		return "login/login";
		
	}
	
	@RequestMapping("/accessDenied")
	public String loginAccess(Model model) throws Exception {
		
		return "login/accessDenied";
		
	}

}
