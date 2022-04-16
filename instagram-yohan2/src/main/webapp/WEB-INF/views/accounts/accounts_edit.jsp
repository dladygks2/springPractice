<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- dependency에 등록되었다면 uri 주소가 Ctrl + space키 로 접근가능하다  -->
    <!--  그러면 taglib = taglibrary 가 사욯가능하다.
			밑의 것은 prefix가 sec인 라이브러리를 사용하겠다.
-->
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
  <!-- 
  		DB에서 Controller를 통해서 값을 들고와서 .jsp에 표현을 해줄 것이다. 동적으로 
  		pageController에서 Model 객체를 사용하는 방법이 하나 있다.
  -->
   <sec:authorize access="isAuthenticated()"> 
   <!-- 
   			isAuthenticated() 메서드 : 외워야한다. "session에서 인증이 되었으면~" 이런 뜻이다 
   			즉, access가 되었을 때에 
   			밑의 principal(property = 객체)에 principal 변수를 넣겠다는 의미
   -->
     <sec:authentication property="principal" var="principal"/> 
     <!-- 
     sec:authentication 이거는 session으로 
     property = "principal" 로 고정으로 입력해줘라
     var 도 뭐 똑같다.
     
     이 principal 객체는 
     pageController에서
     @AuthenticationPrincipal PrincipalDetails principalDetails 
     이것은 로그인을 성공했을 때 반환해주는 객체인데. 
     session에 principalDetails라는 객체가 있고 이것을 가져다 쓸 때와 똑같은거라고 보면됨
      -->
   </sec:authorize>
   
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instagram</title>
    <link rel="stylesheet" href="/css/accounts_menu.css">
    <link rel="stylesheet" href="/css/accounts_edit.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<!-- 입력들 받는거를 할때는 HeidiSQL 에서 받는다.  -->
<body>
    <section>
        <jsp:include page="../include/nav.jsp"></jsp:include>
        <main>
            <div class="container">
                <ul class="menu-list">
                    <li class="menu-li">
                        <a href="/accounts/edit" class="menu-li-a-select">프로필 편집</a>
                    </li>
                    <li class="menu-li">
                        <a href="/accounts/password/change" class="menu-li-a">비밀번호 변경</a>
                    </li>
                </ul>
                <article>
                    <div class="edit-profile-img">
                        <div class="edit-profile-img-border">
                            <img id="profile-img" src="/image/${principal.userDtl.profile_img }">
                        </div>
                        <div class="username-lb">
                            <h1 id="principal-username">${principal.user.username }</h1>
                            <div class="profile-img-change-btn">프로필 사진 바꾸기</div>
                        </div>
                    </div>
                    <form enctype="multipart/form-data">
                    
                    <input type="file" id="file" name="file">
                        <div class="edit-items">
                            <aside>
                                <label for="name-ip" class="edit-lb">이름</label>
                            </aside>
                            <div class="edit-ip">
                                <input type="text" id="name-ip" class="profile-ip" name="name" value="${principal.user.name }">
                            </div>
                        </div>
                        <div class="edit-items">
                            <aside>
                                <label for="username-ip" class="edit-lb">사용자 이름</label>
                            </aside>
                            <div class="edit-ip">
                                <input type="text" id="username-ip" class="profile-ip"  name="username" value="${principal.user.username }">
                            </div>
                        </div>

                        <div class="edit-items">
                            <aside>
                                <label for="website-ip" class="edit-lb">웹사이트</label>
                            </aside>
                            <div class="edit-ip">
                                <input type="text" id="website-ip" class="profile-ip"  name="website" value="${ principal.userDtl.website }">
                            </div>
                        </div>

                        <div class="edit-items">
                            <aside>
                                <label for="introduction-ip" class="edit-lb">소개</label>
                            </aside>
                            <div class="edit-ip">
                                <textarea id="introduction-ip"  class="profile-ip" name="introduction" >${ principal.userDtl.introduction }</textarea>
                            </div>
                        </div>


                        <div class="edit-items">
                            <aside>
                                <label for="email-ip" class="edit-lb">이메일</label>
                            </aside>
                            <div class="edit-ip">
                                <input type="text" id="website-ip" class="profile-ip"  name="email" value="${principal.user.email }">
                            </div>
                        </div>


                        <div class="edit-items">
                            <aside>
                                <label for="phone-ip" class="edit-lb">전화번호</label>
                            </aside>
                            <div class="edit-ip">
                                <input type="text" id="website-ip"  class="profile-ip" name="phone" value="${ principal.userDtl.phone }">
                            </div>
                        </div>


                        <div class="edit-items">
                            <aside>
                                <label for="gender-ip" class="edit-lb">성별</label>
                            </aside>
                            <div class="edit-ip">
                                <input type="text" list="gender-ip" class="profile-ip"  name="gender" value="${ principal.userDtl.gender }">
                                <datalist id="gender-ip">
                                    <option value="남성"></option>
                                    <option value="여성"></option>
                                    <option value="맞춤성별"></option>
                                    <option value="밝히고 싶지 않음"></option>
                                </datalist>
                            </div>
                        </div>

                        <div class="edit-items">
                            <aside>

                            </aside>
                            <div class="edit-ip">
                                <button type="button" class="edit-submit-btn">제출</button>
                            </div>
                        </div>
                    </form>
                </article>
            </div>
        </main>
    </section>
    <script src="/js/accounts_edit.js"></script>
</body>

</html>