package jdk8demo;

public class MethodRefer {

	// http://ifeve.com/java-8-features-tutorial/

	public static void main(String[] args) {
		Car car = Car.create(Car::new);
		System.out.println(car);

	}

}
