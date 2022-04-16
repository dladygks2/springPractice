<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instagram</title>
    <link rel="stylesheet" href="/css/sytle.css">
    <link rel="stylesheet" href="/css/signin.css">
    <script src="https://kit.fontawesome.com/806eb2d3a6.js" crossorigin="anonymous"></script>
</head>

<body>
    <!-- 빈화면에서 '!' + 엔터키 치면 기본 html5 한거 만들어지는듯 -->

    <section>
        <main>
            <article>
                <div class="si-title-img">
                    <img src="/images/signin_title.png" width="380px">
                </div>
                <div class="si-items">
                    <div class="si-items-ip">
                        <div class="si-logo">
                            <img src="/images/instagram_logo.png">
                        </div>
                        <div class="si-login-form">
                        <!--  form -->
                        	<form action="/auth/signin" method="post"> <!-- SecurityConfig.java에 .loginProcessingUrl 부분이다.   -->
                        		<!-- form 안에 있는 button을 누르면 (button은 기본 submit이다. 그래서 action으로 post 요청이 보내진다.) -->
                        		<div class="si-item">
                        			<!--  name이 요청시에 parameter를 날릴 때, DB에서 받는 이름인가 -->
                        			<input type="text" class="si-input" name="username" placeholder="전화번호, 사용자이름 또는 이메일">
                            	</div>
                           		<div class="si-item">
                            		<input type="password" class="si-input" name="password" placeholder="비밀번호">
                            	</div>
                            	<div class="si-item">
                            		<button class="si-submit-btn">로그인</button> 
                            		<!-- <form action="/auth/signin" method="post"> 위의 이게 실행된다네 -->
                            		<!--  button의 기본 속성은 submit -->
                            	</div>
                            
                        	</form>

                            <div class="si-item">

                                <div class="hr-sect"> <span> 또는 </span></div>

                            </div>
                            <div class="si-item">
                            <!--  /oauth2/authorization/ 이 주소값은 고정값이다.-->
                               <a href="/oauth2/authorization/naver" class="si-facebook">
                                <!-- <a href="/oauth2/authorization/google" class="si-facebook"> -->
                                    <i class="fab fa-facebook-square"></i> <span>Facebook으로 로그인</span>
                                </a>
                            </div>
                            <div class="si-item">
                                <div class="si-message"></div>
                            </div>
                            <div class="si-item">
                                <a href="#" class="si-find-password">비밀번호를 잊으셨나요?</a>
                            </div>
                        </div>
                    </div>
                    
                    <div class="si-signup">										<!-- 이 부분이 pageController.java 에 부분 GET 요청이다.-->
                        <div class="si-signup-text">계정이 없으신가요? <a href="/auth/signup">가입하기</a></div>
                    </div>
                    <div class="si-download-text">
                         앱을 다운로드하세요.
                    </div>
                    <div class="si-download-btns">
                        <a href="#"><img src="/images/signin_download.png"></a>
                        <a href="#"><img src="/images/signin_download2.png"></a>
                    </div>
                </div>
            </article>

        </main>
        <footer>

        </footer>
    </section>
 
</body>

</html>