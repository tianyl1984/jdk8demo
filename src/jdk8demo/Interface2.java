package jdk8demo;

public interface Interface2 {

	default void m2() {
		System.out.println("Interface2 default method:" + this.getClass().getName());
	}

	static void m3() {
		System.out.println("class is " + Interface2.class.getName());
	}

}
