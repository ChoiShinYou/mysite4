<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function() {
		if (confirm('비밀번호가 일치하지 않습니다. 다시 입력해주세요.')) {
			location.href = './loginForm';
		} else {
			location.href = '${pageContext.request.contextPath}/main';
		}
	};
</script>
</head>
<body>

</body>
</html>