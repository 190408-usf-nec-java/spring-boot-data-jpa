package com.revature;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Integer>{

	List<Weather> findByDegreesCelsiusGreaterThan(double value);
}
