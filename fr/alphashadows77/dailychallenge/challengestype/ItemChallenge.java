package fr.alphashadows77.dailychallenge.challengestype;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

import fr.alphashadows77.dailychallenge.Utils;

public class ItemChallenge extends Challenge implements ConfigurationSerializable{
	
	//Variables
	private ItemStack[] need;
	
	public ItemChallenge(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public ItemChallenge(Map<String, Object> serializedItemChallenge){
				
		super.deserialize(this, serializedItemChallenge);
		
		List<ItemStack> needSet = new ArrayList<ItemStack>();
		
		if (serializedItemChallenge.containsKey("need")){
			
			List<Map<String, Object>> serializedItemList = (List<Map<String, Object>>) serializedItemChallenge.get("need");
			
			for (Map<String, Object> serializedItem : serializedItemList){
				needSet.add(ItemStack.deserialize(serializedItem));
			}
		
		}
		
		this.need = needSet.toArray(new ItemStack[needSet.size()]);
		
	}

	/**
	 * Permet de définir ce qui est nécessaire
	 */
	public void setNeed(Object[] pNeed){
		this.need = (ItemStack[]) pNeed;
	}

	public Object[] getNeed(){
		
		if (this.need == null){
			return null;
		}
		
		return Utils.deepCopy(this.need);
		
	}
	
	/**
	 * Don't use this method, use {@link Challenge#deepCopy()} instead
	 */
	public Challenge _deepCopy() {
		
		ItemStack[] copiedItemStack = Utils.deepCopy(this.need);
		Challenge copiedChallenge = new ItemChallenge();
		copiedChallenge.setNeed(copiedItemStack);
		
		return copiedChallenge;
		
	}

	@Override
	public Map<String, Object> serialize() {
		
		Map<String, Object> serializedMap = super.serialize();
		
		if (need.length != 0){
		
			List<Map<String, Object>> needSerializedMap = new ArrayList<Map<String, Object>>();
			
			for (ItemStack tmpItem : need){
				needSerializedMap.add(tmpItem.serialize());			
			}
			
			serializedMap.put("need", needSerializedMap);
		
		}
		
		return serializedMap;
	}
	
}
