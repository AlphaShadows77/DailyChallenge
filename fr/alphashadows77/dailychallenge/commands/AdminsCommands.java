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
		
		if (isCommand(cmd, "modifychallenge")){
			
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
			
			// Permet de choisir le nom du challenge une fois que ce qui est nécessaire et les récompenses ont été définis
			else if (args[0].equalsIgnoreCase("name")){
				
				Challenge challenge = Utils.getPlayerChallenge(player);
				String name = Utils.combineArgs(args).replaceFirst(args[0] + " ", "");
				challenge.setName(name);
				
				Utils.setChallengeInConfig(challenge);
				
			}
			
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Vérifie si la commande appelé correspond à la commande à vérifier.
	 * @param pCmd Objet Command fourni lors de l'appel de la fonction onCommand()
	 * @param cmdName Nom de la commande à vérifier
	 * @return Vrai si la commande appelé correspond à la commande à vérifier, faux sinon.
	 */
	private boolean isCommand(Command pCmd, String cmdName){
		
		for (String alias : Bukkit.getCommandAliases().get(cmdName)){
			if (pCmd.getLabel().equalsIgnoreCase(alias)){
				return true;
			}
		}
		
		return false;
	}

}
