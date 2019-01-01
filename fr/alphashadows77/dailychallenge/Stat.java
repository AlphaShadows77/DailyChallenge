package fr.alphashadows77.dailychallenge;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Statistic;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

public class Stat implements ConfigurationSerializable{
	
	private Statistic stat;
	private String data;
	private int amount;
	
	public Stat(Statistic stat, int amount){
		this(stat, null, amount);
	}
	
	public Stat(Statistic stat, String data, int amount){
		this.stat = stat;
		this.data = data;
		this.amount = amount;
	}
	
	public Stat(Map<String, Object> serializedMap){
		this.stat = (Statistic) serializedMap.get("stat");
		this.data = (String) serializedMap.get("data");
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
	
	public String toString(){
		String stringedStat = "[Stat: {" + stat.toString() + "}; "
	+ (data == null ? "" : "Data: {" + data + "}; ")
	+ "Amount: {" + amount + "}]";
		return stringedStat;
	}

	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> serializedMap = new HashMap<String, Object>();
		serializedMap.put("stat", stat);
		serializedMap.put("data", data);
		serializedMap.put("amount", amount);
		return serializedMap;
	}
	
}
