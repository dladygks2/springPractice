package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {

//		IoC에 class를 넣어두면 자동으로 조립되어서 나온다.
//		xml파일이 그 역할을 하는 것이다. xml에서 자동으로 만들어주는 것이다.
//		그걸 가져올때 밑에 context 객체로 가져오는 것이다.
//		작성한 클래스를 담아둘 수 있는 곳을 IoC라고 한다.
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/di/DiBeans.xml");
		CentralController centralController = (CentralController)context.getBean("centralControl");
		System.out.println("------ 전원 on -----");
		centralController.onAll();
		System.out.println("------ 전원 off -----");
		centralController.offAll();

//		DI는 XML로 하는 방법과 어노테이션으로 하는 방법이 있다.

	}

}
