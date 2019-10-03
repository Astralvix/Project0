package com.revature.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OfferList implements Serializable{

	private List<Offerings> userList = new ArrayList<>();

	public OfferList() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public OfferList(List<Offerings> userList) {
		super();
		this.userList = userList;
	}



	public List<Offerings> getUserList() {
		return userList;
	}

	public void setUserList(List<Offerings> userList) {
		this.userList = userList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userList == null) ? 0 : userList.hashCode());
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
		OfferList other = (OfferList) obj;
		if (userList == null) {
			if (other.userList != null)
				return false;
		} else if (!userList.equals(other.userList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OfferList [userList=" + userList + "]";
	}
	
	
}
