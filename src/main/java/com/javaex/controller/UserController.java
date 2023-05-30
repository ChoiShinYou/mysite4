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
	@RequestMapping(value = "/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute("userVo") UserVo userVo) {

		System.out.println("UserController.join");

		int count = userService.join(userVo);
		if (count > 0) {
			return "/user/joinOk";
		} else {
			return "redirect:/user/joinForm";
		}

	}

	// 로그인폼
	@RequestMapping(value = "/user/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {

		System.out.println("UserController.loginForm()");

		return "/user/loginForm";
	}

	// 로그인
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		// UserVo 객체는 사용자가 입력한 로그인 정보,
		// HttpSession 객체는 세션을 관리하기 위한 객체

		System.out.println("UserController.login");
		UserVo authUser = userService.login(userVo);
		System.out.println(authUser);

		if (authUser != null) { // 로그인 성공
			System.out.println("로그인 성공");
			// 세션에 저장
			session.setAttribute("authUser", authUser); // 세션 인증

			return "redirect:/main";

		} else {

			System.out.println("로그인 실패");

			return "redirect:/user/loginForm?result=fail";

		}
	}

	// 세션에 사용자 정보를 저장함으로써, 인증된 사용자에 대한 정보를 계속해서 유지할 수 있습니다.
	// 이를 통해 사용자의 로그인 상태 확인, 특정 기능 또는 페이지 제공
	// 다른 페이지에서 로그인 상태를 확인하기 위해서는 session.getAttribute("authUser")를 사용

	// 로그아웃
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {

		System.out.println("UserController.logout()");

		session.removeAttribute("authUser"); // 특정 이름의 속성 제거
		session.invalidate(); // binding 되어 있는 모든 속성 제거

		return "redirect:/main";
	}

	// 회원정보폼
	@RequestMapping(value = "/user/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(HttpSession sessoin, Model model) {
		// HttpSessoin 통해 세션 사용
		// Model 통해 뷰에 데이터 전달
		System.out.println("UserController.modifyForm");

		UserVo authUser = (UserVo) sessoin.getAttribute("authUser"); // 세션에서 authUser라는 이름으로 저장된 사용자정보 가져옴
		int no = authUser.getNo();

		UserVo userVo = userService.modifyForm(no);
		model.addAttribute(userVo);

		return "/user/modifyForm";
	}

	// 회원정보수정
	@RequestMapping(value = "/user/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(HttpSession session, @ModelAttribute UserVo userVo) {
		return null;
	}
}
