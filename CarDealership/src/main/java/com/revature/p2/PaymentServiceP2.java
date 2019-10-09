package com.revature.p2;

import java.util.List;

import com.revature.pojos.Payment;

public interface PaymentServiceP2 {
	
	public Payment createPayment();
	
	public void createPaymentSQL(Payment pay);
	
	public List<Payment> getAllPayments();
	
	public List<Payment> getMyPayments(String username);
	
	public void setPaymentPlan(int pay_id, double base_price, double due_amount, double monthly_pay, int months_left);

}
