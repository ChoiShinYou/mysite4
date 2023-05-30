package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

	// 방명록 리스트
	public List<GuestbookVo> getGuestList() {
		System.out.println("GuestbookService.getGuestList()");

		List<GuestbookVo> guestbooklist = GuestbookDao.selectGuestbookList();

		return guestbooklist();
	}

	// 방명록삭제
	public void delete(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.delete");
	}

	// 방명록등록
	public void add(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.add");
	}

}
