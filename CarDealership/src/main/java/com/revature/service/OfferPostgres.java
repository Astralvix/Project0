package com.revature.service;

import static com.revature.util.LoggerUtil.trace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.p2.OfferServiceP2;
import com.revature.pojos.Offerings;
import com.revature.util.ConnectionFactory;

public class OfferPostgres implements OfferServiceP2{

private Connection conn = ConnectionFactory.getConnection();
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void createOfferSQL(Offerings offer) {
		// TODO Auto-generated method stub
		String sql = "insert into cardealer.offer(username, vinnum, offer, status) values("
		+"'"+offer.getUserName()+"','"+offer.getVinNo()+"',"+offer.getOffer()+",'"
		+offer.getStatus()+"');";
		try {
			conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Offerings createOffer() {
		Offerings offer = new Offerings();
		Scanner sc = new Scanner(System.in);
		String vinNo;
		double offerprice;
		String status = "pending";
		
		System.out.println("Enter the VinNo: ");
		vinNo = sc.nextLine();
		offer.setVinNo(vinNo);
		System.out.println("Enter the offer amount: ");
		offerprice = sc.nextDouble();
		offer.setOffer(offerprice);
		sc.nextLine();
		offer.setStatus(status);
		return offer;
	}
	@Override
	public List<Offerings> getAllOffers() {
		// TODO Auto-generated method stub
		
		List<Offerings> listOfOffers = new ArrayList<>();
		PreparedStatement stmt;
		String sql = "select * from cardealer.offer;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Offerings offer = new Offerings();
				offer.setOffer_id(rs.getInt(1));
				offer.setUserName(rs.getString(2));
				offer.setVinNo(rs.getString(3));
				offer.setOffer(rs.getDouble(4));
				offer.setStatus(rs.getString(5));
				listOfOffers.add(offer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfOffers;
	}
	@Override
	public void setOfferStatus(int offerid, String status) {
		// TODO Auto-generated method stub
		
		String sql = "update cardealer.offer set status = ? where offer.offerid = ?;";
		
		try {
		PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, status);
			stmt.setInt(2, offerid);
			stmt.executeUpdate();
			trace("offer status has been updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
