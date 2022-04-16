package com.spring.di2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class CentralController2 {

	@Autowired(required = true)
	@Qualifier("c2")
	private RemoteControl control1;


	@Autowired(required = true)
	@Qualifier("c3")
	private RemoteControl control2;

	/*
	public CentralController2() {
		// TODO Auto-generated constructor stub
	}


//	얘는 shift + alt + s 로  generate constructor usingfield에서 사용한다.
	// 2개의 객체를 받는다. 2개의 value를 받는것이 아니다.
	public CentralController2(RemoteControl control1, RemoteControl control2) {
		super();
		this.control1 = control1;
		this.control2 = control2;
	}

// 주입이라고 하는 것은 control1과 control2에 매개변수를 넘겨주어야한다.
	//

	public RemoteControl getControl1() {
		return control1;
	}


	public void setControl1(RemoteControl control1) {
		this.control1 = control1;
	}


	public RemoteControl getControl2() {
		return control2;
	}


	public void setControl2(RemoteControl control2) {
		this.control2 = control2;
	}
*/
	public void onAll() {
		System.out.println("모든 전원을 켭니다.");
		control1.on();
		control2.on();
		System.out.println("-------------");

	}

	public void offAll() {
		System.out.println("모든 전원을 끕니다.");
		control1.off();
		control2.off();
		System.out.println("-------------");
	}
}
