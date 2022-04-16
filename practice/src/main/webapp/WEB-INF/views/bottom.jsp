<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- 
	세션에서 인증이 되었다면
	property: principal 객체를 principal이라는 이름으로 넣음
 -->
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>
	
	
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>bottom</title>
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="/css/bottom.css">
<link rel="stylesheet" href="/css/style.css">
</head>

<body>
	<!-- 
        
    좌) 공지사항
        메인 화면에서 보이는 글 몇 개랑
        공지사항 버튼을 누르면 공지사항 페이지로
    
    
    우) 
    1) 슬라이드 배너 

    2) 버튼 배너 & 3) 이메일 주소 카톡 블로그 랑 연결되도록
-->
	<div class="bottom">

		<div class="wrapper">

			<div class="banner">
				<div class="add-section">
					<img class="on" src="/images/maple-1079235_1920.jpg" alt="">
					<img src="/images/pocket-watch-1637396_1920.jpg" alt=""> <img
						src="/images/sunset-1645105_1920.jpg" alt="">
				</div>
			</div>
			<div class="bottomBanner">
				<ul id="bannerInfo">
					<h3>개인 정보들 넣을 곳 프로필</h3>
					<br>

					<li>연락처 : ${principal.user.phone }</li>
					<li>이메일 : ${principal.user.email }</li>
					<li>카톡 : dladygks2@hanmail.net</li>
					<li>블로그 : <a href="${principal.user.blog }">${principal.user.blog }</a></li>
				</ul>

				<div id="slider">
					<div id="viewer">
						<img id="image1" src="images/pexels-alesia-kozik-6842434.jpg" alt="" /> 
						<img id="image2" src="images/pexels-bich-tran-1059380.jpg" alt="" /> 
						<img id="image3" src="images/pexels-henri-mathieusaintlaurent-5898313.jpg" alt="" />

					</div>
					<ul id="btnGroup">
						<li id="btn0"><a
							href="images/pexels-alesia-kozik-6842434.jpg">1</a></li>
						<li id="btn1"><a href="images/pexels-bich-tran-1059380.jpg">2</a></li>
						<li id="btn2"><a
							href="images/pexels-henri-mathieusaintlaurent-5898313.jpg">3</a></li>
					</ul>
				</div>

			</div>

		</div>

		<div class="notice">
			<h1><a href="notice">공지사항</a></h1>

			<ul>
				<li class="line-bottom">제목<span>날짜</span></li>

				<li><a href="#">공지사항의 제목과 연동되도록</a><span>2018-10-24</span></li>

				<li><a href="#">아무거라도 좋으니 내용을 입력하세요!!!</a><span>2018-10-24</span></li>

				<li><a href="#">아무거라도 좋으니 내용을 입력하세요!!!</a><span>2018-10-24</span></li>

				<li><a href="#">아무거라도 좋으니 내용을 입력하세요!!!</a><span>2018-10-24</span></li>

				<li><a href="#">아무거라도 좋으니 내용을 입력하세요!!!</a><span>2018-10-24</span></li>

				<li><a href="#">아무거라도 좋으니 내용을 입력하세요!!!</a><span>2018-10-24</span></li>

				<li><a href="#">아무거라도 좋으니 내용을 입력하세요!!!</a><span>2018-10-24</span></li>

				<li><a href="#">아무거라도 좋으니 내용을 입력하세요!!!</a><span>2018-10-24</span></li>

			</ul>
		</div>
	</div>
</body>
<script>
	$(document).ready(function() {

		var current = 0;
		var setIntervalId;

		timer();

		function timer() {

			setIntervalId = setInterval(function() {
				var n = current + 1;
				if (n >= 3) {
					n = 0;
				}
				move(n);
				$(".add-section").removeClass("on");
				$(".add-section").eq(i).addClass("on");
			}, 3000);
		}

		function move(n) {
			var currentEl = $(".add-section > img").eq(current);
			var nextEl = $(".add-section > img").eq(n);
			currentEl.css({
				left : '0%'
			}).animate({
				left : '-100%'
			});
			nextEl.css({
				left : '100%'
			}).animate({
				left : '0%'
			});

			current = n;
		}
	});

	// jQuery로 sliding enging 만들기
	$("#btnGroup a").click(function(e) {
		e.preventDefault();
		var idName = $(this).parent().attr("id");
		var n = idName.substr(3, 1);
		n = parseInt(n);
		// console.log("클릭된 li의 id : "+idName);
		// console.log("클릭된 li의 id의 마지막 번호 : "+n);
		slideTarget(n);
	});
	function slideTarget(n) {
		var pos = n * (-350) + "px";
		// $("#viewer").stop().animate({left:pos}, 500);
		$("#viewer").animate({
			left : pos
		}, 350);
	}
</script>

</html>