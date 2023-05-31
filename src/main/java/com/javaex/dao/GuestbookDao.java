package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession; // DB
	// MyBatis 프레임워크에서 db와의 상호 작용하는 인터페이스
	// SQL문을 실행하고, db의 데이터를 조회, 추가, 수정, 삭제함
	// private 접근 제어자로 선언되었으므로, 해당 클래스 내부에서만 접근가능

	// 방명록리스트
	public List<GuestbookVo> selectGuestList() {

		System.out.println("GuestbookDao.selectGuestList");

		List<GuestbookVo> guestbookList = sqlSession.selectList("user.selectList");

		return guestbookList;

	}
	//static ?

	// 방명록삭제
	public void deleteGuest(GuestbookVo guestbookVo) {

		System.out.println("GuestbookDao.deleteGuest");

		int count = sqlSession.delete("user.delete", guestbookVo);

	}

	// 방명록등록
	public int insertGuest(GuestbookVo guestbookVo) {

		System.out.println("GuestbooDao.insertGuest");

		int count = sqlSession.insert("user.insert", guestbookVo);

		return count;

	}
}
