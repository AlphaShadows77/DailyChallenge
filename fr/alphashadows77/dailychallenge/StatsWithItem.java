package fr.alphashadows77.dailychallenge;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

//Association d'une statistique avec un nom et un item
public enum StatsWithItem {
	ANIMALS_BREAD(Statistic.ANIMALS_BRED, new ItemStack(Material.WHEAT, 1), Utils.getMessage("stat-animals_bread")),
	ARMOR_CLEANED(Statistic.ARMOR_CLEANED, new ItemStack(Material.LEATHER_CHESTPLATE, 1), Utils.getMessage("stat-armor_cleaned")),
	AVIATE_ONE_CM(Statistic.AVIATE_ONE_CM, new ItemStack(Material.ELYTRA, 1), Utils.getMessage("stat-aviate_one_cm"), UnitType.DISTANCE_CM),
	BANNER_CLEANED(Statistic.BANNER_CLEANED, new ItemStack(Material.BANNER, 1), Utils.getMessage("stat-banner_cleaned")),
	BEACON_INTERACTION(Statistic.BEACON_INTERACTION, new ItemStack(Material.BEACON, 1), Utils.getMessage("stat-beacon_interaction")),
	BOAT_ONE_CM(Statistic.BOAT_ONE_CM, new ItemStack(Material.BOAT, 1), Utils.getMessage("stat-boat_one_cm"), UnitType.DISTANCE_CM),
	BREWINGSTAND_INTERACTION(Statistic.BREWINGSTAND_INTERACTION, new ItemStack(Material.BREWING_STAND_ITEM, 1), Utils.getMessage("stat-brewingstand_interaction")),
	CAKE_SLICES_EATEN(Statistic.CAKE_SLICES_EATEN, new ItemStack(Material.CAKE, 1), Utils.getMessage("stat-cake_slices_eaten")),
	CAULDRON_FILLED(Statistic.CAULDRON_FILLED, new ItemStack(Material.CAULDRON_ITEM, 1), Utils.getMessage("stat-cauldron_filled")),
	CAULDRON_USED(Statistic.CAULDRON_USED, new ItemStack(Material.CAULDRON_ITEM, 1), Utils.getMessage("stat-cauldron_used")),
	CHEST_OPENED(Statistic.CHEST_OPENED, new ItemStack(Material.CHEST, 1), Utils.getMessage("stat-chest_opened")),
	CLIMB_ONE_CM(Statistic.CLIMB_ONE_CM, new ItemStack(Material.LADDER, 1), Utils.getMessage("stat-climb_one_cm"), UnitType.DISTANCE_CM),
	CRAFTING_TABLE_INTERACTION(Statistic.CRAFTING_TABLE_INTERACTION, new ItemStack(Material.WORKBENCH, 1), Utils.getMessage("stat-crafting_table_interaction")),
	CROUCH_ONE_CM(Statistic.CROUCH_ONE_CM, new ItemStack(Material.SOUL_SAND, 1), Utils.getMessage("stat-crouch_one_cm"), UnitType.DISTANCE_CM),
	DAMAGE_DEALT(Statistic.DAMAGE_DEALT, new ItemStack(Material.GOLD_SWORD, 1), Utils.getMessage("stat-damage_dealt")),
	DAMAGE_TAKEN(Statistic.DAMAGE_TAKEN, new ItemStack(Material.GOLD_CHESTPLATE, 1), Utils.getMessage("stat-damage_taken")),
	DEATHS(Statistic.DEATHS, new ItemStack(Material.SKULL_ITEM, 1, (short) 3), Utils.getMessage("stat-deaths")),
	DISPENSER_INSPECTED(Statistic.DISPENSER_INSPECTED, new ItemStack(Material.DISPENSER, 1), Utils.getMessage("stat-dispenser_inspected")),
	DIVE_ONE_CM(Statistic.DIVE_ONE_CM, new ItemStack(Material.WATER_BUCKET, 1), Utils.getMessage("stat-dive_one_cm"), UnitType.DISTANCE_CM),
	DROP(Statistic.DROP, new ItemStack(Material.DROPPER, 1), Utils.getMessage("stat-drop")),
	DROPPER_INSPECTED(Statistic.DROPPER_INSPECTED, new ItemStack(Material.DROPPER, 1), Utils.getMessage("stat-dropper_inspected")),
	ENDERCHEST_OPENED(Statistic.ENDERCHEST_OPENED, new ItemStack(Material.ENDER_CHEST, 1), Utils.getMessage("stat-enderchest_opened")),
	FALL_ONE_CM(Statistic.FALL_ONE_CM, new ItemStack(Material.FEATHER, 1), Utils.getMessage("stat-fall_one_cm"), UnitType.DISTANCE_CM),
	FISH_CAUGHT(Statistic.FISH_CAUGHT, new ItemStack(Material.FISHING_ROD, 1), Utils.getMessage("stat-fish_caught")),
	FLOWER_POTTED(Statistic.FLOWER_POTTED, new ItemStack(Material.FLOWER_POT_ITEM, 1), Utils.getMessage("stat-flower_potted")),
	FLY_ONE_CM(Statistic.FLY_ONE_CM, new ItemStack(Material.FEATHER, 1), Utils.getMessage("stat-fly_one_cm"), UnitType.DISTANCE_CM),
	FURNACE_INTERACTION(Statistic.FURNACE_INTERACTION, new ItemStack(Material.FURNACE, 1), Utils.getMessage("stat-furnace_interaction")),
	HOPPER_INSPECTED(Statistic.HOPPER_INSPECTED, new ItemStack(Material.HOPPER, 1), Utils.getMessage("stat-hopper_inspected")),
	HORSE_ONE_CM(Statistic.HORSE_ONE_CM, new ItemStack(Material.SADDLE, 1), Utils.getMessage("stat-horse_one_cm"), UnitType.DISTANCE_CM),
	ITEM_ENCHANTED(Statistic.ITEM_ENCHANTED, new ItemStack(Material.ENCHANTED_BOOK, 1), Utils.getMessage("stat-item_enchanted")),
	JUMP(Statistic.JUMP, new ItemStack(Material.SLIME_BLOCK, 1), Utils.getMessage("stat-jump")),
	LEAVE_GAME(Statistic.LEAVE_GAME, new ItemStack(Material.BARRIER, 1), Utils.getMessage("stat-leave_game")),
	MINECART_ONE_CM(Statistic.MINECART_ONE_CM, new ItemStack(Material.MINECART, 1), Utils.getMessage("stat-minecart_one_cm"), UnitType.DISTANCE_CM),
	MOB_KILLS(Statistic.MOB_KILLS, new ItemStack(Material.SKULL_ITEM, 1, (short) 2), Utils.getMessage("stat-mob_kills")),
	NOTEBLOCK_PLAYED(Statistic.NOTEBLOCK_PLAYED, new ItemStack(Material.NOTE_BLOCK, 1), Utils.getMessage("stat-noteblock_played")),
	NOTEBLOCK_TUNED(Statistic.NOTEBLOCK_TUNED, new ItemStack(Material.NOTE_BLOCK, 1), Utils.getMessage("stat-noteblock_tuned")),
	PICKUP(Statistic.PICKUP, new ItemStack(Material.HOPPER, 1), Utils.getMessage("stat-pickup")),
	PIG_ONE_CM(Statistic.PIG_ONE_CM, new ItemStack(Material.SADDLE, 1), Utils.getMessage("stat-pig_one_cm"), UnitType.DISTANCE_CM),
	PLAY_ONE_TICK(Statistic.PLAY_ONE_TICK, new ItemStack(Material.WATCH, 1), Utils.getMessage("stat-play_one_tick"), UnitType.TIME_TICK),
	PLAYER_KILLS(Statistic.PLAYER_KILLS, new ItemStack(Material.SKULL_ITEM, 1, (short) 3), Utils.getMessage("stat-player_kills")),
	RECORD_PLAYED(Statistic.RECORD_PLAYED, new ItemStack(Material.JUKEBOX, 1), Utils.getMessage("stat-record_played")),
	SKULKER_BOX_OPENED(Statistic.SHULKER_BOX_OPENED, new ItemStack(Material.PURPLE_SHULKER_BOX, 1), Utils.getMessage("stat-shulker_box_opened")),
	SLEEP_IN_BED(Statistic.SLEEP_IN_BED, new ItemStack(Material.BED, 1), Utils.getMessage("stat-sleep_in_bed")),
	SNEAK_TIME(Statistic.SNEAK_TIME, new ItemStack(Material.SOUL_SAND, 1), Utils.getMessage("stat-sneak_time"), UnitType.TIME_TICK),
	SPRINT_ONE_CM(Statistic.SPRINT_ONE_CM, removePotionLore(new ItemStack(Material.POTION, 1, (short) 8194)), Utils.getMessage("stat-sprint_one_cm"), UnitType.DISTANCE_CM),
	SWIM_ONE_CM(Statistic.SWIM_ONE_CM, new ItemStack(Material.WATER_BUCKET, 1), Utils.getMessage("stat-swim_one_cm"), UnitType.DISTANCE_CM),
	TALKED_TO_VILLAGER(Statistic.TALKED_TO_VILLAGER, new ItemStack(Material.EMERALD, 1), Utils.getMessage("stat-talked_to_villager")),
	TIME_SINCE_DEATH(Statistic.TIME_SINCE_DEATH, new ItemStack(Material.WATCH, 1), Utils.getMessage("stat-time_since_death")),
	TRADED_WITH_VILLAGER(Statistic.TRADED_WITH_VILLAGER, new ItemStack(Material.EMERALD, 1), Utils.getMessage("stat-traded_with_villager")),
	TRAPPED_CHEST_TRIGGERED(Statistic.TRAPPED_CHEST_TRIGGERED, new ItemStack(Material.TRAPPED_CHEST, 1), Utils.getMessage("stat-trapped_chest_triggered")),
	WALK_ONE_CM(Statistic.WALK_ONE_CM, new ItemStack(Material.GOLD_BOOTS, 1), Utils.getMessage("stat-walk_one_cm"), UnitType.DISTANCE_CM),
	
