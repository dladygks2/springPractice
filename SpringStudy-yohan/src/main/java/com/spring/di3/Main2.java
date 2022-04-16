package com.spring.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		// di3 패키지에 만든 DIBeans.xml을 참조하여서
		// context 객체를 만듦
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/di3/DIBeans.xml");

		// context는 DIBeans.xml 파일이다.
		// 그 DIBeans.xml 파일 안에 <bean> 들을 만들어 놓았고, getBean("사용하고자하는 bean의 id의 value를 넣는다.");
		// .getBean을 Ctrl키를 누르고 클릭하면 Object 형태인 것을 볼 수 있다. Object는 최상위 클래스이고,
		// CentralController에 맞게 Down Casting 을 해야한다.
		CentralController centralController = (CentralController)context.getBean("centralControl");
		centralController.onAll();
		System.out.println("------------------");
		centralController.offAll();
	}
}
