<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 페이지</title>
    <link rel="stylesheet" href="css/signinPage.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <!-- 
        아이디 패스워드 입력하는 줄
        (오른쪽으로 정렬)
        로그인 버튼
        아직 회원가입을 하지 않으셨나요? 회원가입 버튼
    -->
    <jsp:include page="nav.jsp"></jsp:include>
    <div class="wrapper">

        <h3>로그인</h3>

        <form action="" method="post">
            <table>

                <tr>
                    <td>아이디</td>
                    <td><input type="text" /></td>

                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password"></td>
                </tr>

            </table>
            <br>
            <input class="submit" type="submit" value="로그인" />
        </form>
        <div class="toSignup">
            <div>회원가입을 아직 하지 않으셨나요?</div>
            <div class="signupBtn"><a href="signupPage">회원가입</a></div>
        </div>
    </div>
</body>

</html>