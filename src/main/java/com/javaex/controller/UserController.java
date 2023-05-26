package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user") 
public class UserController {
	
	//회원가입폼
	
	
	
		
	//로그아웃
	@RequestMapping(value = "/user/logout" , method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		
		System.out.println("UserController.logout()");
		
		session.removeAttribute("authUser"); //특정 이름의 속성 제거
		session.invalidate(); //binding 되어 있는 모든 속성 제거
		
		return "redirect:/main";
	}
	
	
	
	

}
