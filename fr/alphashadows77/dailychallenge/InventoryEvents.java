package fr.alphashadows77.dailychallenge;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import fr.alphashadows77.dailychallenge.challengestype.ItemChallenge;

public class InventoryEvents implements Listener {
	
	private static long lastStepTime;

	@EventHandler
	public void onClose(InventoryCloseEvent e){
		
		Inventory inventory = e.getInventory();
		String inventoryTitle = inventory.getTitle();
		String addChallengeTitle = Utils.getMessage("title-add_challenge_inventory");
		
		if (inventory.getHolder() == null && inventoryTitle.equalsIgnoreCase(addChallengeTitle) && System.currentTimeMillis() - 200 > lastStepTime){
			
			lastStepTime = System.currentTimeMillis();
			Player player = (Player) e.getPlayer();
			
			if (Utils.getPlayerChallenge(player).getNeed() == null && Utils.getPlayerChallenge(player) instanceof ItemChallenge){
				Utils.toGift(player, inventory.getContents());
			}
			
			else{
				Utils.addChallenge(player, inventory.getContents());
			}
			
		}
		
	}
	
}
