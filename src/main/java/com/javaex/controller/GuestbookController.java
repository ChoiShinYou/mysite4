package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;
//방명록리스트먼저짜기
//vo->controller->service->dao 순으로 정리하기

@Controller
@RequestMapping("/guest")
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;

	// 1.방명록리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("GuestbookController.list");
		List<GuestbookVo> guestlist = guestbookService.getGuestList();
		model.addAttribute("guestlist", guestlist);

		return "/guestbook/list";
	}
	// public String list(GuestbookVo guestbookVo)에서 guestbookVo에는addAttribute 메서드가
	// 없기때매 컴파일오류?
	// Model model 객체로만 사용해야하는 이유?

	// 방명록삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.delete");
		guestbookService.deleteGuest(guestbookVo);	//guestbookVo에 포함된 방명록정보가 db에서 삭제
		return "redirect:/guestbook/addList";	//삭제 후 방명록 목록으로 리다이렉트
	}
//	@RequestParam("password")String password

	// 방명록삭제폼
	@RequestMapping(value = "/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm() {
		System.out.println("GuestbookController.deleteForm");
		return "/guestbook/deleteForm";
	}

	// 방명록등록
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.add");
		guestbookService.addGuest(guestbookVo);
		return "redirect:/guestbook/add";
	}
	//guestbookVo 에는 등록할 방명록의 정보 포함
	//guestbookService.add(guestbookVo)를 호출하여
	//방명록 등록 -> guestbookVo에 포함된 방명록 정보가 db에 등록
}