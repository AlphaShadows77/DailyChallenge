package fr.alphashadows77.dailychallenge;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.alphashadows77.dailychallenge.challengestype.Challenge;

public class Utils {
	
	//Variables
	private static Main main;
	private static Map<Player, Challenge> challenges = new HashMap<Player, Challenge>();
	private static Set<Player> needName = new HashSet<Player>();
	
	protected static void setMain(Main pMain){
		main = pMain;
	}
	
	public static void setPlayerChallenge(Player pPlayer, Challenge pChallenge){
		challenges.put(pPlayer, pChallenge);
	}
	
	public static Challenge getPlayerChallenge(Player pPlayer){
		return challenges.get(pPlayer);
	}
	
	
	public static boolean needSet(Player pPlayer){
		return challenges.get(pPlayer).getNeed() != null;
	}
	
	public static void toGift(Player pPlayer, ItemStack[] pItemList){
		
		Set<ItemStack> sortedItemList = sortItems(pItemList);
		challenges.get(pPlayer).setNeed(sortedItemList);		
		giftInventory(pPlayer);
		
	}
	
	public static void toGift(Player pPlayer, String t){
		
		//Ici ce sera pour les stats
		challenges.get(pPlayer).setNeed(t);
		
	}
	
	public static void giftInventory(Player pPlayer){
		
		final byte inventorySize = 36;
		final String inventoryTitle = Utils.getMessage("title-add_challenge_inventory");
		
		final Inventory itemsAddInventory = Bukkit.createInventory(null, inventorySize, inventoryTitle);
		
		pPlayer.sendMessage(Utils.getMessage("inventory-opened-need-item"));
		pPlayer.openInventory(itemsAddInventory);
		
	}
	
	public static void addChallenge(Player pPlayer, ItemStack[] pItemList){
		
		Set<ItemStack> sortedItemList = sortItems(pItemList);
		challenges.get(pPlayer).setGift(new Gift(sortedItemList));
		
		pPlayer.closeInventory();
		pPlayer.sendMessage(Utils.getMessage("need-challenge-name"));
		needName.add(pPlayer);
		
	}
	
	@SuppressWarnings("unchecked")
	public static void setChallengeInConfig(Challenge pChallenge){
		
		FileConfiguration challengesConfig = main.getCustomConfig("challenges");
		List<Object> challengesList = (List<Object>) challengesConfig.getList("challenges");
		challengesList.add((Object) pChallenge);
		challengesConfig.set("challenges", challengesList);
		
		saveCustomConfig("challenges");
		
	}
	
	public static void resetNeed(Player pPlayer){
		needName.remove(pPlayer);
	}
	
	
	public static String combineArgs(String[] args){
		
		String argsCombined = "";
		
		for (int i = 0; i < args.length; i++){
			argsCombined += args[i] + " ";
		}
		
		argsCombined = argsCombined.substring(0, argsCombined.length() - 1);
		
		return argsCombined;
		
	}
	
	public static Set<ItemStack> sortItems(ItemStack[] pItemList){
		
		final Set<ItemStack> finalList = new HashSet<ItemStack>();
		
		for (ItemStack tmpItem : pItemList){
			
			Iterator<ItemStack> it = finalList.iterator();
			boolean continueWhile = true;
			while (it.hasNext() && continueWhile){
				
				ItemStack tmpFinalItem = it.next();
				if (isSameItems(tmpItem, tmpFinalItem)){
					
					tmpFinalItem.setAmount(tmpItem.getAmount() + tmpFinalItem.getAmount());
					it.remove();
					finalList.add(tmpFinalItem);
					continueWhile = false;
					
				}
				
			}
			
		}
		
		
		return finalList;
		
	}
	
	private static boolean isSameItems(ItemStack pFirstItem, ItemStack pSecondItem){
		
		pFirstItem.setAmount(0);
		pSecondItem.setAmount(0);
		
		return pFirstItem == pSecondItem;
		
		
	}
	
	
	//Configs
	public static String getString(String pKey){
		return main.getMainConfig().getString(pKey);
	}
	
	public static String getMessage(String pKey){
		return main.getCustomConfig("message").getString(pKey);
	}
	
	public static void saveCustomConfig(String pKey){
		try {
			main.getCustomConfig(pKey).save(pKey + ".yml");
		}
		catch (IOException e) {e.printStackTrace();}
	}
}
