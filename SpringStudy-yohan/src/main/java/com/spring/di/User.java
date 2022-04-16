package com.spring.di;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor

//////////////////////
@Getter
@Setter
@EqualsAndHashCode
@ToString
//////////////////////
@Data   // 얘하나가 위의 @Getter
//@Setter
//@EqualsAndHashCode
//@ToString
// 이 4개를 포함한다.

public class User {
	private String username;
	private String paasword;
	private String name;
	private String email;

}