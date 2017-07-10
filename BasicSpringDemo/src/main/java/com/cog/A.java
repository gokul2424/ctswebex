package com.cog;

public class A {
	
	B b;
	C c;
	
	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public A(B b){
		this.b = b;
//		b = new B();
	}
	
	public int execute(){
		return b.execute() + c.execute();
	}

}
