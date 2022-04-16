package com.spring.di2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("c2")
public class TvRemoteControl implements RemoteControl {

	@Value("LG")
	private String company;


//	생성자
	public TvRemoteControl() {
		// TODO Auto-generated constructor stub
	}

	public TvRemoteControl(String company) {
		super();
		this.company = company;
	}
	// getter, setter
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		System.out.println(company + "TV의 전원을 켭니다.");

	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		System.out.println(company + "TV의 전원을 끕니다.");
	}

}
