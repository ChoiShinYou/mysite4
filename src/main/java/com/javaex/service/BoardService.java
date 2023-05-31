package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	public List<BoardVo> getList() {
		System.out.println("BoardService.getList");

		// Dao selectList() 호출
		List<BoardVo> boardList = boardDao.selectList();

		//System.out.println(boardList);
		// boardDao.selectList();
		return boardList;
	}

	public List<BoardVo> getList2(String keyword) {
		List<BoardVo> boardList = boardDao.selectList();

		System.out.println("BoardService.getList2");
		
		boardDao.selectList2(keyword);
		
		return boardList;
	
	}
}
