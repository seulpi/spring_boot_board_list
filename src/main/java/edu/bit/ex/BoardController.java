package edu.bit.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.ex.pasing.Criteria;
import edu.bit.ex.pasing.PageVO;
import edu.bit.ex.service.BoardService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Controller
public class BoardController {
	
	private BoardService service;
	
	
	@GetMapping("/list")
	public String list(Model model) {
		
		model.addAttribute("list", service.getList());
		
		return "thymeleaf/timelist";
	}
	
	@GetMapping("/board/list")
	public String jspList(Criteria cri, Model model) {
		
		/* model.addAttribute("list", service.getList()); */
		model.addAttribute("pasingList", service.getPageList(cri));
		
		int total = service.getTotal(cri);
		
		model.addAttribute("pageMake", new PageVO(total, cri));
		
		return "list";
	}
	
	

}
