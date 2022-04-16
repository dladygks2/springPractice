<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 얘는 페이지 지시자 -->

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!-- 위에 이걸로 jsp에서 if조건문이나 반복문을 처리할 것이다. -->



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script><!-- jquery 라이브러리를 사용한다는 코드 -->
</head>
<body>
회원가입 페이지
 
 <form action="/study/signup" method="post"> 
<!-- <form action="/study/signup" method="get"> --> 
<!-- type -> id -> class -> name -> 등등 순서대로 작성해라.  -->
	<!--  label = element, class= attribute, 아이디 = text-->
	<label class="ip-names">아이디</label>
	<input type="text" class="signup-ip" name="username"  required="required">
	<button type="button" id="id-check" >중복확인</button></br>
	
	<label class="ip-names">비밀번호</label> 
	<input type="password" class="signup-ip" name="password"   required="required"></br>
	
	<label class="ip-names">이름</label> 
	<input type="text" class="signup-ip" name="name"   required="required"></br>
	
	<label class="ip-names">이메일</label> 
	<input type="email" class="signup-ip" name="email"  required="required"></br>

</br>
<button type="button" id="signup-btn">가입하기</button>&nbsp&nbsp
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
<script src="/study/resources/signupAjax.js"></script>
<!--
 Ajax : 비동기처리방식을 의미.

소스코드는 순서대로 처리된다.
처리되다가 중간에 데이터를 불러와야하는 경우가 생긴다.
그 동안에 밑에꺼는 실행되지 않는다. 불러오는동안
비동기처리는 데이터 불러와야하는 시간이 오래 걸리는 것을 보류하고 띄어넘어서 밑에 코드를 실행하고
다 실행되면 실행되지 않은 부분을 마지막으로 처리한다.

페이지에서 중복확인버튼을 클릭했을때, 요청이 POST로 날라간다. POST처리 되고 RESPONSE가 오면 
view reserver가 응답해줌

비동기처리방식은 페이지를 다시 불러오는것이 아니라 저 부분 데이터만 전송을해서 데이터만 받아오는것(자바스크립트로 받을 것)
Ajax는 제이쿼리를 사용할 것
  -->

<!-- button은 타입을 따로 주지 않으면 type="submit" 이 기본값이다. -->

</body>
</html>







