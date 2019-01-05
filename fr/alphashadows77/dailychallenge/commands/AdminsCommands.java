package fr.alphashadows77.dailychallenge.commands;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.Statistic.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.avaje.ebeaninternal.server.deploy.BeanDescriptor.EntityType;

import fr.alphashadows77.dailychallenge.ItemsWithData;
import fr.alphashadows77.dailychallenge.Stat;
import fr.alphashadows77.dailychallenge.Utils;
import fr.alphashadows77.dailychallenge.challengestype.Challenge;
import fr.alphashadows77.dailychallenge.challengestype.ChallengeFrequency;
import fr.alphashadows77.dailychallenge.challengestype.ItemChallenge;
import fr.alphashadows77.dailychallenge.challengestype.StatChallenge;

public class AdminsCommands implements CommandExecutor {

	@SuppressWarnings("unchecked")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (Utils.isCommand(label, "allowdailychallenge")){
			boolean isNowAllowed = !Utils.getBoolean("allow-dailychallenge");
			Utils.setValue("allow-dailychallenge", isNowAllowed);
			Utils.saveMainConfig();
			sender.sendMessage(Utils.getMessage("allowdailychallenge-switch-" + (isNowAllowed ? "on" : "off")));
		}
		
		else if (Utils.isCommand(label, "forcechallenge")){
			if (args.length >= 2){
				
				String frequency = args[0].toLowerCase();
				String challengeName = Utils.removeArgs(Utils.combineArgs(args), new String[] {args[0]});
				
				if (!(frequency.equals("daily") || frequency.equals("weekly") || frequency.equals("monthly")))
					return false;
				
				Utils.changePeriodicChallenge(frequency, challengeName);
				
				sender.sendMessage(Utils.getMessage("change-" + frequency + "-challenge-success"));
				
				return true;
				
			}
			
			else
				return false;
		}

		if (!(sender instanceof Player))
			return true;
		
		final Player player = (Player) sender;
		
