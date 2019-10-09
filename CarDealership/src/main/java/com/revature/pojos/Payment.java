package com.revature.pojos;

public class Payment {

	private int payId;
	private String username;
	private String vinNo;
	private double basePrice;
	private double due_amount;
	private double monthly_pay;
	private int months_left;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int payId, String username, String vinNo, double basePrice, double due_amount, double monthly_pay,
			int months_left) {
		super();
		this.payId = payId;
		this.username = username;
		this.vinNo = vinNo;
		this.basePrice = basePrice;
		this.due_amount = due_amount;
		this.monthly_pay = monthly_pay;
		this.months_left = months_left;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getDue_amount() {
		return due_amount;
	}

	public void setDue_amount(double due_amount) {
		this.due_amount = due_amount;
	}

	public double getMonthly_pay() {
		return monthly_pay;
	}

	public void setMonthly_pay(double monthly_pay) {
		this.monthly_pay = monthly_pay;
	}

	public int getMonths_left() {
		return months_left;
	}

	public void setMonths_left(int months_left) {
		this.months_left = months_left;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(basePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(due_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(monthly_pay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + months_left;
		result = prime * result + payId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Payment other = (Payment) obj;
		if (Double.doubleToLongBits(basePrice) != Double.doubleToLongBits(other.basePrice))
			return false;
		if (Double.doubleToLongBits(due_amount) != Double.doubleToLongBits(other.due_amount))
			return false;
		if (Double.doubleToLongBits(monthly_pay) != Double.doubleToLongBits(other.monthly_pay))
			return false;
		if (months_left != other.months_left)
			return false;
		if (payId != other.payId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
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
		return "Payment [payId=" + payId + ", username=" + username + ", vinNo=" + vinNo + ", basePrice=" + basePrice
				+ ", due_amount=" + due_amount + ", monthly_pay=" + monthly_pay + ", months_left=" + months_left + "]";
	}
	
	
	
}
