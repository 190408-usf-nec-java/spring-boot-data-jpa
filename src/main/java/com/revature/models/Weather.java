package com.revature.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Weather {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double humidity;
	
	@Column(name="degrees_celsius")
	private double degreesCelsius;
	
	@Column(name="wind_speed")
	private double windSpeed;
	
	@Column(name="uv_index")
	private int UVIndex;
	
	private String location;
	
	@DateTimeFormat
	private LocalDateTime time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getDegreesCelsius() {
		return degreesCelsius;
	}

	public void setDegreesCelsius(double degreesCelsius) {
		this.degreesCelsius = degreesCelsius;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public int getUVIndex() {
		return UVIndex;
	}

	public void setUVIndex(int uVIndex) {
		UVIndex = uVIndex;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + UVIndex;
		long temp;
		temp = Double.doubleToLongBits(degreesCelsius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(humidity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		temp = Double.doubleToLongBits(windSpeed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		if (UVIndex != other.UVIndex)
			return false;
		if (Double.doubleToLongBits(degreesCelsius) != Double.doubleToLongBits(other.degreesCelsius))
			return false;
		if (Double.doubleToLongBits(humidity) != Double.doubleToLongBits(other.humidity))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (Double.doubleToLongBits(windSpeed) != Double.doubleToLongBits(other.windSpeed))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", humidity=" + humidity + ", degreesCelsius=" + degreesCelsius + ", windSpeed="
				+ windSpeed + ", UVIndex=" + UVIndex + ", location=" + location + ", time=" + time + "]";
	}

	public Weather(int id, double humidity, double degreesCelsius, double windSpeed, int uVIndex, String location,
			LocalDateTime time) {
		super();
		this.id = id;
		this.humidity = humidity;
		this.degreesCelsius = degreesCelsius;
		this.windSpeed = windSpeed;
		UVIndex = uVIndex;
		this.location = location;
		this.time = time;
	}

	public Weather() {
		super();
		// TODO Auto-generated constructor stub
	}

}
