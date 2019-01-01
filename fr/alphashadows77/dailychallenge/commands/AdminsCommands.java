package fr.alphashadows77.dailychallenge.commands;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.Statistic.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.alphashadows77.dailychallenge.Stat;
import fr.alphashadows77.dailychallenge.Utils;
import fr.alphashadows77.dailychallenge.challengestype.Challenge;
import fr.alphashadows77.dailychallenge.challengestype.ItemChallenge;
import fr.alphashadows77.dailychallenge.challengestype.StatChallenge;

public class AdminsCommands implements CommandExecutor {

	@SuppressWarnings("unchecked")
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
				
				else if (args[0].equalsIgnoreCase("addstats"))
					player.sendMessage(Utils.getMessage("addstats-syntax"));
			
			}
			
			// Si on veut ajouter un challenge nécessitant des stats
			else if (args.length >= 2 && args[0].equalsIgnoreCase("addstats")){
				
				switch (args[1].toLowerCase()){
				case "add":
					
					if (args.length >= 4){
						
						//Récupération de la stat et de la quantité
						Statistic stat;
						int amount;
						
						try{
							stat = Statistic.valueOf(args[2].toUpperCase());
						} catch(IllegalArgumentException e){
							player.sendMessage(Utils.getMessage("stat-not-found"));
							return true;
						}
						
						try{
							amount = Integer.parseInt(args[3]);
						} catch (NumberFormatException e){
							player.sendMessage(Utils.getMessage("not-a-number"));
							return true;
						}
						
						Challenge challenge = Utils.getPlayerChallenge(player);
						if (challenge == null || !(challenge instanceof StatChallenge)){
							challenge = new StatChallenge();
							Utils.setPlayerChallenge(player, challenge);
						}
						
						StatChallenge playerChallenge = (StatChallenge) Utils.getPlayerChallenge(player);
						
						if (args.length == 4){
							
							if (!stat.getType().equals(Type.UNTYPED)){
								player.sendMessage(Utils.getMessage("data-required"));
								return true;
							}
							
							if (playerChallenge.containsStat(stat)){
								player.sendMessage(Utils.getMessage("stat-exists"));
								return true;
							}
							
							Stat challengeStat = new Stat(stat, amount);
							((StatChallenge) challenge).addNeededStat(challengeStat);
														
						}
						
						else if (args.length == 5){
							
							if (stat.getType().equals(Type.UNTYPED)){
								player.sendMessage("data-not-required");
								return true;
							}
							
							if (playerChallenge.containsStat(stat, args[4])){
								player.sendMessage("stat-exists");
								return true;
							}
							
							Stat challengeStat = new Stat(stat, args[4], amount);
							((StatChallenge) challenge).addNeededStat(challengeStat);
							
						}
												
					}
					
					else
						player.sendMessage(Utils.getMessage("addstats-syntax"));
					
					break;
				
				case "remove":
					if (args.length == 3){
						
						//Récupération de la stat
						Statistic stat;
						
						try{
							stat = Statistic.valueOf(args[2]);
						} catch(IllegalArgumentException e){
							player.sendMessage(Utils.getMessage("stat-not-found"));
							return true;
						}
						
						((StatChallenge) Utils.getPlayerChallenge(player)).removeNeededStat(stat);
						
					}
					
					else if (args.length == 4){
						
						//Récupération de la stat
						Statistic stat;
						
						try{
							stat = Statistic.valueOf(args[2]);
						} catch(IllegalArgumentException e){
							player.sendMessage(Utils.getMessage("stat-not-found"));
							return true;
						}
						
						((StatChallenge) Utils.getPlayerChallenge(player)).removeNeededStat(stat, args[2]);
						
					}
					break;
					
				case "clearneed":
					((StatChallenge) Utils.getPlayerChallenge(player)).clearNeed();
					break;
					
				case "gift":
					Utils.toGift(player);
					break;
				
				case "list":
					StatChallenge challenge = ((StatChallenge) Utils.getPlayerChallenge(player));
					if (challenge == null || ((Set<Stat>) challenge.getNeed()).isEmpty()){
						player.sendMessage(Utils.getMessage("no-need"));
						return true;
					}
					for (String needLine : challenge.needToString()){
						player.sendMessage(needLine);
					}

					break;
					
				default:
					player.sendMessage(Utils.getMessage("addstats-syntax"));
					break;
					
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
