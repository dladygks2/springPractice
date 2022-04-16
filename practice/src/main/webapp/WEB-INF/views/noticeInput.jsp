<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/noticeInput.css">
    <title>공지사항 등록</title>
</head>
<!--
<form action="/examples/media/action_target.php" method="get">
    <textarea name="opinion" cols="30" rows="5" readonly>의견이 없습니다.</textarea><br>
    <input type="submit">
</form>
-->

<body>
    <div class="wrapper">
        <h2>공지사항 등록</h2>
        <table class="container">
            <tr>
                <td class="color">작성자</td>
                <td><input type="text"></td>
                <td class="color">등록일</td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td class="color">제목</td>
                <td colspan="3"><input class="titleInput"  type="text"></td>
            </tr>
            <tr>
                <td class="color">내용</td>
                <td colspan="3">
                    <textarea name="" id="" cols="30" rows="10" >텍스트 영역</textarea>
                </td>
            </tr>
            <!-- 
            <tr>
                <td class="color">게시시작일</td>
                <td><input type="date"></td>
                <td class="color">게시종료일</td>
                <td><input type="date"></td>
            </tr>
             -->
        </table>
        <button type="button" class="btn">취소</button>
        <button type="submit" class="btn">등록</button>
    </div>
</body>

</html>