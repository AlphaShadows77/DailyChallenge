package fr.alphashadows77.dailychallenge;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class InventoryEvents implements Listener {

	public void onClose(InventoryCloseEvent e){
		
		Inventory inventory = e.getInventory();
		String inventoryTitle = inventory.getTitle();
		String addChallengeTitle = Utils.getMessage("title-add_challenge_inventory");
		
		if (inventory.getHolder() == null && inventoryTitle.equalsIgnoreCase(addChallengeTitle)){
			
			Player player = (Player) e.getPlayer();
			
			if (!Utils.needSet(player)){
				Utils.toGift(player, inventory.getContents());
			}
			
			else{
				Utils.addChallenge(player, inventory.getContents());
			}
			
		}
		
	}
	
}
