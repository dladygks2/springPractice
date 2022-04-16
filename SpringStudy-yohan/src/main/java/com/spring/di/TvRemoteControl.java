package com.spring.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("c2")
public class TvRemoteControl implements RemoteControl {

	@Value("LG")
	private String company;

	// 기본 생성자
	public TvRemoteControl() {
		// TODO Auto-generated constructor stub
	}
	// 생성자
	public TvRemoteControl(String company) {
		super();
		this.company = company;
	}
// 알트 시프트 에스 : getter setter
	public String getCompany() {
		return company;

	}

	public void setCompany(String company) {
		this.company = company;
	}

//	오버라이드
	@Override
	public void on() {
		// TODO Auto-generated method stub
		System.out.println( company + "tv 전원을 켭니다.");

	}
	@Override
	public void off() {
		// TODO Auto-generated method stub
		System.out.println(company + "tv 전원을 끕니다.");
	}
}
