package com.spring.di2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CentralController {

	private List<RemoteControl> controls;
	private Scanner in;

	public CentralController() {
		controls = new ArrayList<>();
		in = new Scanner(System.in);
	}

	public void addController() {

		RemoteControl remoteControl; // on(), off() 를 메서드로 사용할 수 있다.


		System.out.println("회사명을 입력해주세요. : ");
		System.out.println("예) SAMSUNG, LG, APPLE, CARRIER, HP");
		String company = in.nextLine(); // company = 회사명..


		while(true) {

		System.out.println("리모컨 종류를 입력해주세요. : ");
		System.out.println("예)입력은 숫자로. 1(TV), 2(에어컨)");
		int remote = in.nextInt();
		in.nextLine();


		if(remote == 1) {
			// TV
			remoteControl = new TvRemoteControl(company);
//			객체가 생성되고나면 break;로 이 함수롤 끝낸다.
			break;
		}else if(remote == 2) {
			 // 에어컨
			remoteControl = new AirConditionerRemoteControl(company);
			break;
		}else {
			System.out.println("지원하지 않는 리모컨 입니다.");
		}
	}
	controls.add(remoteControl); // controls 배열에 위에서 생성된 remoteControl 객체가 추가된다.

	}

	public void onAll() {
		System.out.println("모든 전원을 켭니다.");
		for(RemoteControl control : controls) {
			control.on();
		}
	}

	public void offAll() {
		System.out.println("모든 전원을 끕니다.");
		for(RemoteControl control : controls) {
			control.off();
		}
	}


}
