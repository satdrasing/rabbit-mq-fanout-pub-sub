package com.satendra.weatherstation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherStationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherStationApplication.class, args);
	}

}
