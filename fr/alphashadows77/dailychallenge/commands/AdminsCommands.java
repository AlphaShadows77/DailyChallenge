package fr.alphashadows77.dailychallenge.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AdminsCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (isCommand(cmd, "modifychallenge")){
			
			//Si on veut ajouter un challenge
			if (args[0].equalsIgnoreCase("add")){
				
				
				
			}
			
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
