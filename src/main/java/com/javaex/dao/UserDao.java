package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao { // UserDao 클래스는 데이터베이스에 접근하여 사용자 정보를 조회하는 역할을 수행

	@Autowired
	private SqlSession sqlSession; // DB

	// 로그인
	public UserVo selectUser(UserVo userVo) { // 사용자정보 조회 후 인증된 정보 반환
		System.out.println("UserDao.selectUser");
		UserVo authUser = sqlSession.selectOne("user.selectUser", userVo);
		return authUser;
	}
	// sqlSession.selectOne("user.selectUser", userVo)를 호출하여 MyBatis를 통해 SQL 쿼리를 실행
	// "user.selectUser"는 MyBatis 매퍼 파일에서 해당 SQL 쿼리를 찾기 위한 네임스페이스와 아이디
	// selectOne 단일 행 반환하는 쿼리 시행

	// 회원가입
	public int insertUser(UserVo userVo) {
		System.out.println("UserDao.insertUser");
		int count = sqlSession.insert("user.insertUser", userVo);
		return count;
	}
	// sqlSession.insert 메서드를 호출하여 데이터베이스에 사용자 정보를 삽입

	// 회원정보수정폼용 (1명 정보가져오기)
	public UserVo selectUser(int no) {
		System.out.println("UserDao.selectUser");
		UserVo userVo = sqlSession.selectOne("user.selectUserByNo", no);
		return userVo;

	}
	// 매개변수로 int 타입의 no는 수정할 회원의 고유한 식별자

	// 회원정보수정
	public int updateUser(UserVo userVo) {
		System.out.println("UserDao.updateUser");
		int count = sqlSession.update("user.updateUser", userVo);
		return count;
	}
	// "user.updateUser"라는 SQL 문을 실행하여 데이터베이스에서 회원 정보를 수정
	// 수정된 회원 정보를 데이터베이스에 업데이트하고 수정된 행의 수를 반환
	// 이를 통해 회원 정보 수정 기능이 수행
}