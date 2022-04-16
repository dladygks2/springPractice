<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Instagram</title>
<link rel="stylesheet" href="/css/my_profile.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<!-- 로그인이 되어있는지 아닌지를 체크한후 로그인되어있으면 여기로 -->
<body>
	<section>
		<jsp:include page="../include/nav.jsp"></jsp:include>
		<main>
			<div class="container">
				<header class="profile-header">
					<div class="profile-img">
						<img src="/image/${profileRespDto.profile_img }">
					</div>
					<div class="profile-info">
						<div class="profile-info-top">
							<h1 class="profile-username">${profileRespDto.username }</h1>
							<button type="button" class="profile-edit-btn"
								onclick="location.href='/accounts/edit'">프로필 편집</button>
							<i id="setting-btn" class="fa-solid fa-gear"></i>
						</div>
						<div class="profile-info-middle">
							<div class="profile-info-middle-item">
								게시물 <span>${profileRespDto.boardTotalCount }</span>
							</div>
							<div class="profile-info-middle-item cursor-pointer">
								팔로워 <span>${profileRespDto.followerCount }</span>
							</div>
							<div class="profile-info-middle-item cursor-pointer">
								팔로우 <span>${profileRespDto.followingCount }</span>
							</div>
						</div>
						<div class="profile-info-bottom">
							<pre>${profileRespDto.introduction}</pre>
						</div>
					</div>
				</header>
				<section>
					<div class="board-menu">
						<div class="board-menu-item">
							<i class="fas fa-table"></i> <span>게시물</span>
						</div>
					</div>
					<div class="board-container">
						<!-- <div class="board-item-group">
							<div class="board-item">
								<img src="images/signin_title.PNG" alt="">
								<div class="board-item-hover">
									<div class="board-item-like">
										<i class="fas fa-heart"></i><span>91</span>
									</div>
									<div class="board-item-comment">
										<i class="fas fa-comment"></i><span>30</span>
									</div>
								</div> 
							</div>-->
						</div>
							 
				</section>
			</div>
		</main>
	</section>
	<div class="modal-container">
		<div class="setting-modal">
			<button type="button" class="setting-modal-btn">비밀번호 변경</button>
			<button type="button" class="setting-modal-btn">로그아웃</button>
			<button type="button" class="setting-modal-btn">취소</button>
		</div>
	</div>
	<div class="modal-container">
        <i id="close-btn" class="fas fa-times"></i>
        <div class="board-modal-body">
             
        </div>
    </div>

	<input type="hidden" id="username" value="${profileRespDto.username}">
	<input type="hidden" id="board-total-count" value="${profileRespDto.boardTotalCount }">
	<script src="/js/my_profile.js"></script>
</body>
</html>