package fr.alphashadows77.dailychallenge;

import java.util.Set;

import org.bukkit.inventory.ItemStack;

public class Gift {

	//Variables
	private Set<ItemStack> itemList;
	private short xp;
	private double money;
	
	public Gift(Set<ItemStack> pItemList){
		this.itemList = pItemList;
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
	
}
