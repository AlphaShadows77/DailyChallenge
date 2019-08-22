package fr.alphashadows77.dailychallenge;

import org.bukkit.enchantments.Enchantment;

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
	
}