	MINE_BLOCK(Statistic.MINE_BLOCK, new ItemStack(Material.WOOD_PICKAXE, 1), Utils.getMessage("stat-mine_block")),
	USE_ITEM(Statistic.USE_ITEM, new ItemStack(Material.FLINT_AND_STEEL, 1), Utils.getMessage("stat-use_item")),
	BREAK_ITEM(Statistic.BREAK_ITEM, new ItemStack(Material.ANVIL, 1, (byte) 2), Utils.getMessage("stat-break_item")),
	CRAFT_ITEM(Statistic.CRAFT_ITEM, new ItemStack(Material.WORKBENCH, 1), Utils.getMessage("stat-craft_item")),
	KILL_ENTITY(Statistic.KILL_ENTITY, new ItemStack(Material.DIAMOND_SWORD, 1), Utils.getMessage("stat-kill_entity")),
	ENTITY_KILLED_BY(Statistic.ENTITY_KILLED_BY, new ItemStack(Material.SKULL_ITEM, 1, (byte) 3), Utils.getMessage("stat-entity_killed_by"));
	
	//Variables
	private Statistic stat;
	private ItemStack item;
	private String nom;
	private UnitType unit;
	
	private StatsWithItem(Statistic pStat, ItemStack pItem, String pNom){
		this.stat = pStat;
		this.item = pItem;
		this.nom = pNom;
	}
	
	private StatsWithItem(Statistic pStat, ItemStack pItem, String pNom, UnitType pUnit) {
		this.unit = pUnit;
	}
	
	//Retrait du Lore présent sur les potions
	private static ItemStack removePotionLore(ItemStack pItem){
		ItemMeta tempMeta = pItem.getItemMeta();
		tempMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		pItem.setItemMeta(tempMeta);
		return pItem;
	}
	
	public static StatsWithItem getValue(Statistic stat){
		return StatsWithItem.valueOf(stat.toString());
	}
	
	//Récupération de la statistique correspondant à une entrée de l'énumération
	public Statistic getStatistic(){
		return this.stat;
	}
	
	//Récupération de l'item correspondant à une entrée de l'énumération
	public ItemStack getItem(){
		return this.item;
	}
	
	//Récupération du nom correspondant à une entrée de l'énumération
	public String getNom(){
		return this.nom;
	}
	
	// Récupératoion de l'unité d'une entrée de l'énumération
	public UnitType getUnit() {
		return this.unit;
	}
}
