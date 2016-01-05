package jdk8demo;

public class InterfaceDemo implements Interface1, Interface2 {

	@Override
	public void m1() {
		System.out.println("this is in " + this.getClass().getName());
	}

	public static void main(String[] args) {
		InterfaceDemo demo = new InterfaceDemo();
		demo.m1();
		demo.m2();
		Interface2.m3();
	}

}
