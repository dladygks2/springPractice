<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />

</sec:authorize>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>notice(공지사항)에 들어가서 글을 누르면 보이는 창</title>
<link rel="stylesheet" href="css/noticeRead.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>


	<div class="wrapper">
		<h2>공지사항 상세</h2>
		<table class="container">
			<tr>
				<td class="color">작성자</td>
				<td>${principal.user.username}</td>
				<td class="color">등록일</td>
				<td>2018-10-24</td>
			</tr>
			<tr>
				<td class="color">제목</td>
				<td colspan="3">${principal.notice.notice_title}</td>
			</tr>
			<tr>
				<td class="color">내용</td>
				<td colspan="3"><textarea name="" id="" cols="30" rows="10"
						readonly>${principal.notice.notice_content}</textarea></td>
			</tr>
			<tr>
				<td class="color">최종 수정일</td>
				<td colspan="3">${principal.notice.update_date}</td>
				<!-- 
                <td class="color">게시종료일</td>
                <td>2022-01-25</td>
                 -->
			</tr>
		</table>
		<button class="btn">수정</button>
		<button class="btn">삭제</button>
		<button class="btn">목록</button>
	</div>
</body>

</html>