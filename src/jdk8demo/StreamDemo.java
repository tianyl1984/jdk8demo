package jdk8demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class StreamDemo {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("a1", "a2", "bbb", "ddd", "aaa");
		System.out.println("-------filter--------");
		strList.stream().filter((s) -> s.startsWith("a")).forEach((s) -> System.out.println(s));
		System.out.println("-------filter2-------");
		strList.stream().filter((s) -> s.startsWith("b")).forEach(System.out::println);
		System.out.println("-------map--------");
		strList.stream().map(String::toUpperCase).forEach(System.out::println);
		System.out.println("-------reduce------");
		Optional<String> reduced = strList.stream().reduce((s1, s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println);
		reduced.ifPresent((s1) -> {
			System.out.println("reduced:" + s1);
		});
		System.out.println("--------anyMatch-------");
		boolean b1 = strList.stream().anyMatch((s) -> s.startsWith("a"));
		System.out.println(b1);
		System.out.println("--------allMatch-------");
		b1 = strList.stream().allMatch((s) -> s.startsWith("a"));
		System.out.println(b1);

		// 并行stream
		System.out.println("---------stream vs parallelStream----------");
		List<String> uuids = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			uuids.add(UUID.randomUUID().toString());
		}
		long t1 = System.nanoTime();
		uuids.stream().sorted().count();
		long t2 = System.nanoTime();
		System.out.println(String.format("stream:%d", TimeUnit.NANOSECONDS.toMillis(t2 - t1)));
		long t3 = System.nanoTime();
		uuids.parallelStream().sorted().count();
		long t4 = System.nanoTime();
		System.out.println(String.format("parallelStream:%d", TimeUnit.NANOSECONDS.toMillis(t4 - t3)));

		// map
		System.out.println("---------Map-------");
		Map<String, String> map = new HashMap<>();
		map.put("one", "AAAAAAAAAA");
		map.put("two", "BBBBBBBBBB");
		map.forEach((key, val) -> {
			System.out.println(key + ":" + val);
		});

	}

}
