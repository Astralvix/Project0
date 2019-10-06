package com.revature.service;

import java.sql.Connection;

import com.revature.p2.OfferServiceP2;
import com.revature.pojos.Offerings;
import com.revature.util.ConnectionFactory;

public class OfferPostgres implements OfferServiceP2{

private Connection conn = ConnectionFactory.getConnection();
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void createOffer(Offerings offer) {
		// TODO Auto-generated method stub
		String sql = "insert into offer(offerid, username, vinnum, offer, status) values("
		+ offer.getOffer_id()+",'"+offer.getUserName()+"','"+offer.getVinNo()+"',"+offer.getOffer()+",'"
		+ offer.getStatus()+"');";
	}

}
