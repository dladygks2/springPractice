<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>클릭하면 화면이 보이는 부분</title>
    <link rel="stylesheet" href="css/viewPostReal.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://kit.fontawesome.com/94de3890c6.js" crossorigin="anonymous"></script>
</head>

<body>
<jsp:include page="nav.jsp"></jsp:include>
    <section>
    	
        <main>
        <!-- 
        	 my_profile.js 를 봐야하네 boardItemClick() 메서드가 화면 클릭시 큰화면이 나오는거
        	화면 아닌 곳을 누르면 도로 숨는거???
        -->
            <form action="">
                <div class="container">
                    <section class="img-section">
                        <div class="img-preview">
                            <img src="" class="upload-img">
                            이미지가 들어오는 곳

                            <div class="img-add">

                            </div>
                        </div>
                    </section>
                    <article class="img-article">
                        <!-- 이 X버튼을 누르거나 화면 바깥쪽을 누르면 종료되도록? -->
                        <i class="fa-solid fa-xmark" id="img-delete-btn"></i>

                        <div class="profile-info">
                            <div class="profile-img-border">
                                <img src="/image/${principal.userDtl.profile_img}" alt="프로필 이미지">
                            </div>
                            <div class="username-lb">
                                <h1>${principal.user.username }postTitle</h1>
                            </div>
                        </div>
                        <div class="upload-content-border">
                            <textarea class="upload-content"
                                name="boardContent">여기도 글자를 받는 곳으로 위의 X를 누르거나 화면 바깥쪽을 누르면 종료되도록?</textarea>
                        </div>
                        <!-- 작성한 시간도 받아야할 듯. -->
                        <div class="upload-submit-btn">
                        	여기는 글을 받는 곳들이네 그래서 이부분에 작성시간을 받으려고 했구나
                        
                        </div>
                    </article>
                </div>
            </form>
        </main>
    </section>
</body>

</html>