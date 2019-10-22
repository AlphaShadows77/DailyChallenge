package fr.alphashadows77.dailychallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.RegisteredServiceProvider;

import fr.alphashadows77.dailychallenge.challengestype.Challenge;
import fr.alphashadows77.dailychallenge.challengestype.ItemChallenge;
import fr.alphashadows77.dailychallenge.challengestype.StatChallenge;
import net.milkbowl.vault.economy.Economy;

public class InventoryEvents implements Listener {
	
	@EventHandler
	public void onClose(InventoryCloseEvent e){
				
		Inventory inventory = e.getInventory();
		String inventoryTitle = inventory.getTitle();
		String addChallengeTitle = Utils.getMessage("title-add_challenge_inventory");
		
		if (inventory.getHolder() == null && inventoryTitle.equalsIgnoreCase(addChallengeTitle)){
			
			Player player = (Player) e.getPlayer();
			Challenge playerChallenge = Utils.getPlayerChallenge(player);
			
			if (playerChallenge.getNeed() == null && playerChallenge instanceof ItemChallenge)
				Utils.toGift(player, inventory.getContents());
			
			else
				Utils.addChallenge(player, inventory.getContents());
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(InventoryClickEvent e){
		
		Inventory inventory = e.getClickedInventory();
		String inventoryTitle = inventory.getTitle();
		
		//Menu principal des challenges
		if (inventory != null && inventory.getHolder() == null){
			
			if (inventoryTitle.equalsIgnoreCase(Utils.getMessage("challenge-title"))) {
			
				e.setCancelled(true);
				
				Player player = (Player) e.getWhoClicked();
				FileConfiguration challengesConfig = Utils.getCustomConfig("challenges");
				int nombreItem = 0;
				String frequency = "";
				switch (e.getSlot()){
				
				case 2:
					frequency = "daily";
					break;
				
				case 11:
					frequency = "weekly";
					break;
				
				case 20:
					frequency = "monthly";
					break;
				
				default:
					return;
					
				}
				
				if (challengesConfig.getStringList(frequency + "success").contains(player.getName()))
					player.sendMessage(Utils.getMessage("already-did-challenge"));
				
				else{
					
					String path = frequency + "." + challengesConfig.getString(frequency + "now");
					Challenge challenge = (Challenge) challengesConfig.get(path);
					String dontHave = "";
					if (challenge instanceof ItemChallenge){
						
						ItemChallenge itemChallenge = (ItemChallenge) challenge;
						
						if (itemChallenge.getNeed().length != 0){
						
							//Vérification pour savoir si les items nécessaires sont présents dans l'inventaire du joueur
							for (ItemStack need : (ItemStack[]) itemChallenge.getNeed()){
															
								nombreItem = 0;
								Material needType = need.getType();
								short needDamage = need.getDurability();
							
								for (ItemStack item : player.getInventory().getContents()){
									
									if (item == null)
										continue;
									
									if (item.isSimilar(need))
										nombreItem += item.getAmount();
									
								}
								
								if (nombreItem < need.getAmount()){
									
									int diff = need.getAmount() - nombreItem;
									dontHave += " " + Integer.toString(diff);
									
									if (needDamage != 0)
										dontHave += " " + Utils.makesBeautiful(ItemsWithData.getValue(needType, needDamage).toString());
									
									else {
										dontHave += " " + Utils.makesBeautiful(needType.toString());
										
										String potionName = Utils.getPotionName(need);
										if (!potionName.equals("")) {
											dontHave += " (" + potionName + ")";
										}
										
										String enchantmentsName = EnchantmentsName.getEnchantsNames(need);
										if (enchantmentsName != null) {
											dontHave += " (" + enchantmentsName + ")";
										}
										
									}
									
									dontHave += ",";
									
								}
																
							}
						
						}
						
						if (dontHave.equals("")){
							
							if (itemChallenge.getNeed() != null){
							
								//Récupération des items nécessaires
								for (ItemStack need : (ItemStack[]) itemChallenge.getNeed()){
									
									nombreItem = need.getAmount();
									Inventory playerInventory = player.getInventory();
									for (int slot = 0; slot < playerInventory.getContents().length; slot++){
										
										ItemStack item = playerInventory.getItem(slot);
										
										if (item == null)
											continue;
										
										if (item.isSimilar(need)){
																					
											if (item.getAmount() <= nombreItem){
												nombreItem -= item.getAmount();
												player.getInventory().removeItem(item);
											}
										
											else{
												item.setAmount(item.getAmount() - nombreItem);
												player.getInventory().setItem(slot, item);
												nombreItem = 0;
											}
											
											if (nombreItem == 0)
												break;
											
										}
										
									}
																	
								}
														
							}
							
						}
						
						else {
							dontHave = dontHave.substring(0, dontHave.length() - 1); // Allows to remove the last ","
							String missingItemsMessage = Utils.getMessage("dont-have-items-message");
							missingItemsMessage = missingItemsMessage.replaceAll("%item%", dontHave);
							player.sendMessage(missingItemsMessage);
						}
					}
					
					else{
						
						StatChallenge statChallenge = (StatChallenge) challenge;
						Stat[] need = (Stat[]) statChallenge.getNeed();
						
						if (challengesConfig.get(frequency + "playersstats." + player.getName()) == null){
							
							if (need.length != 0){
							
								for (Stat tmpNeed : need){
									
									int playerStat = 0;
									Statistic stat = tmpNeed.getStat();
									Object needData = tmpNeed.getData();
									String statName;
									
									if (needData == null){
										statName = stat.toString();
										playerStat = player.getStatistic(stat);
									}
									
									else if (needData instanceof EntityType){
										
										EntityType entityType = (EntityType) needData;
										statName = stat.toString() + "_" + needData.toString();
										
										playerStat = player.getStatistic(stat, entityType);
																			
									}
									
									else{
										statName = stat.toString() + "_" + needData.toString();
										playerStat = player.getStatistic(stat, (Material) needData);
									}
																								
									challengesConfig.set(frequency + "playersstats." + player.getName() + "." + statName, playerStat);
									
								}
								
								Utils.saveCustomConfig("challenges");
								player.sendMessage(Utils.getMessage("start-challenge-stat-message"));
								
								return;
							
							}
							
						}
						
						else{
							
							for (Stat tmpNeed : need){
								
								int playerStat;
								Statistic stat = tmpNeed.getStat();
								Object needData = tmpNeed.getData();
								String statName;
								
								if (needData == null){
									statName = stat.toString();
									playerStat = player.getStatistic(stat);
								}
								
								else if (needData instanceof EntityType){
									
									EntityType entityType = (EntityType) needData;
									statName = stat.toString() + "_" + needData.toString();
									
									playerStat = player.getStatistic(stat, entityType);
	
								}
								
								else{
									statName = stat.toString() + "_" + needData.toString();
									playerStat = player.getStatistic(stat, (Material) needData);
								}
								
								int needAmount = challengesConfig.getInt(frequency + "playersstats." + player.getName() + "." + statName) + tmpNeed.getAmount();
								if (needAmount > playerStat){
									String name = StatsWithItem.getValue(stat).getNom();
									int diff = needAmount - playerStat;
									if (StatsWithItem.getValue(stat).getUnit() != null){
										switch (StatsWithItem.getValue(stat).getUnit()) {
										case DISTANCE_CM:
											diff /= 100;
											break;
										
										case TIME_TICK:
											diff /= 20;
											break;
										}
									}
									dontHave += " " + Integer.toString(diff) + " ";
									dontHave += (name.contains("%data%") ? name.replaceAll("%data%", Utils.makesBeautiful(needData.toString())) : name) + ",";
								}
								
							}
							
							if (dontHave != "") {
								dontHave = dontHave.substring(0, dontHave.length() - 1); // Allows to remove the last ","
								String missingStatsMessage = Utils.getMessage("dont-have-stats-message");
								missingStatsMessage = missingStatsMessage.replaceAll("%stat%", dontHave);
								player.sendMessage(missingStatsMessage);
							}
						}
						
					}
					
					if (dontHave == ""){
						
						Gift gifts = challenge.getGift();
						
						//Vérification pour savoir si il y a une récompense d'items à la clé et ajout dans l'inventaire du joueur si c'est le cas
						if (challenge.getGift().getItemList().length != 0){
							
							for (ItemStack gift : challenge.getGift().getItemList()){
								player.getInventory().addItem(gift);
							}
							
						}
						
						player.giveExp(gifts.getXp());
						
						//Ajout d'uniz
						RegisteredServiceProvider<Economy> rsp = Bukkit.getServicesManager().getRegistration(Economy.class);
						
						if (rsp != null){
							Economy eco = rsp.getProvider();
							eco.depositPlayer(Bukkit.getOfflinePlayer(player.getName()), gifts.getMoney());
						}
						
						player.sendMessage(Utils.getMessage("congratulation-" + frequency + "-challenge-message"));
						
						if (frequency.equalsIgnoreCase("weekly") || frequency.equalsIgnoreCase("monthly"))
							Bukkit.broadcastMessage(Utils.getMessage("congratulation-" + frequency + "-challenge-broadcast").replaceAll("%player%", player.getName()));
						
						List<String> playerSuccess = challengesConfig.getStringList(frequency + "success");
						
						if (playerSuccess == null)
							playerSuccess = new ArrayList<String>();
						
						playerSuccess.add(player.getName());
						challengesConfig.set(frequency + "success", playerSuccess);
						
						Utils.saveCustomConfig("challenges");
						
					}
					
				}
			
			}
			
			else if (inventoryTitle.equalsIgnoreCase(Utils.getMessage("info-title"))) {
				
				e.setCancelled(true);
				
				// Permet de vérifier si on est dans le menu permettant de choisir les sous-menus)
				if (inventory.getSize() == 9) {
					
					ItemStack clickedItem = e.getCurrentItem();
					Material type = clickedItem.getType();
					
					PlayerInfos playerInfos = Main.getPlayerInfos();
					Player player = (Player) e.getWhoClicked();
					UUID playerUUID = player.getUniqueId();
					Challenge challenge = playerInfos.getChallenge(playerUUID);
					
					Material needType = Material.valueOf(Utils.getString("mc_info-item-need"));
					Material giftType = Material.valueOf(Utils.getString("mc_info-item-gift"));
					
					Inventory subMenu = null;
					
					if (type == needType) {
						
						if (challenge instanceof ItemChallenge) {
							ItemChallenge itemChallenge = (ItemChallenge) challenge;
							subMenu = Utils.getNeedSubInfoMenu(itemChallenge);
						}
						
						else if (challenge instanceof StatChallenge) {
							StatChallenge statChallenge = (StatChallenge) challenge;
							player.closeInventory();
							Utils.showStats(player, statChallenge);
						}
						
					}
					
					else if (type == giftType) {
						subMenu = Utils.getGiftSubInfoMenu(challenge);
					}
					
					player.openInventory(subMenu);
					
				}
				
			}
		}
		
	}
	
}
