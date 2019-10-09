package com.revature.p2;

import java.util.List;

import com.revature.pojos.Offerings;

public interface OfferServiceP2 {

	public Offerings createOffer();
	
	public void createOfferSQL(Offerings offer);
	 
	public List<Offerings> getAllOffers();
	
	public void setOfferStatus(int offerid, String status);
}
