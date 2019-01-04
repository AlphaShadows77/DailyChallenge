package fr.alphashadows77.dailychallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	
	@SuppressWarnings("unchecked")
	@EventHandler
	public void onClick(InventoryClickEvent e){
		
		Inventory inventory = e.getClickedInventory();
		
		//Menu principal des challenges
		if (inventory.getHolder() == null && e.getClickedInventory().getTitle().equalsIgnoreCase(Utils.getMessage("challenge-title"))){
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
			}
			
			if (challengesConfig.getStringList(frequency + "success").contains(player.getName()))
				player.sendMessage(Utils.getMessage("already-do-challenge"));
			
			else{
				
				String path = frequency + "." + challengesConfig.getString(frequency + "now");
				Challenge challenge = (Challenge) challengesConfig.get(path);
				String dontHave = "";
				if (challenge instanceof ItemChallenge){
					
					ItemChallenge itemChallenge = (ItemChallenge) challenge;
					//Vérification pour savoir si les items nécessaires sont présents dans l'inventaire du joueur
					for (ItemStack need : (Set<ItemStack>) itemChallenge.getNeed()){
						
						nombreItem = 0;
						Material needType = need.getType();
						short needDamage = need.getDurability();
						if (!player.getInventory().contains(needType)){
							
							if (needDamage != 0)
								dontHave += Utils.makesBeautiful(ItemsWithData.getValue(need.getType(), needDamage).toString());
							
							else
								dontHave += Utils.makesBeautiful(needType.toString());
							
						}
						
						else{
							
							for (ItemStack item : player.getInventory().getContents()){
								
								if (item.isSimilar(need))
									nombreItem += item.getAmount();
								
							}
							
							if (nombreItem < need.getAmount()){
								
								if (needDamage != 0)
									dontHave += Utils.makesBeautiful(ItemsWithData.getValue(need.getType(), needDamage).toString());
								
								else
									dontHave += Utils.makesBeautiful(needType.toString());
								
							}
							
						}
						
					}
					
					if (dontHave.equals("")){
							
						//Récupération des items nécessaires
						for (ItemStack need : (Set<ItemStack>) itemChallenge.getNeed()){
							
							nombreItem = need.getAmount();
							for (int slot = 0; slot < inventory.getContents().length; slot++){
								
								ItemStack item = inventory.getItem(slot);
								
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
					
					else
						player.sendMessage(Utils.getMessage("dont-have-items-message").replaceAll("%item%", dontHave));
					
				}
				
				else{
					
					StatChallenge statChallenge = (StatChallenge) challenge;
					Set<Stat> need = (Set<Stat>) statChallenge.getNeed();
					
					if (challengesConfig.get(frequency + "playersstats." + player.getName()) == null){
						
						for (Stat tmpNeed : need){
							
							int playerStat;
							Statistic stat = tmpNeed.getStat();
							Object needData = tmpNeed.getData();
							
							if (needData == null)
								playerStat = player.getStatistic(stat);
							
							else if (needData instanceof EntityType)
								playerStat = player.getStatistic(stat, (EntityType) needData);
							
							else
								playerStat = player.getStatistic(stat, (Material) needData);
														
							challengesConfig.set(frequency + "playersstats." + player.getName() + "." + stat.toString() + "_" + needData.toString(), playerStat);
							
						}
						
						Utils.saveCustomConfig("challenges");
						player.sendMessage(Utils.getMessage("start-challenge-stat-message"));
						
					}
					
					else{
						
						for (Stat tmpNeed : need){
							
							int playerStat;
							Statistic stat = tmpNeed.getStat();
							Object needData = tmpNeed.getData();
							
							if (needData == null)
								playerStat = player.getStatistic(stat);
							
							else if (needData instanceof EntityType)
								playerStat = player.getStatistic(stat, (EntityType) needData);
							
							else
								playerStat = player.getStatistic(stat, (Material) needData);
							
							if (challengesConfig.getInt(frequency + "playersstats." + player.getName() + "." + stat.toString() + "_" + needData.toString()) + tmpNeed.getAmount() >= playerStat)
								dontHave += stat.toString() + "_" + needData.toString();
							
						}
						
						if (dontHave != "")
							player.sendMessage(Utils.getMessage("dont-have-stats-message").replaceAll("%stat%", dontHave));
						
					}
					
				}
				
				if (dontHave == ""){
					
					Gift gifts = challenge.getGift();
					
					//Vérification pour savoir si il y a une récompense d'items à la clé et ajout dans l'inventaire du joueur si c'est le cas
					if (!challenge.getGift().getItemList().isEmpty()){
						
						for (ItemStack gift : challenge.getGift().getItemList()){
							player.getInventory().addItem(gift);
						}
						
					}
					
					player.giveExp(gifts.getXp());
					
					//Ajout d'uniz
					RegisteredServiceProvider<Economy> rsp = Bukkit.getServicesManager().getRegistration(Economy.class);
					
					if (rsp != null){
						Economy eco = rsp.getProvider();
						eco.bankDeposit(player.getName(), gifts.getMoney());
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
		
	}
	
}
