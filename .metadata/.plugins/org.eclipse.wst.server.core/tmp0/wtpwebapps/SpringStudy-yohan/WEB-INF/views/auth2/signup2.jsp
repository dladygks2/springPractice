<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
회원가입 페이지(auth2)

<!-- <form action="/study/signup2" method="post"> -->
<form action="/study/signup2" method="get">
아이디 : <input type="text" name="username" required="required"></br>
비밀번호 : <input type="password" name="password" required="required"></br>
이름 : <input type="text" name="name" required="required"></br>
이메일 : <input type="email" name="email" required="required">

<button>회원가입하기</button> 
<!-- button의 기본값 = submit 밑에처럼 기본값을 type="button" 해줘야함  -->
<button type="reset">재작성</button>
</form>
<button type="button" onclick="location.href='/study/signin2'">로그인</button> 

</body>
</html>