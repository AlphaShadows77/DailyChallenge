package fr.alphashadows77.dailychallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;

import fr.alphashadows77.dailychallenge.challengestype.Challenge;
import fr.alphashadows77.dailychallenge.challengestype.ItemChallenge;
import fr.alphashadows77.dailychallenge.challengestype.StatChallenge;

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

		challengesConfig.set(frequency + "." + pChallenge.getName().toLowerCase().replaceAll(" ", "_").replaceAll("[^a-zA-Z0-9_]+", ""), pChallenge);

		saveCustomConfig(Utils.getCustomConfig("challenges"), new File(main.getDataFolder(), "challenges.yml"), StandardCharsets.UTF_8);

	}

	public static boolean challengeExists(Challenge pChallenge){

		FileConfiguration challengesConfig = main.getCustomConfig("challenges");

		if (challengesConfig.getConfigurationSection(pChallenge.getFrequency().toString().toLowerCase()) == null) {
			return false;
		}

		for (String tmpChallengeName : main.getCustomConfig("challenges").getConfigurationSection(pChallenge.getFrequency().toString().toLowerCase()).getKeys(false)){

			if (pChallenge.getName().toLowerCase().replaceAll(" ", "_").replaceAll("[^a-zA-Z0-9_]+", "").equals(tmpChallengeName))
				return true;

		}

		return false;

	}

	public static void changePeriodicChallenge(String frequency, String challengeName){

		FileConfiguration challengesConfig = Utils.getCustomConfig("challenges");

		challengesConfig.set(frequency + "now", challengeName.toLowerCase());
		challengesConfig.set(frequency + "success", null); //Mise à zéro des joueurs ayant réussi le challenge actuel
		challengesConfig.set(frequency + "playersstats", null); //Mise à zéro des stats enregistrées des joueurs pour les challenges statistiques

		Utils.saveCustomConfig(Utils.getCustomConfig("challenges"), new File(main.getDataFolder(), "challenges.yml"), StandardCharsets.UTF_8);

	}

	private static ItemStack createInfoItemMenu(String itemLabel, Object data) {

		Material mat = Material.getMaterial(getString("mc_info-item-" + itemLabel));

		ItemStack item = new ItemStack(mat, 1);

		ItemFactory itemFactory = Bukkit.getItemFactory();
		ItemMeta itemMeta = itemFactory.getItemMeta(mat);

		String dName = getMessage("info-" + itemLabel + "-item");

		if (data != null)
			dName = dName.replaceAll("%" + itemLabel + "%", data.toString());

		itemMeta.setDisplayName(getMessage("info-" + itemLabel + "-item"));

		item.setItemMeta(itemMeta);

		return item;

	}

	/**
	 * Allows to get the long name of a potion
	 * @param potion Potion to get the name
	 * @return The long name of a potion, an empty String if there is no potion effect
	 */
	public static String getPotionName(ItemStack potion) {
		String potionName = "";

		if (potion.hasItemMeta() && potion.getItemMeta() instanceof PotionMeta) {
			PotionMeta meta = (PotionMeta) potion.getItemMeta();
			PotionData potionData = meta.getBasePotionData();
			potionName = Utils.makesBeautiful(potionData.getType().toString());
			if (potionData.isUpgraded()) {
				potionName += " II";
			}

			if (potionData.isExtended()) {
				potionName += " (Extended)";
			}

		}

		return potionName;
	}

	public static Inventory getInfoMenu(Challenge challenge) {

		Inventory infoMenu = Bukkit.createInventory(null, 9, getMessage("info-title"));
		Gift challengeGifts = challenge.getGift();

		ItemStack needItem = createInfoItemMenu("need", null);
		ItemStack giftItem = createInfoItemMenu("gift", null);
		ItemStack moneyItem = createInfoItemMenu("money", challengeGifts.getMoney());
		ItemStack xpItem = createInfoItemMenu("xp", challengeGifts.getXp());

		infoMenu.setItem(0, needItem);
		infoMenu.setItem(1, giftItem);
		infoMenu.setItem(7, moneyItem);
		infoMenu.setItem(8, xpItem);

		return infoMenu;

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

	public static String getReadableStat(String readableStatPatern, Stat stat) {
		int amount = stat.getAmount();

		if (StatsWithItem.getValue(stat.getStat()).getUnit() != null) {

			switch (StatsWithItem.getValue(stat.getStat()).getUnit()) {
			case DISTANCE_CM:
				amount /= 100; // Conversion centi-blocs => blocs
				break;

			case TIME_TICK:
				amount /= 20; // Conversion ticks => secondes
				break;
			}

		}

		String tempLineLoreNeed = readableStatPatern.replaceAll("%amount%", Integer.toString(amount));
		String statName = StatsWithItem.getValue(stat.getStat()).getNom();
		if (stat.getData() != null)
			statName = statName.replaceAll("%data%", stat.getData().toString());
		statName = Utils.makesBeautiful(statName);
		tempLineLoreNeed = tempLineLoreNeed.replaceAll("%need%", statName);

		return tempLineLoreNeed;
	}

	public static void showStats(Player player, StatChallenge challenge) {

		String challengeName = challenge.getName();

		String statsInfoTitle = Utils.getMessage("stats-info-title")
									 .replaceAll("%challenge%", challengeName);

		player.sendMessage(statsInfoTitle);

		Stat[] stats = (Stat[]) challenge.getNeed();
		String statPatern = Utils.getMessage("stats-info-line");
		for (Stat stat : stats) {
			String readableStat = getReadableStat(statPatern, stat);
			player.sendMessage(readableStat);
		}
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

	public static ItemStack[] splitInStack(ItemStack[] itemList) {

		Set<ItemStack> splittedSet = new HashSet<ItemStack>();

		for (ItemStack tmpItem : itemList) {

			ItemStack clonedItem = tmpItem.clone();
			System.out.println("Avant = null : " + itemList.toString());
			tmpItem = null; // IL FAUT TEST DE PRINT itemList POUR VOIR SI ÇA A CHANGÉ MÊME SI FAUT PAS
			System.out.println("Après = null : " + itemList.toString());

			int itemAmount = clonedItem.getAmount();
			int maxStackSize = clonedItem.getMaxStackSize();

			while (itemAmount > maxStackSize) {

				ItemStack newStack = clonedItem.clone();
				newStack.setAmount(maxStackSize);
				splittedSet.add(newStack);
				itemAmount -= maxStackSize;
				clonedItem.setAmount(itemAmount);

			}

			if (itemAmount <= maxStackSize) {
				splittedSet.add(clonedItem);
			}

		}

		ItemStack[] splittedArray = splittedSet.toArray(new ItemStack[splittedSet.size()]);

		return splittedArray;

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
		return main.getCustomConfig(pConfig);
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
	 * @param config Key associated to a config
	 * @param charset Charset to use
	 */
	public static void saveCustomConfig(FileConfiguration config, File configFile, Charset charset) {

		String configToString = config.saveToString();

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

	private static Inventory getSubInfoMenu(ItemStack[] items) {
		String title = getMessage("info-title");
		Inventory menu = Bukkit.createInventory(null, 45, title);

		menu.addItem(items);
		ItemStack filler = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);
		for (int i = 36; i <= 43; i++) {
			menu.setItem(i, filler);
		}
		ItemStack exitButton = new ItemStack(Material.BARRIER, 1);

		menu.setItem(44, exitButton);

		return menu;
	}

	public static Inventory getNeedSubInfoMenu(ItemChallenge challenge) {
		ItemStack[] items = Utils.deepCopy((ItemStack[]) challenge.getNeed());
		ItemStack[] splitItems = Utils.splitInStack(items);

		return getSubInfoMenu(splitItems);
	}

	public static Inventory getGiftSubInfoMenu(Challenge challenge) {

		ItemStack[] items = Utils.deepCopy(challenge.getGift().getItemList());
		ItemStack[] splitItems = Utils.splitInStack(items);

		return getSubInfoMenu(splitItems);
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

	public static Stat[] deepCopy(Stat[] original) {

		Stat[] copiedStat = new Stat[original.length];

		for (int i = 0; i < original.length; i++) {
			copiedStat[i] = original[i].clone();
		}

		return copiedStat;

	}

}
