package fr.alphashadows77.dailychallenge;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.EntityType;

public class Stat implements ConfigurationSerializable{
	
	private Statistic stat;
	private Object data;
	private int amount;
	
	public Stat(Statistic stat, int amount){
		this(stat, null, amount);
	}
	
	public Stat(Statistic stat, Object data, int amount){
		this.stat = stat;
		this.data = data;
		this.amount = amount;
	}
	
	public Stat(Map<String, Object> serializedMap){
		this.stat = Statistic.valueOf((String) serializedMap.get("stat"));
		String data = (String) serializedMap.get("data");
		this.data = (Object) data != null ? Material.matchMaterial(data) != null ? Material.matchMaterial(data) : EntityType.valueOf(data) : null;
		this.amount = (int) serializedMap.get("amount");
	}
	
	public Statistic getStat(){
		return this.stat;
	}
	
	public Object getData(){
		return data;
	}
	
	public int getAmount(){
		return this.amount;
	}
	
	public Stat clone() {
		Stat clonedStat = new Stat(this.stat, this.amount);
		clonedStat.data = this.data;
		
		return clonedStat;
	}
	
	public String toString(){
		String stringedStat = "[Stat: {" + this.stat.toString() + "}; "
	+ (this.data == null ? "" : "Data: {" + this.data.toString() + "}; ")
	+ "Amount: {" + this.amount + "}]";
		return stringedStat;
	}

	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> serializedMap = new HashMap<String, Object>();
		serializedMap.put("stat", this.stat.toString());
		serializedMap.put("data", this.data == null ? null : this.data.toString());
		serializedMap.put("amount", this.amount);
		return serializedMap;
	}
	
}
