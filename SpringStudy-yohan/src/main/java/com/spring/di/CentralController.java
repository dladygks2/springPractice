package com.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CentralController {
//	RemoteControl 로 구현된 인터페이스를 다 찾고, 객체명이 c1인 애를 주입해준다.?

	// @Autowired
	@Autowired(required = true)
	@Qualifier("c1") // control1 객체를 사용할 수 있도록 해준다는 건가???
	private RemoteControl control1;

	@Autowired(required = true)
	@Qualifier("c2")
	private RemoteControl control2;

	@Autowired(required = true)
	@Qualifier("c3")
	private RemoteControl control3;


	public void onAll() {
		System.out.println("모든 전원을 켭니다.");
		control1.on();
		control2.on();
		control3.on();
	}


	public void offAll() {
		System.out.println("모든 전원을 끕니다.");
		control1.off();
		control2.off();
		control3.off();
	}
	//////////////////////////////////////////////////////////////////////////
	/*
	 *
	 * private RemoteControl control1;
	 * private RemoteControl control2;
	 *
	public CentralController() {


	private RemoteControl control1;
	private RemoteControl control2;

	public CentralController(){
	}

	}


	public CentralController(RemoteControl control1, RemoteControl control2) {
		super();
		this.control1 = control1;
		this.control2 = control2;
	}

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

	public void onAll() {
		System.out.println("모든 전원을 켭니다.");
		control1.on();
		control2.on();
	}


	public void offAll() {
		System.out.println("모든 전원을 끕니다.");
		control1.off();
		control2.off();
	}


	*/


	}

