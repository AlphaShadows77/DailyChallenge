package fr.alphashadows77.dailychallenge.challengestype;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import fr.alphashadows77.dailychallenge.Gift;

public abstract class Challenge implements ConfigurationSerializable{

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
	
	@Override
	public Map<String, Object> serialize(){
		
		Map<String, Object> serializerMap = new HashMap<String, Object>();
		serializerMap.put("name", name);
		serializerMap.put("gift", gift.serialize());
		
		return serializerMap;
		
	}
	
	@SuppressWarnings("unchecked")
	public static Challenge deserialize(Challenge pChallenge, Map<String, Object> serializedObject){
		
		pChallenge.setName((String) serializedObject.get("name"));
		pChallenge.setGift(new Gift((Map<String, Object>) serializedObject.get("gift")));
		
		return pChallenge;
		
	}
	
}
