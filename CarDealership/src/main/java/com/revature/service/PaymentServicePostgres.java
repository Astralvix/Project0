package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.p2.PaymentServiceP2;
import com.revature.pojos.Payment;
import com.revature.util.ConnectionFactory;

public class PaymentServicePostgres implements PaymentServiceP2 {

private Connection conn = ConnectionFactory.getConnection();
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public Payment createPayment() {
		// TODO Auto-generated method stub
		Payment pay = new Payment();
		Scanner sc = new Scanner(System.in);
		String vinnum;
		String username;
		System.out.println("What is the VinNo: ");
		vinnum = sc.nextLine();
		pay.setVinNo(vinnum);
		System.out.println("What is the username: ");
		username = sc.nextLine();
		pay.setUsername(username);
		return pay;
	}

	@Override
	public void createPaymentSQL(Payment pay) {
		// TODO Auto-generated method stub
		PreparedStatement stmt;
		String sql = "insert into cardealer.payment (username, vinnum) values(?,?);";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pay.getUsername());
			stmt.setString(2, pay.getVinNo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		
		List<Payment> listOfPays = new ArrayList<>();
		PreparedStatement stmt;
		String sql = "select * from cardealer.payment;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Payment pay = new Payment();
				pay.setPayId(rs.getInt(1));
				pay.setUsername(rs.getString(2));
				pay.setVinNo(rs.getString(3));
				pay.setBasePrice(rs.getDouble(4));
				pay.setDue_amount(rs.getDouble(5));
				pay.setMonthly_pay(rs.getDouble(6));
				pay.setMonths_left(rs.getInt(7));
				listOfPays.add(pay);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfPays;
	}

	@Override
	public List<Payment> getMyPayments(String username) {
		List<Payment> listOfPays = new ArrayList<>();
		PreparedStatement stmt;
		String sql = "select * from cardealer.payment where username = ?;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Payment pay = new Payment();
				pay.setPayId(rs.getInt(1));
				pay.setUsername(rs.getString(2));
				pay.setVinNo(rs.getString(3));
				pay.setBasePrice(rs.getDouble(4));
				pay.setDue_amount(rs.getDouble(5));
				pay.setMonthly_pay(rs.getDouble(6));
				pay.setMonths_left(rs.getInt(7));
				listOfPays.add(pay);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfPays;
	}
}
