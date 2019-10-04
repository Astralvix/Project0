package com.revature.dao;

import com.revature.pojos.OfferList;

public interface OfferListDAO {
	
	public void createOfferList();
	
	public OfferList readOfferList();
	
	public boolean checkOfferList();
	
	public void addOffer();
	
	public void deleteOffer();
	
	public void viewOfferList();
	
	public void viewUserOffer();
	
	public void setOfferStatus();
}
