package kosa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kosa.model.Board;
import kosa.model.BoardDao;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDao dao;
	
	//board_insert => insert_form.jsp 출력
	@GetMapping("/board_insert")
	public String board_form() {
		return "insert_form";
	}
	
	// 중복으로 글을 쓰지 않기 위해 redirect 사용한다.
	// 다이렉트로 jsp 가면 안된다.
	@PostMapping("/board_insert")
	public String board_insert(Board board) {
		dao.insertBoard(board);
		return "redirect:board_list";
	}
	
	@GetMapping("/board_list")
	public String board_list(Model model) {
		List<Board> list = dao.listBoard();
		model.addAttribute("list", list); // 뷰에서 사용 가능하도록한다.
		return "list";
	}
	
}
