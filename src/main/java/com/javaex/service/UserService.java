package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service // 스프링 빈으로 등록
public class UserService {

	@Autowired
	private UserDao userDao;

	// UserService 클래스는 UserDao 객체를 주입받아 사용
	// UserDao는 데이터베이스 액세스를 위한 메서드를 제공하는 클래스

	// 로그인
	public UserVo login(UserVo userVo) {

		System.out.println("UserService.login()");

		UserVo authUser = userDao.selectUser(userVo);

		return authUser;
		// userDao.selectUser(userVo)를 호출하여 사용자 정보를 데이터베이스에서 조회
		// 조회된 사용자 정보를 authUser 변수에 저장한 후 반환
		//변수에는 인증된 사용자의 정보가 저장
	}

	// 회원등록
	public int join(UserVo userVo) {

		System.out.println("UserService.join()");

		int count = userDao.insertUser(userVo);

		return count;
		// userDao.insertUser(userVo)를 호출하여 사용자 정보를 데이터베이스에 등록
		// count 변수에는 삽입된 행의 수가 저장 후 반환
	}

	// 회원정보수정
	public int modify(UserVo userVo) {

		System.out.println("UserService.modify()");

		int count = userDao.updateUser(userVo);

		return count;
	}

	// 회원정보수정폼
	public UserVo modifyForm(int no) {

		System.out.println("UserService.modifyForm()");

		UserVo userVo = userDao.selectUser(no);

		return userVo;

		// no는 사용자의 고유한 식별자이며, 수정할 회원 정보를 찾기 위해 사용
	}

}

//selectone 은 하나만 검색
//selectlist 여러개 검색
//인서트는 새로운거를 입력
//업데이트는 있는거에서 수정

//컨트롤은 jsp연결
//서비스는 controller 와 Dao 연결해주는 서비스
//다오는 db 와 연결
