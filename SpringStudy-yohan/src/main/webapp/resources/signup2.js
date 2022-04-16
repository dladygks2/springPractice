/* const username = document.getelementbyid('username'); */
 	
 	const username = document.querySelector('#username');
 	
 	const idCheck = document.querySelector('#id-check');
 	/* const signupValues = document.querySelector('.signup-ip'); */
 	const signupValues = document.querySelectorAll('.signup-ip');
 	
 	idCheck.onclick = () => {
 		alert('아이디 : ' + username.value);
 		
 		for(let i = 0 ; i < signupValues.length; i++){
 			alert(signupValues[i].value)
 		}
 		/* alert('?????? : ' + signupValues.value); */
 	}
 	
 // focus에서 벗어나면 실행한다 = onblur
 	signupValues[0].onblur = () => {		
 		/* alert('온블러 아이디 : ' + signupValues[0].value);  */
 		
 		/* signupValues[2].value = '김준일'; */
 		
 		const testText = documnet.querySelector('.test-text');
 		//testText.style.display = 'none';
		testText.style.color ='red';
 	}
 	
 	
 	
	/*
		- DOM(document 최상단)
			
		- html에서 body 제일 아래에 script를 넣어야 하구나 : 자스가 제일 위에 있으면 태그가 밑에 있는 경우에 해석순서에서 
		인식못한 것을 불러내는 경우가 있다.
		
		- alert
		- confirm
		- prompt
		
		- write() : 문자 태그를 추가해서 적어준다.
		- console.log() :
			
		- 변수
		var = 변수, 
		let  = 변수, 
		const = 상수
 		
		- 숫자형(number)
		
		- 함수 선언 
		function 함수명(){
			명령내용
		}
		
		- 호이스팅(hoisting) : 변수를 뒤에서 선언하지만, 마치 앞에서 미리...
		
		let을 쓰는 이유 : 
			
			var 은 전역변수로만 사용한다. 똑같은 변수명으로 선언할 수 있다.
			let 은 전역변수로 사용안된다. 메서드 안에서만 사용가능. 위의 똑같은 변수명을 사용하는 것을 막기위해서 생김
			const 는 상수. 재선언, 재할당 불가. 객체를 생성할 때 사용한다.
			
		- return
			
		- 익명 함수 : 함수명이 없는 경우??? 한번만 사용할 때는 이렇게 사용한다.
				
		- 화살표 함수 : 
			1) const hi =function(){
			return alert("안녕하세요");
		} ------- 얘가 익명함수이다.
		
		 	2) const hi = (매개변수 넣는곳) => {return alert("안녕하세요")};
		
			3) const hi = () => alert("안녕하세요");
			
			
		- 이벤트와 이벤트 처리기
		
		- DOM을 이용한 이벤트 처리기
	
			
	*/