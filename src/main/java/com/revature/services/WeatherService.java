package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.WeatherRepository;
import com.revature.models.Weather;

@Service
public class WeatherService {

	WeatherRepository weatherRepository;

	@Autowired
	public WeatherService(WeatherRepository weatherRepository) {
		super();
		this.weatherRepository = weatherRepository;
	}

	public Weather saveWeather(Weather weather) {
		return weatherRepository.save(weather);
	}
	
	public Weather getWeather(int id) {
		return weatherRepository
				.findById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Resource not found"));
	}

	public List<Weather> getWeatherWhereDegreesGreaterThan(double degreesGreaterThan) {
		return weatherRepository.findByDegreesCelsiusGreaterThan(degreesGreaterThan);
	}

	public Page<Weather> getAllWeather(Pageable pageable) {
		return weatherRepository.findAll(pageable);
	}
	
	
	
	
}
