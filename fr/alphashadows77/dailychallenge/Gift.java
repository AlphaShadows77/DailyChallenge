package fr.alphashadows77.dailychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

public class Gift implements ConfigurationSerializable{

	//Variables
	private ItemStack[] itemList;
	private short xp;
	private double money;
	
	public Gift(ItemStack[] pItemList){
		this.itemList = pItemList;
		this.xp = 0;
		this.money = 0.0;
	}
	
	@SuppressWarnings("unchecked")
	public Gift(Map<String, Object> serializedGift){
		
		this.xp = ((Integer) serializedGift.get("xp")).shortValue();
		this.money = (double) serializedGift.get("money");
		
		List<ItemStack> itemList = new ArrayList<ItemStack>();
		
		if (serializedGift.containsKey("itemlist")){
		
			List<Map<String, Object>> serializedItemList = (List<Map<String, Object>>) serializedGift.get("itemlist");
			
			for (Map<String, Object> serializedItem : serializedItemList){
				itemList.add(ItemStack.deserialize(serializedItem));
			}
		
		}
		
		this.itemList = itemList.toArray(new ItemStack[itemList.size()]);
		
	}
	
	
	public ItemStack[] getItemList(){
		return Arrays.copyOf(this.itemList, this.itemList.length);
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
	
	public Gift deepCopy() {
		
		byte length = (byte) this.itemList.length;
		
		ItemStack[] itemListCopy = new ItemStack[length];
		short clonedXp = Short.valueOf(xp);
		double clonedMoney = Double.valueOf(money);
		
		for (int i = 0; i < length; i++) {
			ItemStack clonedItem = itemList[i].clone();
			itemListCopy[i] = clonedItem;
		}
		
		Gift copiedGift = new Gift(itemListCopy);
		copiedGift.money = clonedMoney;
		copiedGift.xp = clonedXp;
		
		return copiedGift;
		
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
		
		if (itemList.length != 0){
		
			List<Map<String, Object>> itemsSerialized = new ArrayList<Map<String, Object>>();
			
			for (ItemStack tmpItem : itemList){
				itemsSerialized.add(tmpItem.serialize());
			}
			
			serializerMap.put("itemlist", itemsSerialized);
		
		}
		
		return serializerMap;
	}
	
}
