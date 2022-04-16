const body = document.querySelector('body');
const modalContainer = document.querySelectorAll('.modal-container');
const modalBtns = modalContainer[0].querySelectorAll('.setting-modal-btn');
const settingBtn = document.querySelector('#setting-btn');
const usernameObj = document.querySelector('#username');
const boardContainer = document.querySelector('.board-container');
const boardTotalCount = document.querySelector('#board-total-count');
var boardItem = document.querySelectorAll('.board-item');

var page = 0;
var username = usernameObj.value;
var boardGroupItem =``;
var boardTotal = boardTotalCount.value;

/*
window.onscroll = () => {
	alert(window.scrollTop);
}
*/

window.onscroll = () =>{
	let checkNum = $(document).height() - $(window).height() -$(window).scrollTop();

	if(checkNum < 1 && checkNum > -1 && boardTotal > (page + 1)*9) {
		page++;
		boardLoad();
	}
}
/* $.ajax 사용법(jQuery에 포함된다.)*/


boardLoad(); // 함수 실행


function boardLoad(){
	$.ajax({
		type: "get", 
		url: `/${username}/board?page=${page}`, // username이 뭐고 page는 어딘지 확인.위에 page는 0으로 초기화되어있다.
		dataType: "text",
		success: function(data){
			let boardGroupObj = JSON.parse(data); // JSON 객체이다.// JSON이 무엇인지.
			boardGroupItem += getBoardGroup(boardGroupObj.boardGroup);
			boardContainer.innerHTML = boardGroupItem;
			boardItem = document.querySelectorAll('.board-item');
			boardItemClick();
		},
		error: function(){
			alert('비동기 처리 오류');
		}
	});
}

function getBoardList(boardList){
	let result = ``;
	
	for(let board of boardList){
		result += `
			<div class="board-item">
				<input type="hidden" id="board_id" value="${board.id}">
                <img src="image/${board.board_img}" alt="">
                <div class="board-item-hover">
                    <div class="board-item-like">
                       <i class="fas fa-heart"></i><span>0</span>
                    </div>
                    <div class="board-item-comment">
                       <i class="fas fa-comment"></i><span>0</span>
                    </div>
                </div>
           </div>
		`;
	}	
	return result;
}

function getBoardGroup(boardGroup){
	let boardGroupHtml = ``;
	
	for(let boardList of boardGroup){
		let boardListHtml = getBoardList(boardList);
		
		boardGroupHtml += `
			<div class="board-item-group">
            	${boardListHtml}     
       	 	</div>
		`;
	} 
	return boardGroupHtml;
}

settingBtn.onclick = () => {
    modalContainer[0].classList.toggle('show');

    if (modalContainer[0].classList.contains('show')) {
        body.style.overflow = 'hidden';   // 스크롤이 멈추는 기능?? 넘치는경우에 그 부분을 숨긴다 아닌가 
    }
}

modalContainer[0].onclick = (event) => {
	if(event.target == modalContainer[0]){
		 modalContainer[0].classList.toggle('show');

    	if (!modalContainer[0].classList.contains('show')) {
        	body.style.overflow = 'auto';
    	}
	}  
}

modalContainer[1].onclick = (event) => {
	if(event.target == modalContainer[1]){
		 modalContainer[1].classList.toggle('show');

    	if (!modalContainer[1].classList.contains('show')) {
        	body.style.overflow = 'auto';
    	}
	}
}



modalBtns[0].onclick = () => {
    location.href = '/accounts/password/change';
}

modalBtns[1].onclick = () => {
    location.replace('/logout');
}

modalBtns[2].onclick =() =>{
	
}

/* 큰화면*/
function getBoardItem(board){
	let result = `
		<div class="board-modal-img">
                <img class="board-modal-img-preview" src="/image/${board.boardImg }">
            </div>
            <div class="board-modal-section">
                <div class="board-modal-profile">
                    <div class="profile-img-border">
                        <img src="/image/${board.profile_img }">
                    </div>
                    <div class="username-lb">
                        <a href="/${board.username }">
                            <h1>${board.username }</h1>
                        </a>
                    </div>
                </div>
                <div class="board-modal-contents">
                    <div class="board-modal-content">
                        <div class="profile-img-border">
                            <img src="/image/${board.profile_img }">

                        </div>
                        <pre><div class="username-lb"><a href="/${board.username }"><h1>${board.username }</h1></a></div>${board.boardContent}</pre>
                    </div>
                    <div class="board-modal-comment">

                    </div>
                </div>
                <div class="board-modal-items">
                    <i class="far fa-heart"></i>
                    <i class="far fa-comment"></i>
                    <i class="far fa-paper-plane"></i>
                </div>
                <div class="board-modal-like-info">
                    <span>aaaa님 외 55명이 좋아합니다</span>
                </div>
                <div class="board-modal-comment-input">
                    <input type="text">
                    <button type="button">게시</button>
                </div>
            </div>
	`;
	return result;
	
}



function getBoard(i){
	let boardId = boardItem[i].querySelector('#board_id');
	
	$.ajax({
		type: "get",
		url: `/board/${boardId.value}`,
		dataType: "text",
		success: function(data){
			let board = JSON.parse(data);
			let boardModalBoay = document.querySelector('.board-modal-body');
			boardModalBoay.innerHTML = getBoardItem(board);
			/*getBoardItem(board);*/
			// alert(data);
		},
		error: function(){
			alert('비동기 처리 오류');
		}
	});
}

function boardItemClick(){
	for(let i = 0; i <boardItem.length; i++){
		boardItem[i].onclick = () => {
		 	modalContainer[1].classList.toggle('show');

   		 	if (modalContainer[1].classList.contains('show')) {
        		body.style.overflow = 'hidden';   // 스크롤이 멈추는 기능?? 넘치는경우에 그 부분을 숨긴다 아닌가 
   		 	}
   		 	getBoard(i);
		}
	}
}



