/**
 *  비밀번호 변경
 */
 
 const passwordSubmitBtn = document.querySelector('.password-submit-btn');
 const prePasswordInput = document.querySelector('#pre-password-ip');
 const newPasswordInput = document.querySelector('#new-password-ip');
 const newRePasswordInput = document.querySelector('#new-repassword-ip');
 
 function passwordSubmit(){
	$.ajax({
		type: 'put',
		url: "/accounts/password/change",
		data: {
			"prePassword": prePasswordInput.value,
			"newPassword": newPasswordInput.value
		},
		dataType: "text",
		success: function(data){
			let passwordRespObj = JSON.parse(data);
			alert(passwordRespObj.message);
			 
			if(passwordRespObj.code == 200){
				alert('다시 로그인 하세요.');
				location.replace('/logout');
			}
			 
		},
		error: function(data){
			alert('비동기 처리 오류');
		}
	});
}
 
 passwordSubmitBtn.onclick =() =>{
	if(newPasswordInput.value != newPasswordInput.value){
		alert('새 비밀번호가 일치하지 않습니다.');
		return;
	}
	passwordSubmit(); // if가 아닐 경우에 실행될것이다.
}