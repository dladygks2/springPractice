<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
로그인 페이지

<form action="/study/signin" method="post"> 
	<label class="ip-names">아이디</label>
 	<input type="text" class="signin-ips" name="username" value="${signinRespDto.username }" required="required"></br>
	<label class="ip-names">비밀번호</label> 
	<input type="password" class="signin-ips"  name="password" value="${signinRespDto.password }" required="required"></br>

	<button type="button" class="signin-btn">로그인</button>
</form>
<button type="button" onclick="location.href='/study/signup' ">회원가입</button>
<!-- button은 타입을 따로 주지 않으면 type="submit" 이 기본값이다. -->
 <input type="text" value="${principal.name}">
  <script src="/study/resources/signinAjax.js"></script> 
 
</body>
</html>