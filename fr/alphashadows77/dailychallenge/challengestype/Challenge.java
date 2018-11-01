package fr.alphashadows77.dailychallenge.challengestype;

import fr.alphashadows77.dailychallenge.Gift;

public abstract class Challenge {

	//Variables
	private Gift gift;
	private String name;	
	
	
	public abstract Object getNeed();
	public abstract void setNeed(Object pNeed);
	
	public void setGift(Gift pGift){
		this.gift = pGift;
	}
	
	public Gift getGift(){
		return this.gift;
	}
	
	
	public void setName(String pName){
		this.name = pName;
	}
	
	public String getName(){
		return this.name;
	}
	
}
