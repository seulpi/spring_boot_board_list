package edu.bit.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.ex.service.BoardService;
import lombok.AllArgsConstructor;


@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

}
