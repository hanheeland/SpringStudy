package kosa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
	
	//board_insert => insert_form.jsp 출력
	@GetMapping("/board_insert")
	public String board_form() {
		return "insert_form";
	}
	
	// 디스패처서블릿을 거쳐서 가야해서 redirect 사용한다.
	// 다이렉트로 jsp 가면 안된다.
	@PostMapping("/board_insert")
	public String board_insert() {
		System.out.println("호출");
		return "redirect:board_list";
	}
	
}
