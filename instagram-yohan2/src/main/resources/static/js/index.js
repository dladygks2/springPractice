const boardGroup = document.querySelector('.board-group');


var page = 0;
var boardItem = ``;
var indexBoardTotalCount = 0;

window.onscroll = () => {
	let checkNum = $(document).height() - $(window).height() -$(window).scrollTop();
	
	if(checkNum < 1 && checkNum > -1 && indexBoardTotalCount > (page + 1)*3) {
		page++;
		boardLoad();
	}
}

boardLoad(); 

function boardLoad(){
	$.ajax({
		type: "get", 
		url: `/index/board?page=${page}`, // username이 뭐고 page는 어딘지 확인.위에 page는 0으로 초기화되어있다.
		dataType: "text",  // "text" 는 JSON 데이터로 들고 온다
		success: function(data){
			let boardListObj = JSON.parse(data); // JSON 객체이다.// JSON이 무엇인지.
			boardItem += getBoard(boardListObj.indexBoardList);
			boardGroup.innerHTML = boardItem;
			indexBoardTotalCount = parseInt(boardListObj.indexBoardTotalCount);
		},
		error: function(){
			alert('비동기 처리 오류');
		}
	});
}

function getBoard(boardList){
	let boardHtml = ``;
	
	for(let board of boardList){
		
		boardGroupHtml += `
			<div class="board-item">
                        <div class="board-profile">
                            <div class="profile-img-border">
                                <img src="/image/${board.profile_img}"> 
                            </div>
                            <div class="username-lb">
                                <a href="/${board.username}">
                                    <h1>${board.username}</h1>
                                </a>
                            </div>
                        </div>
                        <div class="board-img">
                            <img src="/image/${board.board_img}">
                        </div>
                        <div class="board-btns">
                            <i class="far fa-heart"></i>
                            <i class="far fa-comment"></i>
                            <i class="far fa-paper-plane"></i>
                        </div>
                        <div class="board-like-count">
                            좋아요 <span>52개</span>
                        </div>
                        <div class="board-contents">
                            <div class="board-content">
                                <pre><a href="/${board.username}"><div class="username-lb">${board.username}</div></a>${board.board_content}</pre>
                            </div>
                            <div class="board-comment">

                            </div>
                        </div>
                        <div class="board-comment-input">
                            <input type="text">
                            <button type="button">게시</button>
                        </div>
                    </div>
		`;
	} 
	return boardHtml;
}