		if (Utils.isCommand(label, "modifychallenge")){
			
			if (args.length == 1){
			
				// Si on veut ajouter un challenge nécessitant des items
				if (args[0].equalsIgnoreCase("additems")){
					
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
				
				else
					return false;
			
			}
			
			// Si on veut ajouter un challenge nécessitant des stats
			else if (args.length >= 2 && args[0].equalsIgnoreCase("addstats")){
				
				Challenge tmpChallenge = Utils.getPlayerChallenge(player);
				StatChallenge challenge;
				if (tmpChallenge == null || !(tmpChallenge instanceof StatChallenge)){
					challenge = new StatChallenge();
					Utils.setPlayerChallenge(player, challenge);
				}
				
				else
					challenge = (StatChallenge) tmpChallenge;
				
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
																		
						if (args.length == 4){
							
							if (!stat.getType().equals(Type.UNTYPED)){
								player.sendMessage(Utils.getMessage("data-required"));
								return true;
							}
							
							if (challenge.containsStat(stat)){
								player.sendMessage(Utils.getMessage("stat-exists"));
								return true;
							}
							
							Stat challengeStat = new Stat(stat, amount);
							challenge.addNeededStat(challengeStat);
							
							player.sendMessage(Utils.getMessage("stat-added"));
														
						}
						
						else if (args.length == 5){
							
							if (stat.getType().equals(Type.UNTYPED)){
								player.sendMessage(Utils.getMessage("data-not-required"));
								return true;
							}
							
							if (challenge.containsStat(stat, args[4])){
								player.sendMessage(Utils.getMessage("stat-exists"));
								return true;
							}
							
							Object data = (stat.getType().equals(Type.BLOCK) || stat.getType().equals(Type.ITEM)) ? Material.valueOf(args[4].toUpperCase()) : EntityType.valueOf(args[4].toUpperCase());
							Stat challengeStat = new Stat(stat, data, amount);
							challenge.addNeededStat(challengeStat);
							
							player.sendMessage(Utils.getMessage("stat-added"));
							
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
						
						challenge.removeNeededStat(stat);
						
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
						
						challenge.removeNeededStat(stat, args[2]);
						
					}
					break;
					
				case "clearneed":
					challenge.clearNeed();
					break;
					
				case "gift":
					Utils.toGift(player);
					break;
				
				case "list":
					if (((Set<Stat>) challenge.getNeed()).isEmpty()){
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
			
			else if (args.length == 2 && args[0].equalsIgnoreCase("list")){
				
				String frequency = args[1].toLowerCase();
				String answer = "";
				
				for (String challengeName : Utils.getCustomConfig("challenges").getConfigurationSection(frequency).getKeys(false)){
					answer += challengeName + ", ";
				}
				
				answer = answer.substring(0, answer.length() - 2);
				
				player.sendMessage(frequency + ": " + answer);
				
			}
			
			else if (args.length >= 3 && args[0].equalsIgnoreCase("info")){
				
				String frequency = args[1].toLowerCase();
				String challengeName = Utils.removeArgs(Utils.combineArgs(args), new String[] {args[0], args[1]});
				
				Challenge challenge = (Challenge) Utils.getCustomConfig("challenges").get(frequency + "." + challengeName);
				
				if (!challenge.getNeed().isEmpty()){
				
					String needAnswer = "Need: ";
					
					if (challenge instanceof ItemChallenge){
					
						for (ItemStack item : (Set<ItemStack>) challenge.getNeed()){
							
							String itemName = item.getDurability() == 0 ? Utils.makesBeautiful(item.getType().toString()) : Utils.makesBeautiful(ItemsWithData.getValue(item.getType(), item.getDurability()).toString());
							int amount = item.getAmount();
							
							needAnswer += itemName + "(" + amount + ")" + ", ";
							
						}
					
					}
					
					else {
						
						for (Stat stat : (Set<Stat>) challenge.getNeed()){
							
							String statName = Utils.makesBeautiful(stat.getStat().toString());
							int amount = stat.getAmount();
							
							if (!stat.getStat().getType().equals(Type.UNTYPED)){
								
								statName += "_" + stat.getData().toString();
								
							}
							
							needAnswer += statName + "(" + amount + ")" + ", ";
							
						}
						
					}
					
					needAnswer = needAnswer.substring(0, needAnswer.length() - 2);
					
					player.sendMessage(needAnswer);
				
				}
				
				if (!challenge.getGift().getItemList().isEmpty()){
				
					String giftAnswer = "";
					
					for (ItemStack item : challenge.getGift().getItemList()){
						
						String itemName = item.getDurability() == 0 ? Utils.makesBeautiful(item.getType().toString()) : Utils.makesBeautiful(ItemsWithData.getValue(item.getType(), item.getDurability()).toString());
						int amount = item.getAmount();
						
						giftAnswer += itemName + "(" + amount + ")" + ", ";
						
					}
					
					giftAnswer = giftAnswer.substring(0, giftAnswer.length() - 2);
				
				}
				
				player.sendMessage("Uniz: " + challenge.getGift().getMoney());
				player.sendMessage("Xp: " + challenge.getGift().getXp());
				
			}
			
			else if (args.length >= 3 && args[0].equalsIgnoreCase("remove")){
				
				String frequency = args[1].toLowerCase();
				String challengeName = Utils.removeArgs(Utils.combineArgs(args), new String[] {args[0], args[1]});
				
				Utils.getCustomConfig("challenges").set(frequency + "." + challengeName, null);
				Utils.saveCustomConfig("challenges");
				
			}
			
			// Permet de choisir le nom du challenge une fois que ce qui est nécessaire et les récompenses ont été définis				
			else if (args.length >= 5 && args[0].equalsIgnoreCase("add")){
				
				// Si les items récompenses ont été choisis
				if (!Utils.isNeeded(player)){
					player.sendMessage(Utils.getMessage("can_not-add"));
					return true;
				}
				
				String frequency = args[1].toUpperCase();
				
				if (frequency.equals("DAILY") || frequency.equals("WEEKLY") || frequency.equals("MONTHLY")){
				
					double money = 0.0;
					short xp = 0;
					
					try{
						money = Double.parseDouble(args[2]);
						xp = Short.parseShort(args[3]);
					}
					catch(NumberFormatException e) {return false;}
					
					
					Challenge challenge = Utils.getPlayerChallenge(player);
					
					challenge.setFrequency(ChallengeFrequency.valueOf(frequency));
					
					challenge.getGift().setMoney(money);
					challenge.getGift().setXp(xp);
					
					String name = Utils.removeArgs(Utils.combineArgs(args), new String[] {args[0], args[1], args[2], args[3]});
					challenge.setName(name);
					
					Utils.setChallengeInConfig(challenge);
					Utils.removePlayerChallenge(player);
					Utils.resetNeed(player);
					
					player.sendMessage(Utils.getMessage("challenge-added"));
					
				}
				
			}
			
			else
				return false;
			
			return true;
			
		}
		
		return false;
		
	}

}
