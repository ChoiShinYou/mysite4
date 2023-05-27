<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css"
	rel="stylesheet" type="text/css">
	

</head>


<body>
	<div id="wrap">
	
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<!-- //header -->

		<c:import url="/WEB-INF/views/include/nav.jsp" />
		<!-- //nav -->

		<div id="aside">
			<h2>게시판</h2>
			<ul>
				<li><a href="">일반게시판</a></li>
				<li><a href="">댓글게시판</a></li>
			</ul>
		</div>
		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>게시판</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>게시판</li>
						<li class="last">일반게시판</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->

			<div id="board">
				<div id="list">
					<form action="serchBoard" method="get">
						<div class="form-group text-right">
							<input type="text" name="title" value="${board.title}">
							<button type="submit" id=btn_search>검색</button>
						</div>
					</form>
					<table>
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>조회수</th>
								<th>작성일</th>
								<th>관리</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="board" items="${boardList}">
								<tr>
									<td>${board.no}</td>
									<td class="text-left"><a
										href="./readForm?no=${board.no}&userNo=${board.userNo}">${board.title}</a></td>
									<td>${board.name}</td>
									<td>${board.hit}</td>
									<td>${board.regDate}</td>
									<c:if test="${board.userNo==user.no}">
										<td><a href="./delete?no=${board.no}">[삭제]</a></td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<div id="paging">
						<ul>
							<li><a href="" >◀</a></li>
							<li><a href="/board/list?int=1" >1</a></li>
							<li><a href="/board/list?int=2">2</a></li>
							<li><a href="/board/list?int=3">3</a></li>
							<li><a href="/board/list?int=4">4</a></li>
							<li class="active"><a href="/board/list?int=5">5</a></li>
							<li><a href="/board/list?int=6">6</a></li>
							<li><a href="/board/list?int=7">7</a></li>
							<li><a href="/board/list?int=8">8</a></li>
							<li><a href="/board/list?int=9">9</a></li>
							<li><a href="/board/list?int=10">10</a></li>
							<li><a href="">▶</a></li>
						</ul>


						<div class="clear"></div>
					</div>
					<c:choose>
						<c:when test="${empty user.id}">
							<a id="btn_write" href="/mysite/user/loginForm">글쓰기</a>
						</c:when>
						<c:otherwise>
							<a id="btn_write" href="./writeForm">글쓰기</a>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- //list -->
			</div>
			<!-- //board -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp" />
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>