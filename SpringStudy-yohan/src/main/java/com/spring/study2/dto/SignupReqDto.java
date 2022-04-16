package com.spring.study2.dto;

import lombok.Data;

@Data
public class SignupReqDto {
	// signup == 회원가입
	// 요청 때의 DTO
	// 클라이언트에서 입력받은 데이터들을 
	// 서버 DB로 넘기기 위해서 사용한다.
	
	// 이 변수명들은 <form> 안의 "name"의 값들과 똑같아야한다.
	private String username;
	private String password;
	private String name;
	private String email;
	
	// DTO는 Getter/Setter 필요하고, 
	// 값을 확인하기 위한 ToString도 필요하다.
	// 그러므로 위에 @Data 를 달아준다.
	
}
