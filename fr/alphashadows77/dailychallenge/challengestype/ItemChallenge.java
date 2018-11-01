package fr.alphashadows77.dailychallenge.challengestype;

import java.util.Set;

import org.bukkit.inventory.ItemStack;

public class ItemChallenge extends Challenge {
	
	//Variables
	private Set<ItemStack> need;

	/**
	 * Permet de définir 
	 */
	@SuppressWarnings("unchecked")
	public void setNeed(Object pNeed) {
		this.need = (Set<ItemStack>) pNeed;
	}

	@Override
	public Object getNeed() {
		return this.need;
	}
	
}
