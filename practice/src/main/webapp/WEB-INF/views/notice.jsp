<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 페이지</title>
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" href="/css/notice.css">
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>
    <!-- 
    참고할만할라나??
    https://www.phpschool.com/gnuboard4/bbs/board.php?bo_table=qna_html&wr_id=270039&page=214
 -->
 
 
 <jsp:include page="nav.jsp"></jsp:include>
 
    <div class="wrapper">
        <h2>공지사항</h2>

        <table id="notice">
            <tr class="tbl_first">
                <td>번호</td>
                <td>제목</td>
                <td>날짜</td>
                <td>작성자</td>
                <td>조회수</td>
            </tr>
            <tr>
                <td>1</td>
                <td><a href="noticeRead">[공지사항]공지입니다.</a></td>
                <td>2022-06-12</td>
                <td>관리자</td>
                <td>5</td>
            </tr>
            <tr>
                <td>2</td>
                <td><a href="noticeRead">[공지사항]공지입니다.</a></td>
                <td>2022-06-12</td>
                <td>관리자</td>
                <td>132</td>
            </tr>
            <tr>
                <td>3</td>
                <td><a href="noticeRead">[공지사항]공지입니다.</a></td>
                <td>2022-06-12</td>
                <td>관리자</td>
                <td>5</td>
            </tr>
            <tr>
                <td>4</td>
                <td><a href="noticeRead">[공지사항]공지입니다.</a></td>
                <td>2022-06-12</td>
                <td>관리자</td>
                <td>132</td>
            </tr>
            <tr>
                <td>5</td>
                <td>[공지사항]공지입니다.</td>
                <td>2022-06-12</td>
                <td>관리자</td>
                <td>132</td>
            </tr>
            <tr>
                <td>6</td>
                <td>[공지사항]공지입니다.</td>
                <td>2022-06-12</td>
                <td>관리자</td>
                <td>132</td>
            </tr>
            <tr>
                <td>7</td>
                <td>[공지사항]공지입니다.</td>
                <td>2022-06-12</td>
                <td>관리자</td>
                <td>132</td>
            </tr>
            <tr>
                <td>8</td>
                <td>[공지사항]공지입니다.</td>
                <td>2022-06-12</td>
                <td>관리자</td>
                <td>132</td>
            </tr>
            <tr>
                <td>9</td>
                <td>[공지사항]공지입니다.</td>
                <td>2022-06-12</td>
                <td>관리자</td>
                <td>132</td>
            </tr>
             <tr>
                <td>10</td>
                <td>[공지사항]공지입니다.</td>
                <td>2022-06-12</td>
                <td>관리자</td>
                <td>132</td>
            </tr>
        </table>
        <button type="button" id="writeBtn" onclick="location.href='noticeInput'">글쓰기</button>
    </div>
</body>
<script>
    // 페이징 처리하는 거란다. 일단 들고 있어보자
    var $setRows = $('#setRows');

    $setRows.submit(function (e) {
        e.preventDefault();
        var rowPerPage = $('[name=" rowPerPage"]').val() * 1;// 1 을 곱하여 문자열을 숫자형로 변환 // console.log(typeof rowPerPage);
        var zeroWarning = 'Sorry, but we cat\' t display "0" rows page. + \nPlease try again.' if (!rowPerPage) {
            alert(zeroWarning); return;
        } $('#nav').remove(); var $products = $('#products'); $products.after('<div
            id = "nav" > ');


            var $tr = $($products).find('tbody tr');
        var rowTotals = $tr.length;
        // console.log(rowTotals);

        var pageTotal = Math.ceil(rowTotals / rowPerPage);
        var i = 0;

        for (; i < pageTotal; i++) {
            $('<a href="#"></a>')
                .attr('rel', i)
                .html(i + 1)
                .appendTo('#nav');
        }

        $tr.addClass('off-screen')
            .slice(0, rowPerPage)
            .removeClass('off-screen');

        var $pagingLink = $('#nav a');
        $pagingLink.on('click', function (evt) {
            evt.preventDefault();
            var $this = $(this);
            if ($this.hasClass('active')) {
                return;
            }
            $pagingLink.removeClass('active');
            $this.addClass('active');

            // 0 => 0(0*4), 4(0*4+4)
            // 1 => 4(1*4), 8(1*4+4)
            // 2 => 8(2*4), 12(2*4+4)
            // 시작 행 = 페이지 번호 * 페이지당 행수
            // 끝 행 = 시작 행 + 페이지당 행수

            var currPage = $this.attr('rel');
            var startItem = currPage * rowPerPage;
            var endItem = startItem + rowPerPage;

            $tr.css('opacity', '0.0')
                .addClass('off-screen')
                .slice(startItem, endItem)
                .removeClass('off-screen')
                .animate({ opacity: 1 }, 300);

        });

        $pagingLink.filter(':first').addClass('active');

    });


    $setRows.submit();
</script>

</html>