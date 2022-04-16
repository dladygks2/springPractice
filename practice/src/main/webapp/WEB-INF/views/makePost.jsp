<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<!DOCTYPE html> 
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글작성하는 부분</title>
    <link rel="stylesheet" href="css/makePostReal.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://kit.fontawesome.com/94de3890c6.js" crossorigin="anonymous"></script>
</head>

<body>
<jsp:include page="nav.jsp"></jsp:include>
    <section>
    
        <main class="main">
            <form action="">
                <div class="container">
                    <section class="img-section">
                        <div class="img-preview">
                            <img src="" class="upload-img">
                            <i class="fa-solid fa-xmark" id="img-delete-btn"></i>

                            <div class="img-add">
                                <i id="add-icon" class="fas fa-photo-video"></i>
                                <input type="file" class="upload-file" name="file" style="display: none;">
                                <p>사진과 동영상을 추가해주세요</p>
                                <button type="button" class="add-img-btn">컴퓨터에서 선택</button>
                            </div>
                        </div>
                    </section>
                    
                    <article class="img-article">
                        <div class="profile-info">
                            <div class="profile-img-border">
                                <img src="/image/${principal.userDtl.profile_img}">
                            </div>
                            <div class="username-lb">
                                <h1>${principal.user.username }</h1>
                            </div>
                        </div>
                        <div class="upload-content-border">
                        
                            <div class="title2">
                                <span>제목</span>
                                <input type="text" class="upload-title-input"  placeholder="제목을 입력해주세요">
                            </div>
                            <textarea class="upload-content" name="boardContent" placeholder="내용을 입력해주세요."></textarea>
                        	 
                        </div>
                       <div class="upload-submit-btn">글 올리기</div>
                    </article>
                </div>
            </form>
        </main>
    </section>
</body>

</html>