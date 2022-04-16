package com.spring.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("c3")
public class AirConditionRemoteControl implements RemoteControl {

	@Value("SAMSUNG")
	private String company;

	public AirConditionRemoteControl() {
		// TODO Auto-generated constructor stub
	}

	public AirConditionRemoteControl(String company) {
		super();
		this.company = company;
	}

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
		System.out.println(company + "에어컨 전원을 끕니다.");
	}
}
