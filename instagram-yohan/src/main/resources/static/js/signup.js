/*
	회원가입
*/
/* 
	signup.jsp에서 
	class = su-input 로 선언된 애들을 사용한다. 얘들 여러개 있는데 배열로 받을 거란다.
	class = su-submit-btn 으로 선언된 애들은 일단 누르면 제출이 되야겠네. 
	그리고 순서에 따라 하나는 facebook 로그인 할건지
	아이디 비번으로 로그인 할건지 들어가는게 다르게 해야하겠네
	
	자바스크립트를 적용하려면 
	jsp 파일에 들어가서 제일 밑에 
	 <script src="/js/signup.js"></script>
</body>

	body 태그 바로위에다가 선언을 해주어야한다.
	
	얘들 정보받는 거를 AuthController.java에서 signup 메서드에서 받는거 같은데???
	근데 얘는 .js이니까 그냥 .jsp랑 직접 연결된다고 봐야하는 건가
	
*/

/* 변수의 선언 */
const signupInputs = document.querySelectorAll('.su-input');
/* signup.jsp에서 0)email, 1) name, 2) username, 3) password */


const submitBtns = document.querySelectorAll('.su-submit-btn'); 
/* signup.jsp에서 0) facebook으로 로그인 버튼 1) 가입 버튼 */
 
 
/* 함수의 선언 */
function isEmpty(str){  // 중복확인하는 함수인가?
	if(typeof str == "undefined"|| str == null || str == ''){
		/* 중복확인을 했을 때, 위의 값들이 나온거는 중복되는 값이 없다는 뜻이다.*/
		return '사용가능';
	}else {
		return str;
	}
}

/* validation은 클라이언트 -> 서버 -> 데이터베이스 이렇게 있으면 유효성검사를 DB까지 가지않고 클라이언트에서 서버로 보낼때에 어느정도
이 데이터들이 쓸만한지 검사를 시행하는거 AuthContoller에서 @Valid 로 확인가능하다.  */
function signupValidMsg(data){
	
	let signupDataObj = JSON.parse(data); // 얘는 뭘까?
	
	/* 얘들 400, 401, 200 은 AuthServiceImpl에서 설정하는 거다. signupRespDto.setCode로 */
	if(signupDataObj.code == 400){
		alert(
			'유형성 검사 오류.\n' + 
			'오류코드 : ' + signupDataObj.code + '\n' + 
			'오류 내용 -------------------------------\n' + 
			/* 위에 isEmpty 함수를 선언했다.*/
			'email : ' + isEmpty(signupDataObj.data.email) + '\n' +
			'name : ' + isEmpty(signupDataObj.data.name) + '\n' +
			'username : ' + isEmpty(signupDataObj.data.username) + '\n' +
			'password : ' + isEmpty(signupDataObj.data.password)
		);
	}else if(signupDataObj.code == 401){
		alert(
			'아이디 중복 오류.\n' + 
			'오류코드 : ' + signupDataObj.code + '\n' + 
			'오류 내용 ----------------\n' + 
			signupDataObj.data
		);
	}else if(signupDataObj.code == 200){  // 로그인 성공이니 화면을 signin 으로 보내주는 것만 하면되네
		alert(signupDataObj.data);
		location.replace('/auth/signin'); // 이 주소로 보내라.
	}
	
}

/* 
	signup() 요청이 올때 시행할 함수 
	밑의 
	submitBtns[1].onclick 시에 실행될 함수로 사용된다.
*/

/* 함수의 선언 */
function signup(){
	let signupObj = {
		/* signup.jsp 에서 순서대로 받는 듯.*/
		email: signupInputs[0].value,
		name: signupInputs[1].value ,
		username: signupInputs[2].value ,
		password: signupInputs[3].value 
		/* 
			signupObj라는 객체를 생성하고 
			거기에 email, name, username, password 를 
			signupInputs라는 배열의 각 key값의 value로 저장할 것이다.
		 */
	}
	
	
	
	/* 
		ajax를 쓰기 위해서 signup.jsp에 jQuery를 추가해준다.
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		
	 */
	 /* 얘들을 어디서 확인할 수 있을까?*/
	$.ajax({
		type: "post",		/**@RestController로 만들어 놨다는데... 회원가입은 post요청을 날릴거라는데... AuthController.java에 설정됨*/
		url: "/auth/signup",  /* signup.jsp에 있는 애들을? 날릴것이라는 뜻??? */
		data: signupObj,		/* 요청시에 전달받을 데이터 .위의 signup() 을 실행했을때 생성되는 객체의 속성을 사용하겠다.?. 저 위에 let signupObj가 선언되어있다. submit 버튼 누르면 실행되네*/
		dataType: "text",		/** 응답시에 전달할 데이터형식. JSON 데이터는 텍스트형식이다. */
		success : function(data){
			signupValidMsg(data);    /* validation 체크는 signupReqDto에서? AuthController에서? */
									 /* 유효성검사를 하는 함수 위에 선언되어있다. 일단 값이 넘어오는데 성공했으면 그 값들이 
									 	제대로 넘어왔는지 아닌지 확인하는 signupValidMsg(data) 함수로 이동한다. */
		},
		error: function(){
			alert('비동기 처리 오류');	/* 값이 넘어오지도 않았다면 얘한테 가는듯. */
		}
	});
}

/* 함수의 실행 */
submitBtns[1].onclick = () => {
		signup(); /** 위에 선언된 signup()이 실행 */
		/* 
		signup.jsp에서 0번은 facebook으로 로그인하는거고, 
		1번은 이메일, 이름, 아이디, 비번 입력해서 가입하는거다.
		*/
}

/* 
	js를 적용시키기 위해서는 사용할 jsp에 제일 밑에  
	
    <script src="/js/signup.js"></script>
    이거를 </body> 위에 해줘야한다.	
*/
