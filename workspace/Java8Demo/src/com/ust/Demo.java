package com.ust;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

public class Demo {

	public static void main(String[] args) {
		//Current timestamp
				Instant timestamp = Instant.now();
				
				
				System.out.println(LocalDate.now());
				System.out.println(LocalTime.now());
				
				//Instant of previous timestamp
				Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
				
				System.out.println("Current Timestamp: "+timestamp);
				System.out.println("Specific Time from timestamp: "+specificTime);

	}

}
