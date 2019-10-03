package com.revature.dao;

import com.revature.pojos.OfferList;

public interface OfferListDAO {
	
	public void createOfferList();
	
	public OfferList readOfferList();
	
	public boolean checkOfferList();
}
