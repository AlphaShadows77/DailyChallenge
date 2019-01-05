package fr.alphashadows77.dailychallenge.challengestype;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import fr.alphashadows77.dailychallenge.Gift;

public abstract class Challenge implements ConfigurationSerializable{

	//Variables
	private Gift gift;
	private String name;
	private ChallengeFrequency frequency;
	
	public abstract Set<?> getNeed();
	public abstract void setNeed(Set<?> pNeed);
	
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
	
	public void setFrequency(ChallengeFrequency frequency){
		this.frequency = frequency;
	}
	
	public ChallengeFrequency getFrequency(){
		return this.frequency;
	}
	
	@Override
	public Map<String, Object> serialize(){
		
		Map<String, Object> serializedMap = new HashMap<String, Object>();
		serializedMap.put("name", name);
		serializedMap.put("frequency", frequency.toString());
		serializedMap.put("gift", gift.serialize());
		
		return serializedMap;
		
	}
	
	@SuppressWarnings("unchecked")
	public static Challenge deserialize(Challenge pChallenge, Map<String, Object> serializedObject){
		
		pChallenge.setName((String) serializedObject.get("name"));
		pChallenge.setFrequency(ChallengeFrequency.valueOf((String) serializedObject.get("frequency")));
		pChallenge.setGift(new Gift((Map<String, Object>) serializedObject.get("gift")));
		
		return pChallenge;
		
	}
	
}
