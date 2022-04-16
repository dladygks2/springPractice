<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="/css/sytle.css">
    <link rel="stylesheet" href="/css/signup.css">
    <script src="https://kit.fontawesome.com/806eb2d3a6.js" crossorigin="anonymous"></script>
	<!-- 
		AJAX를 쓰기위해서는 JQuery를 추가해주어야한다. 
		AJAX는 AJAX가 사용되는 부분만 새로고침되고 뭐 그런건데...
	-->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <section>
        <main>
            <div class="su-items">
                <div class="su-items-ip">
                    <div class="su-logo">
                        <img src="/images/instagram_logo.png">
                    </div>
                    <div class="su-item">
                    	<button class="su-submit-btn">
                            <i class="fab fa-facebook-square"></i>
                            <span>Facebook으로 로그인</span>
                        </button>
                    </div>
                    <div class="su-item">

                        <div class="hr-sect"> <span> 또는 </span></div>

                    </div>
                    <div class="su-login-form">    <!-- AJAX 요청을 날린단다. AJAX가 딴 부분은 놔두고 이부분만 사용하기 위해서 쓰는 거랬던가?-->
	<!--  입력받는 input 들에게 전부 name을 부여할 것이다. 얘들 name으로 .js랑 SQL에서 사용할 듯???-->
	<!-- 이제 AuthController 를 만든다.  -->
                        <div class="su-item"><input type="text" class="su-input" name="email" placeholder="휴대폰 번호 또는 이메일 주소">
                        </div>
                        <div class="su-item"><input type="text" class="su-input" name="name" placeholder="성명">
                        </div>
                        <div class="su-item"><input type="text" class="su-input" name="username" placeholder="사용자 이름">
                        </div>
                        <div class="su-item"><input type="password" class="su-input" name="password" placeholder="비밀번호"></div>
                        <div class="su-item">
                        	<button class="su-submit-btn">가입</button>
                        </div>


                        <div class="su-item">
                            <div class="su-message"></div>
                        </div>


                    </div>
                </div>
                <div class="su-signin">
                    <div class="su-signin-text">계정이 있으신가요? <a href="/auth/signin">로그인</a></div>
                </div>
                <div class="su-download-text">앱을 다운로드하세요.</div>
                <div class="su-download-btns">
                    <a href="#"><img src="/images/signin_download.png"></a>
                    <a href="#"><img src="/images/signin_download2.png"></a>
                </div>
            </div>
        </main>


    </section>
    <script src="/js/signup.js"></script>
</body>

</html>