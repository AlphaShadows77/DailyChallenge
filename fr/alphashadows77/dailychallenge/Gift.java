package fr.alphashadows77.dailychallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

public class Gift implements ConfigurationSerializable{

	//Variables
	private Set<ItemStack> itemList;
	private short xp;
	private double money;
	
	public Gift(Set<ItemStack> pItemList){
		this.itemList = pItemList;
		this.xp = 0;
		this.money = 0.0;
	}
	
	@SuppressWarnings("unchecked")
	public Gift(Map<String, Object> serializedGift){
		
		this.xp = ((Integer) serializedGift.get("xp")).shortValue();
		this.money = (double) serializedGift.get("money");
		
		Set<ItemStack> itemList = new HashSet<ItemStack>();
		
		if (serializedGift.containsKey("itemlist")){
		
			List<Map<String, Object>> serializedItemList = (List<Map<String, Object>>) serializedGift.get("itemlist");
			
			for (Map<String, Object> serializedItem : serializedItemList){
				itemList.add(ItemStack.deserialize(serializedItem));
			}
		
		}
		
		this.itemList = itemList;
		
	}
	
	
	public Set<ItemStack> getItemList(){
		return this.itemList;
	}
	
	
	public void setXp(short pXp){
		this.xp = pXp;
	}
	
	public short getXp(){
		return this.xp;
	}
	
	
	public void setMoney(double pMoney){
		this.money = pMoney;
	}
	
	public double getMoney(){
		return this.money;
	}
	
	@Override
	public String toString(){
		
		String toString = "";
		
		toString += "[itemList: " + itemList.toString() + ", xp: " + xp + ", money: " + money + "]";
		
		return toString;
		
	}


	@Override
	public Map<String, Object> serialize() {
		
		Map<String, Object> serializerMap = new HashMap<String, Object>();
		serializerMap.put("xp", xp);
		serializerMap.put("money", money);
		
		if (!itemList.isEmpty()){
		
			List<Map<String, Object>> itemsSerialized = new ArrayList<Map<String, Object>>();
			
			for (ItemStack tmpItem : itemList){
				itemsSerialized.add(tmpItem.serialize());
			}
			
			serializerMap.put("itemlist", itemsSerialized);
		
		}
		
		return serializerMap;
	}
	
}
