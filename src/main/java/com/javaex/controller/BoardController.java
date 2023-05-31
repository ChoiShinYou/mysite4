package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	
	@RequestMapping(value = "/board/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@RequestParam(value = "keyword", required= false, defaultValue = "")String keyword, 
			Model model)	{
		System.out.println("BoardController.list()");
		
		System.out.println(keyword);
		
//		List<BoardVo> boardList = boardService.getList();
//		model.addAttribute("boardList", boardList);// 이름이 똑같지않아도됨 boardList를 쓰고 싶으면"boardList"로 꺼내쓰면됨

		return "board/list";
	}

	@RequestMapping(value = "/board/list2", method = { RequestMethod.GET, RequestMethod.POST })
	public String list2(@RequestParam("keyword") String keyword , Model model) {
		System.out.println("BoardController.list2()");
		List<BoardVo> boardList = boardService.getList2(keyword);
		System.out.println(boardList);
		//keyword 파라미터 보내기 board/list2?keyword=오늘 -> 출력값:BoardController.list2() 오늘
		model.addAttribute("boardList", boardList);
		return "board/list";
	}
	
}