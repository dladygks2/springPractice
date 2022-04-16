/**
 * 
 */
const idCheck = document.querySelector('#id-check'); // 위에 id 값과 연동. #이 id를 의미
const username = document.querySelector('#username'); // 위와 동일한 것이다.
/* 위의 입력된 값들을 배열로 받아올것이다. 해당클래스를 가지고 있는 것을 배열로 담아줌 */
const signupInputs = document.querySelectorAll('.signup-ip');
const idCheckFlag = document.querySelector('#id-check-flag');
const signupForm = document.querySelector('form');

// 중복확인으로 넘길지, 회원가입으로 넘길지
const submitFlag = document.querySelector('#submit-flag');

// 
const signupBtn = document.querySelector('#signup-btn');

document.onload = () => {
	// onload는 페이지가 열렸을 때 동작한다는 의미
	if (idCheckFlag.value == true) {
		alert('사용 가능한 아이디');
	} else if (idCheckFlag.value == false) {
		alert('이미 존재하는 아이디');
	}
}


idCheck.onclick = () => {
	/* alert('아이디 : ' + username.value);
	alert('.signup-ip : ' + signupValues.value);

	for (let i = 0; i < signupValues.length; i++) {
		alert(signupValues[i].value);
	} */

	if (signupInputs[0].value.length == 0) {
		alert('아이디를 입력해주세요');
	} else {
		submitFlag.value = 1;
		signupForm.submit(); // 이렇게 하면 .jsp에서 form의 button과 같다.
		// button 기본이 submit이다.
	}

};

function isEmpty(signupInput, inputName) {

	let flag = 0;

	if (signupInput.value.length == 0) {
		flag = 1;
		alert(inputName + '을(를) 입력해 주세요.');
	}
	return flag;
};

signupBtn.onclick = () => {
	let checkFlag = 0;
	// 위의 isEmpty 메서드에 의해서 값이 없다면 checkFlag = 1 이다.
	checkFlag = isEmpty(signupInputs[0], '아이디');
	if (checkFlag != 0) return;
	if (idCheckFlag.value != 'true') {
		alert('아이디 중복확인을 해주세요.');
		return;
	} 

	checkFlag = isEmpty(signupInputs[1], '비밀번호');
	if (checkFlag != 0) return;
	checkFlag = isEmpty(signupInputs[2], '이름');
	if (checkFlag != 0) return;
	checkFlag = isEmpty(signupInputs[3], '이메일');
	if (checkFlag != 0) return;

	signupForm.submit();

};

/* onblur 테스트
signupValues[0].onblur = () => {

	const testText = document.querySelector('.test-text');
	testText.style.colr = 'red';

	alert('온블러 테스트 signupValues[0] : ' + signupValues[0].value);

	signupValues[2].value = '김준일'; // onblur 가 일어났을 때 값을 넣어주는 것이 가능하다.

	// HTML 파일에서 보면 testText는 <div> 태그에 class='test-text'로 선언되어 있을 것이다.
	// 그 <div> 태그 안에다가 또 태그를 넣어주는 것이 .innerHTML 이다.
	testText.innerHTML = '<a href="#">테스트</a>';
}
*/