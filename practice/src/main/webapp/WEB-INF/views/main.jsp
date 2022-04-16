<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!-- 세션에서 인증이 되었다면 -->
<sec:authorize access="isAuthenticated()">
	<!-- property: principal 객체를 principal이라는 이름으로 넣음 -->
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>사진이랑 올린 글 보는 곳</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<section class="section">

		<jsp:include page="nav.jsp"></jsp:include>


		<div class="banner2" onclick="location.href='makePost'">글 작성하기</div>

		<div class="board-item-group2">

			<div class="board-item" onclick="location.href='viewPost'">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/add.png" alt="">
				<h3>${principal.post.post_title }</h3>
				<p>${principal.post.create_date }</p>
			</div>
			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/signin_title.PNG" alt="">
				<h3>${principal.post.post_title }</h3>
				<p>${principal.post.create_date }</p>
			</div>
			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/signin_title.PNG" alt="">
				<h3>제목</h3>
				<p>등록일 : 2022-03-04</p>
			</div>
		</div>

		<div class="board-item-group2">

			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/add.png" alt="">
				<h3>제목이 어떤식으로 보이려나</h3>
				<p>등록일 : 2022-03-09</p>
			</div>
			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/signin_title.PNG" alt="">
				<h3>제목 얼마나 제목을 길게 적을 ㅅ
					ㅜ있으려나ㅇ너라미러ㅏㅇㄴ린ㅁㅇㅀㄴ애adsfasdfdasfdssad먼햐래adfasdfdasfdsfsdfsfdsㅎㅁ너햄냫모햐ㅐㄱㄱㅈ</h3>
				<p>등록일 : 2022-03-09</p>
			</div>
			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/signin_title.PNG" alt="">
				<h3>제목</h3>
				<p>등록일 : 2022-03-09</p>
			</div>
		</div>

		<div class="board-item-group2">

			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/add.png" alt="">
				<h3>제목이 어떤식으로 보이려나</h3>
				<p>등록일 : 2022-03-09</p>
			</div>
			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/signin_title.PNG" alt="">
				<h3>제목 얼마나 제목을 길게 적을 ㅅ
					ㅜ있으려나ㅇ너라미러ㅏㅇㄴ린ㅁㅇㅀㄴ애adsfasdfdasfdssad먼햐래adfasdfdasfdsfsdfsfdsㅎㅁ너햄냫모햐ㅐㄱㄱㅈ</h3>
				<p>등록일 : 2022-03-08</p>
			</div>
			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/signin_title.PNG" alt="">
				<h3>제목</h3>
				<p>등록일 : 2022-03-08</p>
			</div>
		</div>

		<div class="board-item-group2">

			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/add.png" alt="">
				<h3>제목이 어떤식으로 보이려나</h3>
				<p>등록일 : 2022-03-07</p>
			</div>
			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/signin_title.PNG" alt="">
				<h3>제목 얼마나 제목을 길게 적을 ㅅ
					ㅜ있으려나ㅇ너라미러ㅏㅇㄴ린ㅁㅇㅀㄴ애adsfasdfdasfdssad먼햐래adfasdfdasfdsfsdfsfdsㅎㅁ너햄냫모햐ㅐㄱㄱㅈ</h3>
				<p>등록일 : 2022-03-07</p>
			</div>
			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/signin_title.PNG" alt="">
				<h3>제목</h3>
				<p>등록일 : 2022-03-06</p>
			</div>
		</div>

		<div class="board-item-group2">

			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/add.png" alt="">
				<h3>제목이 어떤식으로 보이려나</h3>
				<p>등록일 : 2022-03-05</p>
			</div>
			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/signin_title.PNG" alt="">
				<h3>제목 얼마나 제목을 길게 적을 ㅅ
					ㅜ있으려나ㅇ너라미러ㅏㅇㄴ린ㅁㅇㅀㄴ애adsfasdfdasfdssad먼햐래adfasdfdasfdsfsdfsfdsㅎㅁ너햄냫모햐ㅐㄱㄱㅈ</h3>
				<p>등록일 : 2022-03-05</p>
			</div>
			<div class="board-item">
				<!-- 이거 하나가 한줄에 3개씩 나오는 게시글의 하나다.-->
				<img src="images/signin_title.PNG" alt="">
				<h3>제목</h3>
				<p>등록일 : 2022-03-05</p>
			</div>
		</div>

	</section>

	<jsp:include page="bottom.jsp"></jsp:include>
</body>

</html>