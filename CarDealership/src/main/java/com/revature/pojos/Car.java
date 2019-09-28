package com.revature.pojos;

import java.io.Serializable;

public class Car implements Serializable{
	
	private String model;
	private int year;
	private String vinNo;
	private String color;
	private String make;
	private String carType;
	private double price;
	private String owner;
	

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String model, int year, String vinNo, String color, String make, String carType) {
		super();
		this.model = model;
		this.year = year;
		this.vinNo = vinNo;
		this.color = color;
		this.make = make;
		this.carType = carType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carType == null) ? 0 : carType.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((vinNo == null) ? 0 : vinNo.hashCode());
		result = prime * result + year;
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
		Car other = (Car) obj;
		if (carType == null) {
			if (other.carType != null)
				return false;
		} else if (!carType.equals(other.carType))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (vinNo == null) {
			if (other.vinNo != null)
				return false;
		} else if (!vinNo.equals(other.vinNo))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car [model=" + model + ", year=" + year + ", vinNo=" + vinNo + ", color=" + color + ", make=" + make
				+ ", carType=" + carType + "]";
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getVinNo() {
		return vinNo;
	}
	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
