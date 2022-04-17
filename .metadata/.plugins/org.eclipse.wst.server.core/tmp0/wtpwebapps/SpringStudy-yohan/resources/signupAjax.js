const inputNames = document.querySelectorAll('.ip-names');
/*const username = document.querySelector('#username');*/
const idCheck = document.querySelector('#id-check');
/*const signupValues = document.querySelectorAll('.signup-ip');*/
const signupInputs = document.querySelectorAll('.signup-ip');
/*const idCheckFlag = document.querySelector('#id-check-flag')*/;
const signupForm = document.querySelector('form');
/*const submitFlag = document.querySelector('#submit-flag');*/
const signupBtn = document.querySelector('#signup-btn');

var idCheckFlag = false;

/*if(idCheckFlag.value == 'true'){
	alert('사용 가능한 아이디 입니다.');
}else if(idCheckFlag.value == 'false'){
	alert('이미 존재하는 아이디 입니다.');
}*/



 	/*idCheck.onclick = () => {
 		alert('아이디 : ' + username.value);
 		// var 대신 지역변수로 let을 사용해라
 		for(let i = 0 ; i < signupValues.length; i++){
 			alert(signupValues[i].value);
 		}
 	}*/
 	
 	
 // 중복확인하는 부분
 function usernameCheck(){
	let signupObj = {
		username: signupInputs[0].value,
		password: signupInputs[1].value,
		name : signupInputs[2].value,
		email : signupInputs[3].value,
	};
	
	alert(signupObj.email);
	/* ajax 사용법 */
	$.ajax({
		type : "get", // 메서드: POST GET PUT DELETE
		url : "/study/signup/username-check",  // 요청 보낼 주소
		data : signupObj, // 전달할 데이터
		dataType : "text", // 전달 받을 데이터의 타입. Object 타입은 전달 받을 때 JSON 타입으로 받는다. JSON타입은 결국 String형태므로 text로
		success: function(data){  // signupRespDto를 JSON 형태로 전달 받는다.
			let signupResponseObj = JSON.parse(data);
			
			idCheckFlag = signupResponseObj.idCheckFlag;
			alert("data : " + data);
			if(idCheckFlag == true){
			alert('가입 가능한 아이디입니다.');
			}else{
				alert('이미 존재하는 아이디입니다.');
			}
		},
		error:function(){
			alert('비동기 처리 오류');
		}
	});
	
}
 	
idCheck.onclick = () => {
 	let checkFlag = isEmpty(signupInputs[0], inputNames[0].textContent);
 	if(checkFlag != 0) return;
 	usernameCheck();
 }
 
 function isEmpty(signupInput, inputName){
	
	let flag = 0;
	
	if(signupInput.value.length == 0){
		flag = 1;
		alert(inputName + ' 을(를) 입력해 주세요.');
		
	}
	return flag;
}
 
 signupBtn.onclick = () => { // 가입하기 버튼을 누른것
	/*let inputNames = ['아이디','비밀번호','이름','이메일'];*/
	let checkFlag = 0;
	
	for(let i = 0; i < signupInputs.length; i++){
		checkFlag = isEmpty(signupInputs[i], inputNames[i].textContent);
		if(checkFlag != 0) return;
	}// 공백체크
	if(idCheckFlag != 1){
		alert('아이디 중복확인을 해주세요.');
		return;	
	}//중복확인
	
	/*  위에꺼랑 기능은 같을 거 같다*/ 
	
   /* checkFlag = isEmpty(signupInputs[0], '아이디');
    if(checkFlag != 0) return;
    if(idCheckFlag.value != 'true'){
		alert('아이디 중복확인을 해주세요.');
		return;	
	}	
    checkFlag = isEmpty(signupInputs[1], '비밀번호');	
    if(checkFlag != 0) return;
    checkFlag = isEmpty(signupInputs[2], '이름');
    if(checkFlag != 0) return;	
    checkFlag = isEmpty(signupInputs[3], '이메일');
    if(checkFlag != 0) return;	*/

	/* 
		else if 가 아니니까 순서대로 조건문을 확인한다. 
		다 통과할 수 있으면 밑의 signupForm.submit(); 이 실행되는것이다.
	*/    
	signupForm.submit();

};
 	
 	
 	/* 
 		마이 바티스
 		SQL 저장 프로시저 , 퍼시스턴스 프레임워크이다.
 		JDBC로 처리하는 상당부분의 코드와 파라미터(매개변수) 설정 및 결과 매핑을 대신해준다.
 		
 		java에 ibatis가 있는데 이것을 개선시킨것이
 		mybatis 이다. DB업무의 80%는 이걸 쓴다.
 		
 	*/
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 /*	
 	signupValues[0].onblur = () => {		
 		const testText = document.querySelector('.test-text');
		testText.style.color ='red';
		// testText.innerHTML = '<a href="#">테스트</a>';
		// 위에 한줄이 밑에 꺼다...
		const aTag = document.createElement('a');
		const href = document.createAttribute('href');
		aTag.setAttributeNode(href);
		aTag.href = '#';
		
		const text = document.createTextNode('테스트'); // 2줄 위에꺼랑 같다.
		aTag.appendChild(text);
		testText.appendChild(aTag);
		  
 	}
 	
*/	
 	
	 

 