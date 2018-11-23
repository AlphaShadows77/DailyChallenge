package fr.alphashadows77.dailychallenge.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import fr.alphashadows77.dailychallenge.Utils;
import fr.alphashadows77.dailychallenge.challengestype.Challenge;
import fr.alphashadows77.dailychallenge.challengestype.ItemChallenge;

public class AdminsCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
				
		if (!(sender instanceof Player)){
			return false;
		}
		
		final Player player = (Player) sender;
		
		if (isCommand(label, "modifychallenge")){
			
			if (args.length == 1){
			
				// Si on veut ajouter un challenge nécessitant des items
				if (args[0].equalsIgnoreCase("additem")){
					
					Utils.setPlayerChallenge(player, new ItemChallenge());
					final byte inventorySize = 36;
					final String inventoryTitle = Utils.getMessage("title-add_challenge_inventory");
					Utils.resetNeed(player);
					
					final Inventory itemsAddInventory = Bukkit.createInventory(null, inventorySize, inventoryTitle);
					
					player.sendMessage(Utils.getMessage("inventory-opened-need-item"));
					player.openInventory(itemsAddInventory);
					
				}
				
				// Si on veut ajouter un challenge nécessitant des stats
				else if (args[0].equalsIgnoreCase("addstats")){
					
					
					
				}
			
			}
			
			// Permet de choisir le nom du challenge une fois que ce qui est nécessaire et les récompenses ont été définis				
			else if (args.length >= 4 && args[0].equalsIgnoreCase("add")){
							
				if (!Utils.isNeeded(player)){
					player.sendMessage(Utils.getMessage("can_not-add"));
					return true;
				}
				
				double money = 0.0;
				short xp = 0;
				
				try{
					money = Double.parseDouble(args[1]);
					xp = Short.parseShort(args[2]);
				}
				catch(NumberFormatException e) {return false;}
				
				
				Challenge challenge = Utils.getPlayerChallenge(player);
				
				challenge.getGift().setMoney(money);
				challenge.getGift().setXp(xp);
				
				String name = Utils.removeArgs(Utils.combineArgs(args), new String[] {args[0], args[1], args[2]});
				challenge.setName(name);
				
				Utils.setChallengeInConfig(challenge);
				
				player.sendMessage(Utils.getMessage("challenge-added"));
				
			}
			
			else
				return false;
			
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Vérifie si la commande appelé correspond à la commande à vérifier.
	 * @param pLabel Nom de la commande tapé
	 * @param cmdName Nom de la commande à vérifier
	 * @return Vrai si la commande appelé correspond à la commande à vérifier, faux sinon.
	 */
	private boolean isCommand(String pLabel, String pCmdName){
		
		if (pLabel.equalsIgnoreCase(pCmdName)) return true;
		
		for (String alias : Utils.getCommandAliases(pCmdName)){
			if (pLabel.equalsIgnoreCase(alias)){
				return true;
			}
		}
		
		return false;
	}

}
