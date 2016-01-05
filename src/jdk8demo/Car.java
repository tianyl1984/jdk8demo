package jdk8demo;

import java.util.function.Supplier;

public class Car {

	public static Car create(Supplier<Car> supplier) {
		System.out.println("create car");
		return supplier.get();
	}

	public static void collide(Car car) {
		System.out.println("collide:" + car);
	}

}
