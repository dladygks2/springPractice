/**
 *  프로필 수정
 */
 
 /* 입력되어있는? 아이디*/
const principalUsername = document.querySelector('#principal-username');
 
const profileImg = document.querySelector('#profile-img');
const imgFile = document.querySelector('#file');
const profileImgChangeBtn = document.querySelector('.profile-img-change-btn');

const form = document.querySelector('form');
const submitBtn = document.querySelector('.edit-submit-btn'); 

const profilelabel = document.querySelectorAll('.edit-lb');
const profileInput = document.querySelectorAll('.profile-ip');
/*
const profileInput = .profile-ip
0 : 이름
1 : 사용자이름
2 : 웹사이트
3 : 소개
4 : 이메일
5 : 전화번호
6 : 성별
*/

// 이걸 기본값으로 'true'를 주는 이유가 뭐지
var usernameCheckResult = 'true';

var imgFileChangeFlag = false;

var profileImgFile = '';

imgFile.style.display = 'none';		

profileImgChangeBtn.onclick = () => {
	imgFile.click();
} 

/* 이미지 바꿔주는 역할 */
imgFile.onchange = () => {
	let reader = new FileReader();
	
	reader.onload = (e) => {
		imgFileChangeFlag = true;
		profileImgFile =  e.target.result;
		profileImg.src = profileImgFile; // url을 가지고온다
	}
	
	reader.readAsDataURL(imgFile.files[0]); // 이미지 파일의 첫번째파일
}

function usernameCheck(username){
	// jsp에서 id="username-ip"으로 지정된애들 js에서 usernameInput으로 사용하겠다.
	/* 아이디 받는 곳이란건가*/
	const usernameInput = document.querySelector('#username-ip');
	
	$.ajax({
		type: "get",
		url: "/accounts/username-check", 
		// 이거 위치어디지 : AccountsController에서 
		/*
			@GetMapping("/accounts/username-check")
			public boolean usernameCheck(@RequestParam String username) {
			return accountsService.usernameCheck(username);
			}
		*/
		
		/*JSON 문법(https://velog.io/@surim014/JSON%EC%9D%B4%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80)*/
		data: {
			"username" : username 
		},
		dataType:"text",
		async: false,
		success: function(data){
			usernameCheckResult = data; 
		},
		error: function(){
			alert('비동기 처리 오류.....');
		}
	});
}

function inputIsEmpty(str, lb){
	let result = false;
	
	if(typeof(str) == undefined || str == null || str =='' ){
		alert(lb +'은(는) 빈값일 수 없습니다. ')
		result = true;
	}
	return result;  // result는 뭐 어쩌란거지
}

// 이미지가 바꼈을 때 실행될 메서드
function multipartSubmit(){
	let formData = new FormData(form); // 보통 파일 전달에서 사용.
	
	$.ajax({
		type: "put",
		url: "/accounts/edit",
		data: formData,
		dataType: "text",
		// formData객체를 전달할 때에는 이 밑에 3개는 필수로 필요하다.
		enctype: "multipart/form-data",  // 이게 있어야
		processData: false,
		contentType: false,
		seccess : function(data){
			if(data == 'true'){
				alert('회원정보 수정 성공 - 프로필이미지');
				const navProfileImg = document.querySelector('#nav-profile-img');
				navProfileImg.src = profileImgFile;
			}
		},
		error: function(){
			alert('비동기 처리 오류');
		}
	});
}

function editSubmit(){
	
	$.ajax({
		type : "put",
		url : "/accounts/edit",
		data: {
			"name": profileInput[0].value,
			"username" : profileInput[1].value,
			"website" : profileInput[2].value,
			"introduction" : profileInput[3].value,
			"email" : profileInput[4].value,
			"phone" : profileInput[5].value,
			"gender" : profileInput[6].value
		},
		dataType: "text", 
		success: function(data){
			if(data == 'true'){
				alert('회원정보 수정 성공');
				principalUsername.textContent = profileInput[1].value;
			}
		},
		error : function(){
			alert('비동기 처리 오류.');
		}
	})
}
/* submit 버튼을 눌렀을 때의 메서드*/
submitBtn.onclick = () => {
	
	
	let username = profileInput[1].value;
	let pUsername = principalUsername.textContent;
 
	
	if(inputIsEmpty(profileInput[0].value, profilelabel[0].textContent)){
		return;
	}
	if(inputIsEmpty(profileInput[1].value, profilelabel[1].textContent)){
		return;
	}
	if(inputIsEmpty(profileInput[4].value, profilelabel[4].textContent)){
		return;
	}
	
	
	if(username != pUsername){
		usernameCheckResult = false; // username이 바뀌었다는 의미
		usernameCheck(username); // username이 있으면 'false', 없으면 'true'란다.
		// 'true'가 되어야 그 username이 사용가능한 username이라는 의미
	}
	
	if(usernameCheckResult == 'true'){ // 응답 데이터 타입을 위에서 text로 해서
		// 서브밋 실행
		if(imgFileChangeFlag == true){
			// 파일업로드가 필요하다.
			multipartSubmit();
		
		}else{
			// 파일업로드가 필요없다.
			editSubmit();
			
		}
	}else{
		alert(username + "은(는) 이미 사용중인 사용자 이름입니다.");
	}
	
}  
