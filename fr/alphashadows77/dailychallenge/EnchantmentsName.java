package fr.alphashadows77.dailychallenge;

import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

public enum EnchantmentsName {

	ARROW_DAMAGE(Enchantment.ARROW_DAMAGE, "Power"),
	ARROW_FIRE(Enchantment.ARROW_FIRE, "Flame"),
	ARROW_INFINITE(Enchantment.ARROW_INFINITE, "Infinity"),
	ARROW_KNOCKBACK(Enchantment.ARROW_KNOCKBACK, "Punch"),
	BINDING_CURSE(Enchantment.BINDING_CURSE, "Curse of Binding"),
	DAMAGE_ALL(Enchantment.DAMAGE_ALL, "Sharpness"),
	DAMAGE_ARTHROPODS(Enchantment.DAMAGE_ARTHROPODS, "Bane Of Arthropods"),
	DAMAGE_UNDEAD(Enchantment.DAMAGE_UNDEAD, "Smite"),
	DEPTH_STRIDER(Enchantment.DEPTH_STRIDER, "Efficiency"),
	DIG_SPEED(Enchantment.DIG_SPEED, "Efficiency"),
	DURABILITY(Enchantment.DURABILITY, "Unbreaking"),
	FIRE_ASPECT(Enchantment.FIRE_ASPECT, "Fire Aspect"),
	FROST_WALKER(Enchantment.FROST_WALKER, "Forst Walker"),
	KNOCKBACK(Enchantment.KNOCKBACK, "Knockback"),
	LOOT_BONUS_BLOCKS(Enchantment.LOOT_BONUS_BLOCKS, "Fortune"),
	LOOT_BONUS_MOBS(Enchantment.LOOT_BONUS_MOBS, "Looting"),
	LUCK(Enchantment.LUCK, "Luck"),
	LURE(Enchantment.LURE, "Lure"),
	MENDING(Enchantment.MENDING, "Mending"),
	OXYGEN(Enchantment.OXYGEN, "Respiration"),
	PROTECTION_ENVIRONMENTAL(Enchantment.PROTECTION_ENVIRONMENTAL, "Protection"),
	PROTECTION_EXPLOSIONS(Enchantment.PROTECTION_EXPLOSIONS, "Blast Protection"),
	PROTECTION_FALL(Enchantment.PROTECTION_FALL, "Feather Falling"),
	PROTECTION_FIRE(Enchantment.PROTECTION_FIRE, "Fire Protection"),
	PROTECTION_PROJECTILE(Enchantment.PROTECTION_PROJECTILE, "Projectile Protection"),
	SILK_TOUCH(Enchantment.SILK_TOUCH, "Silk Touch"),
	SWEEPING_EDGE(Enchantment.SWEEPING_EDGE, "Sweeping Edge"),
	THORNS(Enchantment.THORNS, "Thorns"),
	VANISHING_CURSE(Enchantment.VANISHING_CURSE, "Curse of Vanishing"),
	WATER_WORKER(Enchantment.WATER_WORKER, "Aqua Infinity");
	
	private Enchantment ench;
	private String name;
	
	private EnchantmentsName(Enchantment ench, String name) {
		this.ench = ench;
		this.name = name;
	}
	
	public static String getName(Enchantment ench) {
		String enchName = ench.getName();
		for (EnchantmentsName tmpEnch : EnchantmentsName.values()) {
			if (tmpEnch.ench.getName().equals(enchName)) {
				return tmpEnch.name;
			}
		}
		
		return null;
	}
	
	/**
	 * Get the enchants names of an enchanted book or an enchanted item
	 * @param item The enchanted book/item
	 * @return List of the enchants names of the book/item
	 */
	public static String getEnchantsNames(ItemStack item) {
		String enchantsName = "";
		
		if (item.hasItemMeta()) {
			ItemMeta meta = item.getItemMeta();
			Map<Enchantment, Integer> enchants = null;
			if (meta instanceof EnchantmentStorageMeta) {
				EnchantmentStorageMeta enchantmentMeta = (EnchantmentStorageMeta) meta;
				if (enchantmentMeta.hasStoredEnchants()) {
					enchants = enchantmentMeta.getStoredEnchants();
				}
			}
			
			else if (meta.hasEnchants()){
				enchants = meta.getEnchants();
			}
			
			if (enchants != null) {
				for (Entry<Enchantment, Integer> tmp : enchants.entrySet()) {
					enchantsName += getName(tmp.getKey()) + tmp.getValue().toString() + ", ";
				}
						
				enchantsName = enchantsName.substring(0, enchantsName.length() - 2);
			}
		}
		
		return null;
	}
	
}
