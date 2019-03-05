package fr.alphashadows77.dailychallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
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
	
	public static Main getMain(){
		return main;
	}
	
	public static void setPlayerChallenge(Player pPlayer, Challenge pChallenge){
		challenges.put(pPlayer, pChallenge);
	}
	
	public static Challenge getPlayerChallenge(Player pPlayer){
		return challenges.get(pPlayer);
	}
	
	public static void removePlayerChallenge(Player pPlayer){
		challenges.remove(pPlayer);
	}
	
	
	public static boolean needSet(Player pPlayer){
		return challenges.get(pPlayer).getNeed() != null;
	}
	
	public static void toGift(Player pPlayer, ItemStack[] pItemList){
		ItemStack[] sortedItemList = sortItems(pItemList);
		challenges.get(pPlayer).setNeed(sortedItemList);
		pPlayer.sendMessage(Utils.getMessage("save-need-need-gift"));
	}
	
	public static void toGift(Player pPlayer){
		giftInventory(pPlayer);
	}
	
	public static void giftInventory(Player pPlayer){
		
		final byte inventorySize = 36;
		final String inventoryTitle = Utils.getMessage("title-add_challenge_inventory");
		
		final Inventory itemsAddInventory = Bukkit.createInventory(null, inventorySize, inventoryTitle);
		pPlayer.openInventory(itemsAddInventory);
		pPlayer.sendMessage(Utils.getMessage("inventory-opened-need-item"));
		
	}
	
	public static void addChallenge(Player pPlayer, ItemStack[] pItemList){
		
		ItemStack[] sortedItemList = sortItems(pItemList);
		challenges.get(pPlayer).setGift(new Gift(sortedItemList));
		
		pPlayer.sendMessage(Utils.getMessage("need-challenge-name"));
		needName.add(pPlayer);
		
	}
	
	public static void setChallengeInConfig(Challenge pChallenge){
		
		FileConfiguration challengesConfig = main.getCustomConfig("challenges");
		String frequency = pChallenge.getFrequency().toString().toLowerCase();

		challengesConfig.set(frequency + "." + pChallenge.getName().toLowerCase().replaceAll(" ", "_"), pChallenge);
		
		saveCustomConfig("challenges");
		
	}
	
	public static boolean challengeExists(Challenge pChallenge){
		
		FileConfiguration challengesConfig = main.getCustomConfig("challenges");
		
		if (challengesConfig.getConfigurationSection(pChallenge.getFrequency().toString().toLowerCase()) == null) {
			return false;
		}
		
		for (String tmpChallengeName : main.getCustomConfig("challenges").getConfigurationSection(pChallenge.getFrequency().toString().toLowerCase()).getKeys(false)){
			
			if (pChallenge.getName().toLowerCase().replaceAll(" ", "_").equals(tmpChallengeName))
				return true;
			
		}
		
		return false;
		
	}
	
	public static void changePeriodicChallenge(String frequency, String challengeName){
		
		FileConfiguration challengesConfig = Utils.getCustomConfig("challenges");
		
		challengesConfig.set(frequency + "now", challengeName.toLowerCase());
		challengesConfig.set(frequency + "success", null); //Mise à zéro des joueurs ayant réussi le challenge actuel
		challengesConfig.set(frequency + "playersstats", null); //Mise à zéro des stats enregistrées des joueurs pour les challenges statistiques
		
		Utils.saveCustomConfig("challenges");
		
	}
	
	public static void resetNeed(Player pPlayer){
		needName.remove(pPlayer);
	}
	
	public static boolean isNeeded(Player pPlayer){
		return needName.contains(pPlayer);
	}
	
	
	public static String combineArgs(String[] args){
		
		String argsCombined = "";
		
		for (int i = 0; i < args.length; i++){
			argsCombined += args[i] + " ";
		}
		
		argsCombined = argsCombined.substring(0, argsCombined.length() - 1);
		
		return argsCombined;
		
	}
	
	public static String removeArgs(String pString, String[] args){
		
		for (String tmpArg : args){
			pString = pString.replaceFirst(tmpArg + " ", "");
		}
		
		return pString;
		
	}
	
	public static ItemStack[] sortItems(ItemStack[] pItemList){
		
		final Set<ItemStack> finalList = new HashSet<ItemStack>();
		final List<ItemStack> itemList = new ArrayList<ItemStack>();
		itemList.addAll(Arrays.asList(pItemList));
		
		while (itemList.size() != 0){
			
			ItemStack tmpItem = itemList.remove(0);
			
			if (tmpItem != null){
			
				int amount = tmpItem.getAmount();
				Iterator<ItemStack> it = itemList.iterator();
				
				while (it.hasNext()){
					
					ItemStack itemToCompare = it.next();
					
					if (tmpItem.isSimilar(itemToCompare)){
						amount += itemToCompare.getAmount();
						it.remove();
					}
										
				}
				
				tmpItem.setAmount(amount);
				finalList.add(tmpItem);
			
			}
			
		}
		
		return finalList.toArray(new ItemStack[finalList.size()]);
		
	}
	
	
	//Configs
	public static String getString(String pKey){
		return main.getMainConfig().getString(pKey);
	}
	
	public static void setValue(String pKey, Object pValue){
		main.getMainConfig().set(pKey, pValue);
	}
	
	public static boolean getBoolean(String pKey){
		return main.getMainConfig().getBoolean(pKey);
	}
	
	public static String getMessage(String pKey){
		return main.getCustomConfig("messages").getString(pKey);
	}
	
	public static List<String> getMessageList(String pKey){
		return main.getCustomConfig("messages").getStringList(pKey);
	}
	
	public static FileConfiguration getCustomConfig(String pConfig){
		return main.getCustomConfig("challenges");
	}
	
	public static void saveMainConfig(){
		main.saveConfig();
	}
	
	public static void saveCustomConfig(String pKey){
		try {
			main.getCustomConfig(pKey).save(new File(main.getDataFolder(), pKey + ".yml"));
		}
		catch (IOException e) {e.printStackTrace();}
	}
	
	/**
	 * Sauvegarde la config custom en utilisant l'encodage donné
	 * @param key Key associated to a config
	 * @param charset Charset to use
	 */
	public static void saveCustomConfig(String key, Charset charset) {
		
		FileConfiguration config = main.getCustomConfig(key);
		String configToString = config.saveToString();
		
		File configFile = new File(main.getDataFolder(), key + ".yml");
		OutputStreamWriter osw = null;
		try {
			
			FileOutputStream fis = new FileOutputStream(configFile);
			osw = new OutputStreamWriter(fis, charset);
			
			osw.write(configToString);
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
				osw.close();
			}
			
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	public static List<String> getCommandAliases(String pCmdName){
		return main.getCommand(pCmdName).getAliases();
	}
	
	/**
	 * Vérifie si la commande appelé correspond à la commande à vérifier.
	 * @param pLabel Nom de la commande tapé
	 * @param cmdName Nom de la commande à vérifier
	 * @return Vrai si la commande appelé correspond à la commande à vérifier, faux sinon.
	 */
	public static boolean isCommand(String pLabel, String pCmdName){
		
		if (pLabel.equalsIgnoreCase(pCmdName)) return true;
		
		for (String alias : Utils.getCommandAliases(pCmdName)){
			if (pLabel.equalsIgnoreCase(alias)){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Converti la chaine en minuscule, la première lettre en majuscule et transforme les underscore en espace
	 * @param string Chaîne à convertir
	 * @return converted Chaîne convertit
	 */
	public static String makesBeautiful(String string){
		
		char[] charsName = string.toLowerCase().toCharArray();
		charsName[0] = Character.toUpperCase(charsName[0]);
		String name = String.copyValueOf(charsName);
		
		return name.replaceAll("_", " ");
		
	}
	
	/**
	 * Crée une copie du tableau d'ItemStack donné en paramètre en changeant les références
	 * @param original Tableau à copier
	 * @return Tableau copié
	 */
	public static ItemStack[] deepCopy(ItemStack[] original){
		
		Set<ItemStack> itemSet = new HashSet<ItemStack>();
		
		for (ItemStack tmpItem : original){
			itemSet.add(tmpItem.clone());
		}
		
		return itemSet.toArray(new ItemStack[itemSet.size()]);
		
	}
	public static int getEntityPlayerStat(Player player, Statistic stat, EntityType entityType){
				
		String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		
		try {
			
			Class<?> entityTypesClass = Class.forName("net.minecraft.server." + version + ".EntityTypes");
			Map<?, ?> eggInfo = (Map<?, ?>) entityTypesClass.getField("eggInfo").get(null);
			@SuppressWarnings("deprecation")
			Object monsterEggInfo = eggInfo.get(Integer.valueOf(entityType.getTypeId()));
			Object statistic;
													
			if (stat.equals(Statistic.KILL_ENTITY))
				statistic = monsterEggInfo.getClass().getField("killEntityStatistic").get(monsterEggInfo);
			
			else
				statistic = monsterEggInfo.getClass().getField("e").get(monsterEggInfo);	
			
			Class<?> craftPlayerClass = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
			Object handle = craftPlayerClass.getMethod("getHandle").invoke(player);
			Object statisticManager = handle.getClass().getMethod("getStatisticManager").invoke(handle);
			return (int) statisticManager.getClass().getMethod("getStatisticValue", statistic.getClass()).invoke(statisticManager, statistic);
			
		} 
		
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		}
		
		return 0;
		
	}
	
}
