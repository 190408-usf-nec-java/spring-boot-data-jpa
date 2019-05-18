package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Weather;
import com.revature.services.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	WeatherService weatherService;
	
	@Autowired
	public WeatherController(WeatherService weatherService) {
		super();
		this.weatherService = weatherService;
	}



	@PostMapping("")
	public Weather createWeather(@RequestBody Weather weather) {
		return weatherService.saveWeather(weather);
	}
	
	@GetMapping("")
	public Page<Weather> getWeather(Pageable pageable) {
		return weatherService.getAllWeather(pageable);
	}
	
	@GetMapping("/{id}")
	public Weather getWeather(@PathVariable int id) {
		return weatherService.getWeather(id);
	}
	
	@GetMapping("/degrees/{degreesGreaterThan}")
	public List<Weather> getWeather(@PathVariable double degreesGreaterThan) {
		return weatherService.getWeatherWhereDegreesGreaterThan(degreesGreaterThan);
	}
}
