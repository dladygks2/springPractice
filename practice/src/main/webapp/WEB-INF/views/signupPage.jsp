<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 페이지</title>
    <link rel="stylesheet" href="/css/signupPage.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>

<jsp:include page="nav.jsp"></jsp:include>
    <div class="wrapper">

        <h3>회원가입</h3>

        <form action="" method="post">
            <table>
                <tr>
                    <td>이름</td>
                    <!-- su-item 에 회원가입에 사용할 정보들을 모을 것이다. -->
                    <td><input type="text" class="su-input" name="name"></td>
                </tr>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" class="su-input" name="username"></td>
                    <td>
                        <input id="idCheck" type="submit" value="아이디 중복검사" />
                    </td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" class="su-input" name="password"></td>
                </tr>
                <tr>
                    <td>비밀번호 확인</td>
                    <td><input type="password" class="su-input" name="passwordCheck" ></td>
                </tr>
                <tr>
                    <td>연락처</td>
                    <td>
                        <select class="su-input" >

                            <option value="t010">010</option>

                            <option value="t011">011</option>

                            <option value="t016">016</option>

                            <option value="t017">017</option>

                            <option value="t019">019</option>

                        </select>

                        -<input type="text" maxlength="4" size="4">
                        -<input type="text" maxlength="4" size="4">
                    </td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="email" class="su-input" ></td>
                </tr>
                <tr>
                    <td>블로그</td>
                    <td><input type="url" class="su-input" ></td>
                </tr>
            </table>
            <br>
            <input class="submit" type="submit" value="가입하기" />
            <input type="reset" value="다시 작성" />

        </form>
    </div>
    <script src="/js/signup.js"></script>
</body>

</html>