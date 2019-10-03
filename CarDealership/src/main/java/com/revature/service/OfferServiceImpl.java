package com.revature.service;
import static com.revature.util.LoggerUtil.*;
import java.util.Scanner;

import com.revature.pojos.Offerings;
import com.revature.pojos.Offerings.Status;

public class OfferServiceImpl implements OfferService {

	@Override
	public Offerings createOffer() {
		// TODO Auto-generated method stub
		Offerings offer = new Offerings();
		Scanner keyboard = new Scanner (System.in);
		String userName;
		 String vinNo;
		 double offerNo;
		 System.out.println("Enter username: ");
			userName = keyboard.nextLine();
			offer.setUserName(userName);
			System.out.println("Enter vinNo: ");
			vinNo = keyboard.nextLine();
			offer.setVinNo(vinNo);
			System.out.println("Enter offer amount: ");
			offerNo= keyboard.nextDouble();
			offer.setOffer(offerNo);
			offer.setStatus(Offerings.Status.PENDING);
			trace("Offer has been made of: " + offer.getOffer());
		return offer;
	}

	
}
