package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	// 회원가입폼
	@RequestMapping(value = "/user/joinForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {
		System.out.println("UserController.joinForm");

		return "/user/joinForm";
	}

	// 회원가입
	@RequestMapping(value = "/join" , method = { RequestMethod.GET , RequestMethod.POST })
	public String join(@ModelAttribute("userVo")UserVo userVo) {
		System.out.println("UserController.join");
		
		int count = userService.join(userVo);
		if(count > 0) {
			return "/user/joinOk";
		}else {
			return "redirect:/user/joinForm";
		}

	// 로그아웃
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {

		System.out.println("UserController.logout()");

		session.removeAttribute("authUser"); // 특정 이름의 속성 제거
		session.invalidate(); // binding 되어 있는 모든 속성 제거
	
		return "redirect:/main";
	}

}
