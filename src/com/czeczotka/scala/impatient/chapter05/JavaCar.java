package com.czeczotka.scala.impatient.chapter05;

public class JavaCar {
	
	private final String manufacturer;
	private final String model;
	private final int year;
	private String licensePlate = "";
	
	public JavaCar(String manufacturer, String model, int year) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
	}
	
	public JavaCar(String manufacturer, String model) {
		this(manufacturer, model, -1);
	}
	
	public JavaCar(String manufacturer, String model, String licensePlate) {
		this(manufacturer, model, -1);
		this.licensePlate = licensePlate;
	}
	
	public JavaCar(String manufacturer, String model, int year, String licensePlate) {
		this(manufacturer, model, year);
		this.licensePlate = licensePlate;
	}
	
	@Override
	public String toString() {
		return String.format("Car %s %s, produced in %d, plate '%s'", manufacturer, model, year, licensePlate);
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}
	
	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}	
}