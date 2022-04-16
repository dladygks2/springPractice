package com.spring.di3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("c2")
public class TvRemoteControl implements RemoteControl{

	@Value("LG")
	private String company;

	public TvRemoteControl() {
		// TODO Auto-generated constructor stub
	}

	// 생성자
	public TvRemoteControl(String company) {
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
		System.out.println(company + " TV의 전원을 켬니다.");

	}

	@Override
	public void off() {
		System.out.println(company + " TV의 전원을 끕니다.");

	}

}
