package fr.alphashadows77.dailychallenge.challengestype;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

public class ItemChallenge extends Challenge implements ConfigurationSerializable{
	
	//Variables
	private Set<ItemStack> need;
	
	public ItemChallenge(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public ItemChallenge(Map<String, Object> serializedItemChallenge){
		
		super.deserialize(this, serializedItemChallenge);
		
		Set<ItemStack> needSet = new HashSet<ItemStack>();
		List<Map<String, Object>> serializedItemList = (List<Map<String, Object>>) serializedItemChallenge.get("need");
		
		for (Map<String, Object> serializedItem : serializedItemList){
			needSet.add(ItemStack.deserialize(serializedItem));
		}
		
		this.need = needSet;
		
	}

	/**
	 * Permet de définir ce qui est nécessaire
	 */
	@SuppressWarnings("unchecked")
	public void setNeed(Object pNeed){
		this.need = (Set<ItemStack>) pNeed;
	}

	public Object getNeed(){
		return this.need;
	}

	@Override
	public Map<String, Object> serialize() {
		
		Map<String, Object> serializedMap = super.serialize();
		
		List<Map<String, Object>> needSerializedMap = new ArrayList<Map<String, Object>>();
		
		for (ItemStack tmpItem : need){
			needSerializedMap.add(tmpItem.serialize());			
		}
		
		serializedMap.put("need", needSerializedMap);
		
		return serializedMap;
	}
	
}
