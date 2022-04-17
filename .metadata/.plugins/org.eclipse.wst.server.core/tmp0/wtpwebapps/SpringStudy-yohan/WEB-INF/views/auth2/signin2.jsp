<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
로그인 페이지(auth2)

<form action="/stydy/signin2" method="post">
아이디 : <input type="text" name="username"></br>
비밀번호 : <input type="password" name="password"></br>

<button>로그인</button> 
<!-- button의 기본값 = submit 밑에처럼 기본값을 type="button" 해줘야함  -->
</form>
<button type="button" onclick="location.href='/study/signup2'">회원가입</button> 

</body>
</html>