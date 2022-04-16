package com.spring.di3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		// addController 메서드와 onAll offAll 메서드를 사용할 수 있겠다.
		// 변수 controller와 in 도 사용할 수 있겠다.
		CentralController2 centralController = new CentralController2();

		while (true) {

			System.out.println("1. 리모컨 추가");
			System.out.println("2. 모든 전원 켜기");
			System.out.println("3. 모든 전원 끄기");
			System.out.println("0. 프로그램 종료");

			// Scanner로 받은 입력은 String이므로 in.nextInt()를 사용해서
			// int 형으로 변환해주어야한다.
			int select = in.nextInt();
			in.nextLine();

			if (select == 1) { // 리모컨 추가
				// centralController를 위에 선언을 해놨네
				centralController.addController();
			} else if (select == 2) { // 모든 전원 켜기
				centralController.onAll();
			} else if (select == 3) { // 모든 전원 끄기
				centralController.offAll();
			} else if (select == 0) { // 프로그램 종료
				System.out.println("프로그램 종료중.....");
				break;
			} else {
				System.out.println("입력을 다시 해주세요");
			}

		}
	}

}
