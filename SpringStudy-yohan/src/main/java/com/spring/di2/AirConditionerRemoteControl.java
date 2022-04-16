package com.spring.di2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("c3")
public class AirConditionerRemoteControl implements RemoteControl {

	@Value("SAMSUNG")
	private String company;


	// 생성자
	public AirConditionerRemoteControl() {
		// TODO Auto-generated constructor stub
	}

	public AirConditionerRemoteControl(String company) {
	super();
	this.company = company;
}
//	getter, setter
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		System.out.println(company + "에어컨의 전원을 켭니다.");

	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		System.out.println(company + "에어컨의 전원을 끕니다.");
	}
}
