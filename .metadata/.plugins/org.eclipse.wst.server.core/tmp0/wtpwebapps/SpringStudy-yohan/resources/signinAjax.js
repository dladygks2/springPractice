const signinInputs = document.querySelectorAll('.signin-ips');
const signinBtn = document.querySelector('.signin-btn');
const inputNames = document.querySelectorAll('.ip-names');

function signin(){
	let signinObj = {
		username: signinInputs[0].value, 
		password: signinInputs[1].value 
	}
	
	$.ajax({
		type: "post",
		url: "/study/signin/ajax",
		data: JSON.stringify(signinObj), // json 형식으로 만들어줌
		contentType: "application/json;charset=utf=8", // json 데이터 전달하는 방식
		dataType: "text", // 전달받을 때의 타입
		success: function(data){
			let signinRespObj = JSON.parse(data);
			let signinFlag = signinRespObj.signinFlag;
			if(signinFlag == 0){
				alert('존재하지 않는 아이디입니다.');
			}else if(signinFlag == 1){
				alert('비밀번호를 틀렸습니다.');
			}else{
				alert('로그인 성공!!!!');
				location.replace('/study/index3');  /*얘는 뒤로가기 누르면 입력한 정보들 안남아있다. 얘는 인덱스를 아예 새롭게 여는것. 그래서 원래는 뒤로가기가 안된다.*/
				/*location.href = '/study/index';*/   /* 얘는 뒤로가기 눌러도 기존에 입력정보가 남아있다.*/
			}
		},
		error: function(){
			alert('비동기 처리 오류입니다.......');
		}
	}); 
};

function isEmpty(signupInput, inputName){
	
	let flag = 0;
	
	if(signupInput.value.length == 0){
		flag = 1;
		alert(inputName + ' 을(를) 입력해 주세요.'); 
	}
	return flag;
};

signinBtn.onclick = () => {
	for( let i = 0 ; i < signinInputs.length ; i++){
		let emptyCheck = isEmpty(signinInputs[i], inputNames[i].textContent);
		if(emptyCheck != 0) return;
	}	
	signin();
};
