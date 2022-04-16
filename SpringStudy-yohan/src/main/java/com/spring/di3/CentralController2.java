package com.spring.di3;

import java.util.ArrayList;
import java.util.Scanner;

public class CentralController2 {

	// TV 에어컨 둘 다 중앙제어를 할 것
	// TvRemoteControl과 AirConditionerRemoteControl 둘 다 RemoteController 클래스를
	// implements를 했으니 다형성으로 같이 묶어서 ArrayList에 담을 수 있다.
	private ArrayList<RemoteControl> controls;

	private Scanner in;

	// 처음 CentralController를 생성자로 불러내면 controls 객체가 생성되는 것
	public CentralController2() {
		controls = new ArrayList<>();
		in = new Scanner(System.in);
	}

	public void addController() {

		RemoteControl remoteControl;


		System.out.println("회사명을 입력해주세요.");
		String company = in.nextLine();

		while (true) { // break를 만나기 전까지는 계속 작동하겠네

			System.out.println("리모컨의 종류를 입력해주세요. '1'(TV)과 '2'(에어컨) 중에서 선택해주세요.");
			int remote = in.nextInt();
			in.nextLine();


			if (remote == 1) {
				// TV
				remoteControl = new TvRemoteControl(company);
				break;
			} else if (remote == 2) {
				// 에어컨
				remoteControl = new AirConditionerRemoteControl(company);
				break;
			} else {
				System.out.println("입력을 다시 확인해주세요.");
			}

		}

		controls.add(remoteControl);

	}

	public void onAll() {
		System.out.println("모든 전원을 켭니다.");
		for (RemoteControl remoteControl : controls) {
			// controls에 담긴 remoteControl 객체들을 하나씩 꺼낼 것이다. ---- foreach 문
			remoteControl.on();
		}
	}
	public void offAll() {
		System.out.println("모든 전원을 끕니다.");
		for (RemoteControl remoteControl : controls) {
			remoteControl.off();
		}
	}

}
