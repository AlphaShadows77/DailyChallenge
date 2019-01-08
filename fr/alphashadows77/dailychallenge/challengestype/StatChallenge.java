package fr.alphashadows77.dailychallenge.challengestype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Statistic;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import fr.alphashadows77.dailychallenge.Stat;

public class StatChallenge extends Challenge implements ConfigurationSerializable{

	// Variables
	private Stat[] need;
	
	public StatChallenge(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public StatChallenge(Map<String, Object> serializedMap){
		super.deserialize(this, serializedMap);
				
		if (serializedMap.containsKey("need")){
		
			Set<Stat> needSet = new HashSet<Stat>();
			
			for (Map<String, Object> serializedStat : (List<Map<String, Object>>) serializedMap.get("need")){
				needSet.add(new Stat(serializedStat));
			}
			
			need = needSet.toArray(new Stat[needSet.size()]);
		
		}
		
	}
	
	@Override
	public Object[] getNeed() {
		return this.need.clone();
	}

	@Override
	public void setNeed(Object[] pNeed) {
		this.need = (Stat[]) pNeed;
	}
	
	@Override
	public Map<String, Object> serialize(){
		
		Map<String, Object> serializedMap = super.serialize();
	
		if (need.length != 0){
		
			List<Map<String, Object>> serializedStatList = new ArrayList<Map<String, Object>>();
			
			for (Stat tmpStat : need){
				serializedStatList.add(tmpStat.serialize());
			}
			
			serializedMap.put("need", serializedStatList);
		
		}
		
		return serializedMap;
		
	}
	
	public void clearNeed(){
		this.need = new Stat[0];
	}
	
	public void addNeededStat(Stat stat){
		Set<Stat> needSet = new HashSet<Stat>();
		needSet.addAll(Arrays.asList(this.need));
		needSet.add(stat);
		this.need = needSet.toArray(new Stat[needSet.size()]);
	}
	
	public void removeNeededStat(Statistic stat){
		
		Set<Stat> needSet = new HashSet<Stat>();
		needSet.addAll(Arrays.asList(need));
		
		Iterator<Stat> it = needSet.iterator();
		
		while (it.hasNext()){
			Stat challengeStat = it.next();
			
			if (challengeStat.getStat() == stat){
				it.remove();
				break;
			}
		}
		
		this.need = needSet.toArray(new Stat[needSet.size()]);
		
	}
	
	public void removeNeededStat(Statistic stat, String data){
		
		Set<Stat> needSet = new HashSet<Stat>();
		needSet.addAll(Arrays.asList(need));
		
		Iterator<Stat> it = needSet.iterator();
		
		while (it.hasNext()){
			Stat challengeStat = it.next();
			
			if (challengeStat.getStat() == stat && challengeStat.getData() == data){
				it.remove();
				break;
			}
		}
		
		this.need = needSet.toArray(new Stat[needSet.size()]);
		
	}
	
	public boolean containsStat(Statistic stat){
		
		for (Stat tmpStat : need){
			
			if (tmpStat.getStat().equals(stat))
				return true;
			
		}
		
		return false;
		
	}
	
	public boolean containsStat(Statistic stat, String data){
		
		for (Stat tmpStat : need){
			
			if (tmpStat.getStat().equals(stat) && tmpStat.getData().equals(data))
				return true;
			
		}
		
		return false;
		
	}
	
	public String[] needToString(){
		
		Set<String> needToString = new HashSet<String>();
		
		for (Stat tmpStat : need){
			needToString.add(tmpStat.toString());
		}
		
		return needToString.toArray(new String[needToString.size()]);
		
	}

}
