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
<link href="${pageContext.request.contextPath}/assets/css/user.css"
	rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp" />
		<!-- //header -->

		<c:import url="/WEB-INF/views/include/nav.jsp" />
		<!-- //nav -->

		<div id="aside">
			<h2>회원</h2>
			<ul>
				<li>회원정보</li>
				<li>로그인</li>
				<li>회원가입</li>
			</ul>
		</div>
		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>회원정보</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>회원</li>
						<li class="last">회원정보</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->

			<div id="user">
				<div id="modifyForm">
					<form action="./modify" method="get">

						<!-- 아이디 -->
						<div class="form-group">
							<label class="form-text" for="input-uid">아이디</label> <span
								class="text-large bold">${user.id}</span> <input type="hidden"
								id="input-pass" name="no" value="${user.no}"> <input
								type="hidden" id="input-pass" name="id" value="${user.id}">
						</div>

						<!-- 비밀번호 -->
						<div class="form-group">
							<label class="form-text" for="input-pass">패스워드</label> <input
								type="password" id="input-pass" name="password"
								value="${user.password}" placeholder="비밀번호를 입력하세요">
						</div>

						<!-- 이메일 -->
						<div class="form-group">
							<label class="form-text" for="input-name">이름</label> <input
								type="text" id="input-name" name="name" value="${user.name}"
								placeholder="이름을 입력하세요">
						</div>
						<c:if test="${'male' == user.gender}">
							<!-- //성별 남 -->
							<div class="form-group">
								<span class="form-text">성별</span> <label for="rdo-male">남</label>
								<input type="radio" id="rdo-male" name="gender" value="male"
									checked="checked"> <label for="rdo-female">여</label> <input
									type="radio" id="rdo-female" name="gender" value="female">
						</c:if>
						<c:if test="${'female' == user.gender}">
							<!-- //성별 여 -->
							<div class="form-group">
								<span class="form-text">성별</span> <label for="rdo-male">남</label>
								<input type="radio" id="rdo-male" name="gender" value="male">
								<label for="rdo-female">여</label> <input type="radio"
									id="rdo-female" name="gender" value="female" checked="checked">

							</div>
						</c:if>
						<!-- 버튼영역 -->
						<div class="button-area">
							<button type="submit" id="btn-submit">회원정보수정</button>
						</div>
					</form>


				</div>
				<!-- //modifyForm -->
			</div>
			<!-- //user -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp" />
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>