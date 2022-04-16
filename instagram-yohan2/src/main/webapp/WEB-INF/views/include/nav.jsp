<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    <!-- JSTL -->
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
   <sec:authorize access="isAuthenticated()">
     <sec:authentication property="principal" var="principal"/>
   </sec:authorize>
   
<!DOCTYPE html>
 
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instagram</title>
    <link rel="stylesheet" href="/css/nav.css">
     <link rel="stylesheet" href="/css/sytle.css">
    <script src="https://kit.fontawesome.com/c3df4d7d1c.js" crossorigin="anonymous"></script>
</head>

<body>
    
        <nav class="nav-bar">
            <div class="nav-main">
                <div class="nav-logo">
                    <a href="/">
                        <img src="/images/instagram_logo.png">
                    </a>
                </div>
                <div class="nav-search">
                    <div class="nav-search-border">
                        <i class="fas fa-search"></i>
                        <input type="text" class="nav-search-ip" placeholder="검색">
                    </div>
                </div>
                <div class="nav-items">
                <!-- if문 = c:choose -->
                
                	<!--  when = else if 와 동일, test="조건" -->
                	<!-- principal.user 가 비어 있으면 true이다. -->
                	<c:choose>
                		<c:when test="${empty principal.user}">
                			<div class="nav-item" >
                				 <button type="button" class="signin-btn" onclick="location.href='/auth/signin'">로그인</button>
                			</div>
                			<div class="nav-item" >
                				 <button type="button" class="signup-btn"  onclick="location.href='/auth/signup'">가입하기</button>
                			</div>
                		</c:when> 
                		<c:otherwise>
                			<div class="nav-item">
		                        <i class="fas fa-home" id="nav-home-icon"></i>
		                    </div>
		                    <div class="nav-item">
		                    	<a href="/upload">
		                        	<i class="far fa-plus-square" id="nav-plus-icon"></i>
		                        </a>
		                    </div>
		                    <div class="nav-item">
		                    	<a href="/${principal.username}">
		                    		<div class="nav-items-profile">
		                            	<img id="nav-profile-img" src="/image/${principal.userDtl.profile_img }">
		                        	</div>
		                    	</a>
		                    </div>
                		</c:otherwise>
                	</c:choose> 
                </div>
            </div>
        </nav> 
</body>
</html>