<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 얘는 페이지 지시자 -->

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!-- 위에 이걸로 jsp에서 if조건문이나 반복문을 처리할 것이다. -->



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
회원가입 페이지(auth)
 
 <form action="/study/signup" method="post"> 
<!-- <form action="/study/signup" method="get"> --> 
<!-- type -> id -> class -> name -> 등등 순서대로 작성해라.  -->
	<input type="hidden" id="submit-flag" name="submitFlag" value="0">
	<!--  label = element, class= attribute, 아이디 = text-->
	<label class="ip-names">아이디</label>
	<input type="text" class="signup-ip" name="username" value="${signupRespDto.username }" required="required">
	<!-- ${signupRespDto.username} 의 signupRespDto는 "" 안에 있는 키값이다. -->
	<input type="hidden" id="id-check-flag" name="idCheckFlag" value="${empty signupRespDto.idCheckFlag ? '' : signupRespDto.idCheckFlag}">
	<button type="button" id="id-check" >중복확인</button></br>
	
	
	<label class="ip-names">비밀번호</label> 
	<input type="password" class="signup-ip" name="password" value="${signupRespDto.password }" required="required"></br>
	
	<label class="ip-names">이름</label> 
	<input type="text" class="signup-ip" name="name" value="${signupRespDto.name }" required="required"></br>
	
	<label class="ip-names">이메일</label> 
	<input type="email" class="signup-ip" name="email" value="${signupRespDto.email }" required="required"></br>

</br>
<button type="button" id="signup-btn">가입하기</button>&nbsp &nbsp
<button type="reset">재작성</button>
<!-- 

required="required" : null 값이 허용되지 않는다. 
필수 항복이라는 의미
submit이 안날라간다.

지금 이것들은 GET방식으로 작성한 것

GET : 주소창에 요청하는 것 (직접입력하는 것) // 
http://localhost:8000/study/signup?username=abc&password=1234&name=fd&email=abc%40naver.com


POST : 

-->
 
</form>

<div class="test-text">안녕하세요</div>


<!-- onclick="location.href='/study/signin 이런거 get방식 -->
<button type="button" onclick="location.href='/study/signin' ">로그인</button>

<script src="/study/resources/signup.js"></script>


<!-- button은 타입을 따로 주지 않으면 type="submit" 이 기본값이다. -->

</body>
</html>







