/**
 *  회원가입
 */
 
 const signupInputs = document.querySelectorAll('.su-input');
 const submitBtn = document.querySelector('.submit');
 
 function isEmpty(str){
	if(typeof str == "undefined" || str == null || str == ''){
		return '사용가능';
	}else{
		return str;
	}
}
 
/*
	validation은 클라이언트 -> 서버 -> 데이터베이스 이렇게 있으면 유효성검사를 
	DB까지 가지않고, 클라이언트에서 서버로 보낼 때에 어느정도
	이 데이터들이 쓸만한지 검사를 시행하는 것을 말함.
	AuthController 에서 @valid 로 확인할 수 있다.
*/

function signupValidMsg(data){
	
	let signupDataObj = JSON.parse(data);
	
	if(signupDataObj.code == 400){
		alert(
			'유효성 검사 오류 \n' +
			'오류코드 : ' + signupDataObj.code + '\n'+
			'오류내용 ================================ \n'+
			'email : ' + isEmpty(signupDataObj.data.email) + '\n' +
			'name : ' + isEmpty(signupDataObj.data.name) + '\n' +
			'username : ' + isEmpty(signupDataObj.data.username) + '\n' +
			'password : ' + isEmpty(signupDataObj.data.password) + '\n'
		);
	}else if(signupDataObj.code == 401){
		alert(
			'아이디 중복 오류 : \n' +
			'오류코드 : ' + signupDataObj.code + '\n' + 
			'오류 내용 --------------------------\n' +
			signupDataObj.data
		);
	}else if(signupDataObj.code == 200){
		alert(signupDataObj.data);
		location.replace('signinPage');
	}
}

function signup(){
	let signupObj = {
		name : signupInputs[0].value,
		username : signupInputs[1].value,
		password : signupInputs[2].value,
		phone : signupInputs[3].value,
		email : signupInputs[4].value,
		blog : signupInputs[5].value
	}
	
	$.ajax({
		type: "post",
		url: "signupPage",
		data: signupObj,
		dataType: "text",
		success : function(data){
			signupValidMsg(data);
		}
	});
	
}

submitBtn.onclick = () =>{
	signup();
}