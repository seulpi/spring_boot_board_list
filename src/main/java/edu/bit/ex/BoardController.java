package edu.bit.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.ex.pasing.Criteria;
import edu.bit.ex.pasing.PageVO;
import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;
import jdk.internal.org.jline.utils.Log;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private BoardService service;
	
	/*
	 * @GetMapping("/list") public String list(Model model) {
	 * 
	 * model.addAttribute("list", service.getList());
	 * 
	 * return "thymeleaf/timelist"; }
	 */
	@GetMapping("/list")
	public String jspList(Criteria cri, Model model) {
		
		/* model.addAttribute("list", service.getList()); */
		model.addAttribute("pasingList", service.getPageList(cri));
		
		int total = service.getTotal(cri);
		
		model.addAttribute("pageMake", new PageVO(total, cri));
		
		return "list";
	}
	
	@GetMapping("/write")
	public String write(Model model) {

		return "write";
	}
	
	@PostMapping("/write_add")
	public String write_add(BoardVO vo, Model model) {
		
		service.writeAdd(vo);

		return "redirect:list";
	}
	
	@GetMapping("/content_view")
	public String contents_view(BoardVO vo, Model model) {
		
		model.addAttribute("content", service.getContent(vo.getbId()));
		
		return "content_view";
	}
	
	@GetMapping("/delete")
	public String delete(BoardVO vo, Model model) {
		
		service.delete(vo.getbId());

		return "redirect:list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO vo, Model model) {
		
		service.modify(vo);

		return "redirect:list";
	}
	
	@GetMapping("/reply") //댓글 작성
	public String reply_view(BoardVO vo, Model model) {
		model.addAttribute("reply", service.getContent(vo.getbId()));
		return "reply";
	}
	
	@PostMapping("/replySort") 
	public String replySort(BoardVO vo, Model model) {
		
		service.replyAdd(vo);

		return "redirect:list";
	}
	

}
