package com.revature.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

 public class CarLot implements Serializable {

	private List<Car> carLot = new ArrayList<>();

	public CarLot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarLot(List<Car> carLot) {
		super();
		this.carLot = carLot;
	}

	public List<Car> getCarLot() {
		return carLot;
	}

	public void setCarLot(List<Car> carLot) {
		this.carLot = carLot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carLot == null) ? 0 : carLot.hashCode());
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
		CarLot other = (CarLot) obj;
		if (carLot == null) {
			if (other.carLot != null)
				return false;
		} else if (!carLot.equals(other.carLot))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarLot [carLot=" + carLot + "]";
	}
	
}
