package jdk8demo;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) throws Exception {
		Clock clock = Clock.systemDefaultZone();
		long mills = clock.millis();
		System.out.println(mills);
		System.out.println(System.currentTimeMillis());
		Instant instant = clock.instant();
		Date date = Date.from(instant);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));

		System.out.println(ZoneId.getAvailableZoneIds());
		System.out.println(ZoneId.systemDefault());

		LocalTime localTime = LocalTime.of(10, 10, 10);
		System.out.println(localTime);

		LocalDate localDate = LocalDate.of(2015, Month.JANUARY, 10);
		System.out.println(localDate);

		LocalDateTime ldt = LocalDateTime.of(localDate, localTime);
		ldt.atZone(ZoneId.systemDefault()).toInstant();
		System.out.println(ldt);
	}

}
