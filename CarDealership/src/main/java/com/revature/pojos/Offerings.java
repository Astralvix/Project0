package com.revature.pojos;

import java.io.Serializable;

public class Offerings implements Serializable{
	
	
	public enum Status{
		PENDING,REJECTED,ACCEPTED
	}
	private String userName;
	private String vinNo;
	private double offer;
	private Status status;
	public Offerings() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Offerings(String userName, String vinNo, double offer, Status status) {
		super();
		this.userName = userName;
		this.vinNo = vinNo;
		this.offer = offer;
		this.status = status;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getVinNo() {
		return vinNo;
	}
	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}
	public double getOffer() {
		return offer;
	}
	public void setOffer(double offer) {
		this.offer = offer;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(offer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((vinNo == null) ? 0 : vinNo.hashCode());
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
		Offerings other = (Offerings) obj;
		if (Double.doubleToLongBits(offer) != Double.doubleToLongBits(other.offer))
			return false;
		if (status != other.status)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (vinNo == null) {
			if (other.vinNo != null)
				return false;
		} else if (!vinNo.equals(other.vinNo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Offerings [userName=" + userName + ", vinNo=" + vinNo + ", offer=" + offer + ", status=" + status + "]";
	}
	

}
