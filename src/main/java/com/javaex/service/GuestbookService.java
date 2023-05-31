package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookDao guestbookDao;

	// 방명록 리스트
	public List<GuestbookVo> getGuestList() {

		System.out.println("GuestbookService.getGuestList()");

		List<GuestbookVo> guestbookList = guestbookDao.selectGuestList();

		return guestbookList;
	}

	// 방명록삭제
	public void deleteGuest(GuestbookVo guestbookVo) {

		System.out.println("GuestbookService.delete");

		guestbookDao.deleteGuest(guestbookVo);
	}

	// 방명록등록
	public void addGuest(GuestbookVo guestbookVo) {

		System.out.println("GuestbookService.add");

		guestbookDao.insertGuest(guestbookVo);

	}

}
