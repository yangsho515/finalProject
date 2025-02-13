package com.example.spring.lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FooTest {
	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext(
				 new String[] {"com/example/spring/lab/beans.xml"});
		 
		 Foo foo = (Foo)context.getBean("foo");
		 foo.setName("홍길동");
		 System.out.println(foo);

		 Foo fool = (Foo)context.getBean("foo");
		 System.out.println(foo == fool);
				 
				 
				 
	}
}
