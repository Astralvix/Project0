package com.revature.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.revature.util.ConnectionFactory;
import com.revature.p2.CarServiceP2;
import com.revature.pojos.Car;

public class CarServicePostgres implements CarServiceP2 {
	
private Connection conn = ConnectionFactory.getConnection();
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void createCar(Car c) {
		// TODO Auto-generated method stub
		
		String sql = "insert into car (vinnum, make, model, color, yearnum, cartype, price, ownername) values('"
		+ c.getVinNo()+"','"+c.getMake()+"','"+ c.getModel()+"','"+c.getColor()+"','"+c.getYear()+"','"
		+c.getCarType()+"',"+c.getPrice()+",'"+c.getOwner()+"');";
		try {
			conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
