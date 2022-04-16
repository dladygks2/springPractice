<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/test2-submit2" method="post">
		<input type="text" name="name"><br>
		<input type="text" name="phone"><br><br>
		<button>전송</button>
		<!-- 
		요청을 보내고 그 req에 resp해서 응답을 줄때 
		csrf 토큰을 같이 보낸다. 이것은 시큐리티(security)가 알아서 해준다. 
		토큰은 이것이 응답을 해준 
		 -->
	</form>
</body>
</html>