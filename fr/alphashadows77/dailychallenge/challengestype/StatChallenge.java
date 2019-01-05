package fr.alphashadows77.dailychallenge.challengestype;

import java.util.ArrayList;
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
	private Set<Stat> need = new HashSet<Stat>();
	
	public StatChallenge(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public StatChallenge(Map<String, Object> serializedMap){
		super.deserialize(this, serializedMap);
		
		if (serializedMap.containsKey("need")){
		
			for (Map<String, Object> serializedStat : (List<Map<String, Object>>) serializedMap.get("need")){
				this.need.add(new Stat(serializedStat));
			}
		
		}
		
	}
	
	@Override
	public Set<?> getNeed() {
		return this.need;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setNeed(Set<?> pNeed) {
		this.need = (Set<Stat>) pNeed;
	}
	
	@Override
	public Map<String, Object> serialize(){
		
		Map<String, Object> serializedMap = super.serialize();
	
		if (!need.isEmpty()){
		
			List<Map<String, Object>> serializedStatList = new ArrayList<Map<String, Object>>();
			
			for (Stat tmpStat : need){
				serializedStatList.add(tmpStat.serialize());
			}
			
			serializedMap.put("need", serializedStatList);
		
		}
		
		return serializedMap;
		
	}
	
	public void clearNeed(){
		this.need = new HashSet<Stat>();
	}
	
	public void addNeededStat(Stat stat){
		need.add(stat);
	}
	
	public void removeNeededStat(Statistic stat){
		
		Iterator<Stat> it = need.iterator();
		
		while (it.hasNext()){
			Stat challengeStat = it.next();
			
			if (challengeStat.getStat() == stat){
				it.remove();
				break;
			}
		}
		
	}
	
	public void removeNeededStat(Statistic stat, String data){
		
		Iterator<Stat> it = need.iterator();
		
		while (it.hasNext()){
			Stat challengeStat = it.next();
			
			if (challengeStat.getStat() == stat && challengeStat.getData() == data){
				it.remove();
				break;
			}
		}
		
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
		Iterator<Stat> it = need.iterator();
		
		while (it.hasNext()){
			Stat iteratedStat = it.next();
			needToString.add(iteratedStat.toString());
		}
		
		return needToString.toArray(new String[needToString.size()]);
		
	}

}
