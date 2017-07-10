package com.cog;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {

	@Test
	public void test() {
//		B b = new B();
//		A a = new A(b);
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		A a = context.getBean(A.class);
		int result = a.execute();

		assertSame(2, result);
	}

}
