package com.lf.movie.app.dto;

import java.util.Date;

public class Movie {
	protected int id;
	protected String name;
	protected int ageInDay;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAgeInDay() {
		return ageInDay;
	}
	public void setAgeInDay(int ageInDay) {
		this.ageInDay = ageInDay;
	}
	
}
