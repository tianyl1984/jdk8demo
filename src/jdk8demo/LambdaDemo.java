package jdk8demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("asdf", "xcvd", "sdfsdf");
		Collections.sort(strList, (String a, String b) -> {
			return b.compareTo(a);
		});

		Collections.sort(strList, (String a, String b) -> b.compareTo(a));

		Collections.sort(strList, (a, b) -> b.compareTo(a));

		System.out.println(strList);

		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		int result = converter.convent("11");
		System.out.println(result);

		Converter<Integer, String> converter2 = Integer::toHexString;
		System.out.println(converter2.convent(123456));

		// converter = Integer::valueOf;
		// System.out.println(converter.convent("sdaf"));
		int num = 10;// 自动final
		Converter<Integer, String> converter3 = (from) -> {
			from += num;
			return "" + Integer.valueOf(from);
		};
		System.out.println(converter3.convent(10));

		Runnable r = () -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println("run....");
		};
		new Thread(r).start();
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println("run2....");
		}).start();

	}

}
