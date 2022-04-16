package com.spring.di3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("c3")
public class AirConditionerRemoteControl implements RemoteControl{

	@Value("SAMSUNG")
	private String company;

	public AirConditionerRemoteControl() {
		// TODO Auto-generated constructor stub
	}

	public AirConditionerRemoteControl(String company) {
		super();
		this.company = company;
	}

	// alt + shift + 's' --> Generated Getters and Setters
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public void on() {
		System.out.println(company + " AirConditioner의 전원을 켬니다.");

	}

	@Override
	public void off() {
		System.out.println(company + " AirConditioner의 전원을 끕니다.");

	}
}
