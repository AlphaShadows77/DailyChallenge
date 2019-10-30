package fr.alphashadows77.dailychallenge.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.alphashadows77.dailychallenge.EnchantmentsName;
import fr.alphashadows77.dailychallenge.ItemsWithData;
import fr.alphashadows77.dailychallenge.Stat;
import fr.alphashadows77.dailychallenge.StatsWithItem;
import fr.alphashadows77.dailychallenge.Utils;
import fr.alphashadows77.dailychallenge.challengestype.Challenge;
import fr.alphashadows77.dailychallenge.challengestype.ItemChallenge;

public class PlayersCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player){
			Player player = (Player) sender;	
			
			if (Utils.isCommand(label, "dailychallenge")){
								
				// Si la commande est activée
				if (Utils.getBoolean("allow-dailychallenge")){
						
					Inventory menu = Bukkit.createInventory(null, 27, Utils.getMessage("challenge-title")); //Création du menu principale des challenges
					// On place les items représentant les différentes sections dans le menu
					ItemStack itemSection = new ItemStack(Material.WATCH);
					menu.setItem(0, modifyForGui(itemSection, Utils.getMessage("daily-challenge-item"), true));
					menu.setItem(9, modifyForGui(itemSection, Utils.getMessage("weekly-challenge-item"), true));
					menu.setItem(18, modifyForGui(itemSection, Utils.getMessage("monthly-challenge-item"), true));
					
					byte index = 0;
					
					FileConfiguration challengesConfig = Utils.getCustomConfig("dailychallenges");
					
					for (String tempFrequency : new String[] {"daily", "weekly", "monthly"}){
						
						String path = tempFrequency + "." + challengesConfig.getString(tempFrequency + "now");
						Challenge challenge = (Challenge) challengesConfig.get(path);
						
						if (challenge == null){
							
							player.sendMessage(Utils.getMessage("error-dailychallenge-disabled"));
							
							return true;
							
						}
						
						String nowType = challenge instanceof ItemChallenge ? "items" : "stats";
						
						ArrayList<String> lore = new ArrayList<String>();
						List<String> loreConfig = Utils.getMessageList("lore-" + nowType + "-challenge");
						// Modifie les données modifiables (%need%, %gift%, ...) du lore de la config
						for (String lineLore : loreConfig){
														
							if (lineLore.contains("%need%")){
								
								if (challenge.getNeed().length != 0){
								
									for (Object need : challenge.getNeed()){
										
										if (nowType == "items"){
											ItemStack item = (ItemStack) need;
											String tempLineLoreNeed = lineLore.replaceAll("%amount%", Integer.toString(item.getAmount()));
											ItemsWithData itemWithData = ItemsWithData.getValue(item.getType(), item.getDurability());											
											String itemName = itemWithData != null ? Utils.makesBeautiful(itemWithData.toString()) : Utils.makesBeautiful(item.getType().toString());
											
											String potionName = Utils.getPotionName(item);
											if (!potionName.equals("")) {
												itemName += " (" + potionName + ")";
											}

											String enchantsName = EnchantmentsName.getEnchantsNames(item);
											if (enchantsName != null) {
												itemName += " (" + enchantsName + ")";
											}
											
											tempLineLoreNeed = tempLineLoreNeed.replaceAll("%need%", itemName);
											
											lore.add(tempLineLoreNeed);
										}
										
										else{
											Stat stat = (Stat) need;
											String line = Utils.getReadableStat(lineLore, stat);
											lore.add(line);
										}
										
									}
								
								}
								
								else
									lore.add(Utils.getMessage("lore-nothing-need"));
								
							}
							
							else if (lineLore.contains("%gift%")){
								
								if(challenge.getGift().getItemList().length == 0)
									lore.add(Utils.getMessage("lore-nothing-gift"));
								
								else{
									
									for (ItemStack tmpGift : challenge.getGift().getItemList()){
										String tempLineLoreGift = lineLore.replaceAll("%amount%", Integer.toString(tmpGift.getAmount()));
										ItemsWithData itemWithData = ItemsWithData.getValue(tmpGift.getType(), tmpGift.getDurability());
										String itemName = itemWithData != null ? Utils.makesBeautiful(itemWithData.toString()) : Utils.makesBeautiful(tmpGift.getType().toString());
										
										String potionName = Utils.getPotionName(tmpGift);
										if (!potionName.equals("")) {
											itemName += " (" + potionName + ")";
										}
										
										String enchantsName = EnchantmentsName.getEnchantsNames(tmpGift);
										if (enchantsName != null) {
											itemName += " (" + enchantsName + ")";
										}
										
										tempLineLoreGift = tempLineLoreGift.replaceAll("%gift%", itemName);
										lore.add(tempLineLoreGift);
									}
									
								}
								
							}
							
							else if (lineLore.contains("%uniz%")){
								lore.add(lineLore.replaceAll("%uniz%", Double.toString(challenge.getGift().getMoney())));
							}
							
							else if (lineLore.contains("%xp%")){
								lore.add(lineLore.replaceAll("%xp%", Double.toString(challenge.getGift().getXp())));
							}
							else
								lore.add(lineLore);
							
						}
						lore.add(Utils.getMessage("end-lore-items-" + tempFrequency + "-challenge"));
						ItemStack item;
						
						if (nowType == "items"){
							
							if (challenge.getNeed().length != 0)
								item = new ItemStack((ItemStack) challenge.getNeed()[0]);
							
							else
								item = new ItemStack(Material.BARRIER);
							
						}
						
						else
							item = StatsWithItem.getValue(((Stat) challenge.getNeed()[0]).getStat()).getItem();
						
						// Place l'item représentant le challenge dans le menu
						menu.setItem(2 + 9 * index, modifyForGui(item, "§a" + challenge.getName(), false, lore));
						List<String> playerSuccess = challengesConfig.getStringList(tempFrequency + "success");
						int playerSuccessNumber = (playerSuccess == null ? 0 : playerSuccess.size());
						// Place l'item montrant le nombre de joueurs ayant réussi le challenge dans le menu
						menu.setItem(8 + 9 * index, modifyForGui(new ItemStack(Material.SKULL_ITEM, 1, (short) 3), Utils.getMessage("success-number").replaceAll("%number%", Integer.toString(playerSuccessNumber)), false));
						index++;
						
					}
					
					player.openInventory(menu);
				}
				
				else
					player.sendMessage(Utils.getMessage("error-dailychallenge-disabled"));
			}
				
		}
		
		return false;
		
	}
		
	// Permet de modifier un item pour lui ajouter un nom et un effet d'enchantement si besoin
	private ItemStack modifyForGui(ItemStack pItem, String pName, boolean pEnchant){
		ItemMeta itemMeta = pItem.hasItemMeta() ? pItem.getItemMeta() : Bukkit.getItemFactory().getItemMeta(pItem.getType());
		itemMeta.setDisplayName("§r" + pName);
		itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS,
							  ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS,
							  ItemFlag.HIDE_UNBREAKABLE);
		if (pEnchant){
			itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		}
		pItem.setItemMeta(itemMeta);
		pItem.setAmount(1);
		return pItem;
	}
		
	// Permet de modifier un item pour lui ajouter un nom, un effet d'enchantement si besoin et un lore
	private ItemStack modifyForGui(ItemStack pItem, String pName, boolean pEnchant, ArrayList<String> pLore){
		ItemStack item = modifyForGui(pItem, pName, pEnchant);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setLore(pLore);
		item.setItemMeta(itemMeta);
		return item;
	}

}
