package fr.alphashadows77.dailychallenge;

import org.bukkit.Material;

//Énumération contenant tous les items ayant une data value
public enum ItemsWithData {
	//stone
	GRANITE(Material.STONE, (byte) 1),
	POLISHED_GRANITE(Material.STONE, (byte) 2),
	DIORITE(Material.STONE, (byte) 3),
	POLISHED_DIORITE(Material.STONE, (byte) 4),
	ANDESITE(Material.STONE, (byte) 5),
	POLISHED_ANDESITE(Material.STONE, (byte) 6),
	
	//dirt
	COARSE_DIRT(Material.DIRT, (byte) 1),
	PODZOL(Material.DIRT, (byte) 2),
	
	//planks
	SPRUCE_WOOD_PLANK(Material.WOOD, (byte) 1),
	BIRCH_WOOD_PLANK(Material.WOOD, (byte) 2),
	JUNGLE_WOOD_PLANK(Material.WOOD, (byte) 3),
	ACACIA_WOOD_PLANK(Material.WOOD, (byte) 4),
	DARK_OAK_WOOD_PLANK(Material.WOOD, (byte) 5),
	
	//sapling
	SPRUCE_SAPLING(Material.SAPLING, (byte) 1),
	BIRCH_SAPLING(Material.SAPLING, (byte) 2),
	JUGNLE_SAPLING(Material.SAPLING, (byte) 3),
	ACACIA_SAPLING(Material.SAPLING, (byte) 4),
	DARK_OAK_SAPLING(Material.SAPLING, (byte) 5),
	
	//sand
	RED_SAND(Material.SAND, (byte) 1),
	
	//log
	SPRUCE_WOOD(Material.LOG, (byte) 1),
	BIRCH_WOOD(Material.LOG, (byte) 2),
	JUNGLE_WOOD(Material.LOG, (byte) 3),
	
	//leaves
	SPRUCE_LEAVES(Material.LEAVES, (byte) 1),
	BIRCH_LEAVES(Material.LEAVES, (byte) 2),
	JUNGLE_LEAVES(Material.LEAVES, (byte) 3),
	
	//sponge
	WET_SPONGE(Material.SPONGE, (byte) 1),
	
	//sandstone
	CHISELED_SANDSTONE(Material.SANDSTONE, (byte) 1),
	SMOOTH_SANDSTONE(Material.SANDSTONE, (byte) 2),
	
	//tallgrass
	GRASS(Material.LONG_GRASS, (byte) 1),
	FERN(Material.LONG_GRASS, (byte) 2),
	
	//wool
	ORANGE_WOOL(Material.WOOL, (byte) 1),
	MAGENTA_WOOL(Material.WOOL, (byte) 2),
	LIGHT_BLUE_WOOL(Material.WOOL, (byte) 3),
	YELLOW_WOOL(Material.WOOL, (byte) 4),
	LIME_WOOL(Material.WOOL, (byte) 5),
	PINK_WOOL(Material.WOOL, (byte) 6),
	GRAY_WOOL(Material.WOOL, (byte) 7),
	LIGHT_GRAY_WOOL(Material.WOOL, (byte) 8),
	CYAN_WOOL(Material.WOOL, (byte) 9),
	PURPLE_WOOL(Material.WOOL, (byte) 10),
	BLUE_WOOL(Material.WOOL, (byte) 11),
	BROWN_WOOL(Material.WOOL, (byte) 12),
	GREEN_WOOL(Material.WOOL, (byte) 13),
	RED_WOOL(Material.WOOL, (byte) 14),
	BLACK_WOOL(Material.WOOL, (byte) 15),
	
	//red_flower
	BLUE_ORCHID(Material.RED_ROSE, (byte) 1),
	ALLIUM(Material.RED_ROSE, (byte) 2),
	AZURE_BLUET(Material.RED_ROSE, (byte) 3),
	RED_TULIP(Material.RED_ROSE, (byte) 4),
	ORANGE_TULIP(Material.RED_ROSE, (byte) 5),
	WHITE_TULIP(Material.RED_ROSE, (byte) 6),
	PINK_TULIP(Material.RED_ROSE, (byte) 7),
	OXEYE_DAISY(Material.RED_ROSE, (byte) 8),
	
	//stone_slab
	SANDSTONE_SLAB(Material.STEP, (byte) 1),
	COBBLESTONE_SLAB(Material.STEP, (byte) 3),
	BRICKS_SLAB(Material.STEP, (byte) 4),
	STONE_BRICKS_SLAB(Material.STEP, (byte) 5),
	NETHER_BRICK_SLAB(Material.STEP, (byte) 6),
	QUARTZ_SLAB(Material.STEP, (byte) 7),
	
	//stained_glass
	ORANGE_STAINED_GLASS(Material.STAINED_GLASS, (byte) 1),
	MAGENTA_STAINED_GLASS(Material.STAINED_GLASS, (byte) 2),
	LIGHT_BLUE_STAINED_GLASS(Material.STAINED_GLASS, (byte) 3),
	YELLOW_STAINED_GLASS(Material.STAINED_GLASS, (byte) 4),
	LIME_STAINED_GLASS(Material.STAINED_GLASS, (byte) 5),
	PINK_STAINED_GLASS(Material.STAINED_GLASS, (byte) 6),
	GRAY_STAINED_GLASS(Material.STAINED_GLASS, (byte) 7),
	LIGHT_GRAY_STAINED_GLASS(Material.STAINED_GLASS, (byte) 8),
	CYAN_STAINED_GLASS(Material.STAINED_GLASS, (byte) 9),
	PURPLE_STAINED_GLASS(Material.STAINED_GLASS, (byte) 10),
	BLUE_STAINED_GLASS(Material.STAINED_GLASS, (byte) 11),
	BROWN_STAINED_GLASS(Material.STAINED_GLASS, (byte) 12),
	GREEN_STAINED_GLASS(Material.STAINED_GLASS, (byte) 13),
	RED_STAINED_GLASS(Material.STAINED_GLASS, (byte) 14),
	BLACK_STAINED_GLASS(Material.STAINED_GLASS, (byte) 15),
	
	//monster_egg
	COBBLESTONE_MONSTER_EGG(Material.MONSTER_EGGS, (byte) 1),
	STONBE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, (byte) 2),
	MOSSY_STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, (byte) 3),
	CRACKED_STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, (byte) 4),
	CHISELED_STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, (byte) 5),
	
	//stonebrick
	MOSSY_STONE_BRICKS(Material.SMOOTH_BRICK, (byte) 1),
	CRACKED_STONE_BRICKS(Material.SMOOTH_BRICK, (byte) 2),
	CHISELED_STONE_BRICKS(Material.SMOOTH_BRICK, (byte) 3),
	
	//wooden_slab
	SPRUCE_WOOD_SLAB(Material.WOOD_STEP, (byte) 1),
	BIRCH_WOOD_SLAB(Material.WOOD_STEP, (byte) 2),
	JUNGLE_WOOD_SLAB(Material.WOOD_STEP, (byte) 3),
	ACACIA_WOOD_SLAB(Material.WOOD_STEP, (byte) 4),
	DARK_OAK_WOOD_SLAB(Material.WOOD_STEP, (byte) 5),
	
	//cobblestone_wall
	MOSSY_COBBLESTONE_WALL(Material.COBBLE_WALL, (byte) 1),
	
	//anvil
	SLIGHTLY_DAMAGED_ANVIL(Material.ANVIL, (byte) 1),
	VERY_DAMAGED_ANVIL(Material.ANVIL, (byte) 2),
	
	//quartz_block
	CHISELED_QUARTZ_BLOCK(Material.QUARTZ_BLOCK, (byte) 1),
	PILLAR_QUARTZ_BLOCK(Material.QUARTZ_BLOCK, (byte) 2),
	
	//stained_hardened_clay
	ORANGE_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 1),
	MAGENTA_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 2),
	LIGHT_BLUE_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 3),
	YELLOW_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 4),
	LIME_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 5),
	PINK_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 6),
	GRAY_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 7),
	LIGHT_GRAY_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 8),
	CYAN_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 9),
	PURPLE_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 10),
	BLUE_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 11),
	BROWN_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 12),
	GREEN_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 13),
	RED_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 14),
	BLACK_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (byte) 15),
	
	//stained_glass_pane
	ORANGE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 1),
	MAGENTA_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 2),
	LIGHT_BLUE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 3),
	YELLOW_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 4),
	LIME_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 5),
	PINK_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 6),
	GRAY_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 7),
	LIGHT_GRAY_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 8),
	CYAN_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 9),
	PURPLE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 10),
	BLUE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 11),
	BROWN_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 12),
	GREEN_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 13),
	RED_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 14),
	BLACK_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (byte) 15),
	
	//leaves2
	DARK_OAK_LEAVES(Material.LEAVES_2, (byte) 1),
	
	//log2
	DARK_OAK_WOOD(Material.LOG_2, (byte) 1),
	
	//prismarine
	PRISMARINE_BRICKS(Material.PRISMARINE, (byte) 1),
	DARK_PRISMARINE(Material.PRISMARINE, (byte) 2),
	
	//carpet
	ORANGE_CARPET(Material.CARPET, (byte) 1),
	MAGENTA_CARPET(Material.CARPET, (byte) 2),
	LIGHT_BLUE_CARPET(Material.CARPET, (byte) 3),
	YELLOW_CARPET(Material.CARPET, (byte) 4),
	LIME_CARPET(Material.CARPET, (byte) 5),
	PINK_CARPET(Material.CARPET, (byte) 6),
	GRAY_CARPET(Material.CARPET, (byte) 7),
	LIGHT_GRAY_CARPET(Material.CARPET, (byte) 8),
	CYAN_CARPET(Material.CARPET, (byte) 9),
	PURPLE_CARPET(Material.CARPET, (byte) 10),
	BLUE_CARPET(Material.CARPET, (byte) 11),
	BROWN_CARPET(Material.CARPET, (byte) 12),
	GREEN_CARPET(Material.CARPET, (byte) 13),
	RED_CARPET(Material.CARPET, (byte) 14),
	BLACK_CARPET(Material.CARPET, (byte) 15),
	
	//double_pant
	LILAC(Material.DOUBLE_PLANT, (byte) 1),
	DOUBLE_TALLGRASS(Material.DOUBLE_PLANT, (byte) 2),
	LARGE_FERN(Material.DOUBLE_PLANT, (byte) 3),
	ROSE_BUSH(Material.DOUBLE_PLANT, (byte) 4),
	PEONY(Material.DOUBLE_PLANT, (byte) 5),
	
	//red_sandstone
	CHISELED_RED_SANDSTONE(Material.RED_SANDSTONE, (byte) 1),
	SMOOTH_RED_SANDSTONE(Material.RED_SANDSTONE, (byte) 2),
	
	//coal
	CHARCOAL(Material.COAL, (byte) 1),
	
	//golden_apple
	ENCHANTED_GOLDEN_APPLE(Material.GOLDEN_APPLE, (byte) 1),
	
	//fish
	RAW_SALMON(Material.RAW_FISH, (byte) 1),
	CLOWNFISH(Material.RAW_FISH, (byte) 2),
	PUFFERFISH(Material.RAW_FISH, (byte) 3),
	
	//cooked_fish
	COOKED_SALMON(Material.COOKED_FISH, (byte) 1),
	
	//dye
	ROSE_RED(Material.INK_SACK, (byte) 1),
	CACTUS_GREEN(Material.INK_SACK, (byte) 2),
	COCOA_BEANS(Material.INK_SACK, (byte) 3),
	LAPIS_LAZULI(Material.INK_SACK, (byte) 4),
	PURPLE_DYE(Material.INK_SACK, (byte) 5),
	CYAN_DYE(Material.INK_SACK, (byte) 6),
	LIGHT_GRAY_DYE(Material.INK_SACK, (byte) 7),
	GRAY_DYE(Material.INK_SACK, (byte) 8),
	PINK_DYE(Material.INK_SACK, (byte) 9),
	LIME_DYE(Material.INK_SACK, (byte) 10),
	YELLOW_DYE(Material.INK_SACK, (byte) 11),
	LIGHT_BLUE_DYE(Material.INK_SACK, (byte) 12),
	MAGENTA_DYE(Material.INK_SACK, (byte) 13),
	ORANGE_DYE(Material.INK_SACK, (byte) 14),
	BONE_MEAL(Material.INK_SACK, (byte) 15),
	
	//potion
	POTION_OF_REGENERATION(Material.POTION, (byte) 8193),
	POTION_OF_SWIFTNESS(Material.POTION, (byte) 8194),
	POTION_OF_POISON(Material.POTION, (byte) 8196),
	POTION_OF_STRENGTH(Material.POTION, (byte) 8201),
	POTION_OF_LEAPING(Material.POTION, (byte) 8203),
	POTION_OF_REGENERATION_II(Material.POTION, (byte) 8225),
	POTION_OF_SWIFTNESS_II(Material.POTION, (byte) 8226),
	POTION_OF_FIRE_RESISTANCE(Material.POTION, (byte) 8227),
	POTION_OF_POISON_II(Material.POTION, (byte) 8228),
	POTION_OF_HEALING_II(Material.POTION, (byte) 8229),
	POTION_OF_NIGHT_VISION(Material.POTION, (byte) 8230),
	POTION_OF_WEAKNESS(Material.POTION, (byte) 8232),
	POTION_OF_STRENGTH_II(Material.POTION, (byte) 8233),
	POTION_OF_SLOWNESS(Material.POTION, (byte) 8234),
	POTION_OF_LEAPING_II(Material.POTION, (byte) 8235),
	POTION_OF_HARMING_II(Material.POTION, (byte) 8236),
	POTION_OF_WATER_BREATHING(Material.POTION, (byte) 8237),
	POTION_OF_INVISIBILITY(Material.POTION, (byte) 8238),
	POTION_OF_REGENERATION_LONG(Material.POTION, (byte) 8257),
	POTION_OF_SWIFTNESS_LONG(Material.POTION, (byte) 8258),
	POTION_OF_FIRE_RESISTANCE_LONG(Material.POTION, (byte) 8259),
	POTION_OF_POISON_LONG(Material.POTION, (byte) 8260),
	POTION_OF_HEALING(Material.POTION, (byte) 8261),
	POTION_OF_NIGHT_VISION_LONG(Material.POTION, (byte) 8262),
	POTION_OF_WEAKNESS_LONG(Material.POTION, (byte) 8264),
	POTION_OF_STRENGTH_LONG(Material.POTION, (byte) 8265),
	POTION_OF_SLOWNESS_LONG(Material.POTION, (byte) 8266),
	POTION_OF_LEAPING_LONG(Material.POTION, (byte) 8267),
	POTION_OF_HARMING(Material.POTION, (byte) 8268),
	POTION_OF_WATER_BREATHING_LONG(Material.POTION, (byte) 8269),
	POTION_OF_INVISIBILITY_LONG(Material.POTION, (byte) 8270),
	POTION_OF_REGENERATION_SPLASH(Material.POTION, (byte) 16385),
	POTION_OF_SWIFTNESS_SPLASH(Material.POTION, (byte) 16386),
	POTION_OF_POISON_SPLASH(Material.POTION, (byte) 16388),
	POTION_OF_STRENGTH_SPLASH(Material.POTION, (byte) 16393),
	POTION_OF_LEAPING_SPLASH(Material.POTION, (byte) 16395),
	POTION_OF_REGENERATION_II_SPLASH(Material.POTION, (byte) 16417),
	POTION_OF_SWIFTNESS_II_SPLASH(Material.POTION, (byte) 16418),
	POTION_OF_FIRE_RESISTANCE_SPLASH(Material.POTION, (byte) 16419),
	POTION_OF_POISON_II_SPLASH(Material.POTION, (byte) 16420),
	POTION_OF_HEALING_II_SPLASH(Material.POTION, (byte) 16421),
	POTION_OF_NIGHT_VISION_SPLASH(Material.POTION, (byte) 16422),
	POTION_OF_WEAKNESS_SPLASH(Material.POTION, (byte) 16424),
	POTION_OF_STRENGTH_II_SPLASH(Material.POTION, (byte) 16425),
	POTION_OF_SLOWNESS_SPLASH(Material.POTION, (byte) 16426),
	POTION_OF_LEAPING_II_SPLASH(Material.POTION, (byte) 16427),
	POTION_OF_HARMING_II_SPLASH(Material.POTION, (byte) 16428),
	POTION_OF_WATER_BREATHING_SPLASH(Material.POTION, (byte) 16429),
	POTION_OF_INVISIBILITY_SPLASH(Material.POTION, (byte) 16430),
	POTION_OF_REGENERATION_LONG_SPLASH(Material.POTION, (byte) 16449),
	POTION_OF_SWIFTNESS_LONG_SPLASH(Material.POTION, (byte) 16450),
	POTION_OF_FIRE_RESISTANCE_LONG_SPLASH(Material.POTION, (byte) 16451),
	POTION_OF_POISON_LONG_SPLASH(Material.POTION, (byte) 16452),
	POTION_OF_HEALING_SPLASH(Material.POTION, (byte) 16453),
	POTION_OF_NIGHT_VISION_LONG_SPLASH(Material.POTION, (byte) 16454),
	POTION_OF_WEAKNESS_LONG_SPLASH(Material.POTION, (byte) 16456),
	POTION_OF_STRENGTH_LONG_SPLASH(Material.POTION, (byte) 16457),
	POTION_OF_SLOWNESS_LONG_SPLASH(Material.POTION, (byte) 16458),
	POTION_OF_LEAPING_LONG_SPLASH(Material.POTION, (byte) 16459),
	POTION_OF_HARMING_SPLASH(Material.POTION, (byte) 16460),
	POTION_OF_WATER_BREATHING_LONG_SPLASH(Material.POTION, (byte) 16461),
	POTION_OF_INVISIBILITY_LONG_SPLASH(Material.POTION, (byte) 16462),
	
	//spawn_egg
	SPAWN_CREEPER(Material.MONSTER_EGG, (byte) 50),
	SPAWN_SKELETON(Material.MONSTER_EGG, (byte) 51),
	SPAWN_SPIDER(Material.MONSTER_EGG, (byte) 52),
	SPAWN_ZOMBIE(Material.MONSTER_EGG, (byte) 54),
	SPAWN_SLIME(Material.MONSTER_EGG, (byte) 55),
	SPAWN_GHAST(Material.MONSTER_EGG, (byte) 56),
	SPAWN_ZOMBIE_PIGMAN(Material.MONSTER_EGG, (byte) 57),
	SPAWN_ENDERMAN(Material.MONSTER_EGG, (byte) 58),
	SPAWN_CAVE_SPIDER(Material.MONSTER_EGG, (byte) 59),
	SPAWN_SILVERFISH(Material.MONSTER_EGG, (byte) 60),
	SPAWN_BLAZE(Material.MONSTER_EGG, (byte) 61),
	SPAWN_MAGMA_CUBE(Material.MONSTER_EGG, (byte) 62),
	SPAWN_BAT(Material.MONSTER_EGG, (byte) 65),
	SPAWN_WITCH(Material.MONSTER_EGG, (byte) 66),
	SPAWN_ENDERMITE(Material.MONSTER_EGG, (byte) 67),
	SPAWN_GUARDIAN(Material.MONSTER_EGG, (byte) 68),
	SPAWN_PIG(Material.MONSTER_EGG, (byte) 90),
	SPAWN_SHEEP(Material.MONSTER_EGG, (byte) 91),
	SPAWN_COW(Material.MONSTER_EGG, (byte) 92),
	SPAWN_CHICKEN(Material.MONSTER_EGG, (byte) 93),
	SPAWN_SQUID(Material.MONSTER_EGG, (byte) 94),
	SPAWN_WOLF(Material.MONSTER_EGG, (byte) 95),
	SPAWN_MOOSHROOM(Material.MONSTER_EGG, (byte) 96),
	SPAWN_OCELOT(Material.MONSTER_EGG, (byte) 98),
	SPAWN_HORSE(Material.MONSTER_EGG, (byte) 100),
	SPAWN_RABBIT(Material.MONSTER_EGG, (byte) 101),
	SPAWN_VILLAGER(Material.MONSTER_EGG, (byte) 120),

	//skull
	WITHER_SKELETON_SKULL(Material.SKULL_ITEM, (byte) 1),
	ZOMBIE_HEAD(Material.SKULL_ITEM, (byte) 2),
	HEAD(Material.SKULL_ITEM, (byte) 3),
	CREEPER_HEAD(Material.SKULL_ITEM, (byte) 4),
	
	//banner
	RED_BANNER(Material.BANNER, (byte) 1),
	GREEN_BANNER(Material.BANNER, (byte) 2),
	BROWN_BANNER(Material.BANNER, (byte) 3),
	BLUE_BANNER(Material.BANNER, (byte) 4),
	PURPLE_BANNER(Material.BANNER, (byte) 5),
	CYAN_BANNER(Material.BANNER, (byte) 6),
	LIGHT_GRAY_BANNER(Material.BANNER, (byte) 7),
	GRAY_BANNER(Material.BANNER, (byte) 8),
	PINK_BANNER(Material.BANNER, (byte) 9),
	LIME_BANNER(Material.BANNER, (byte) 10),
	YELLOW_BANNER(Material.BANNER, (byte) 11),
	LIGHT_BLUE_BANNER(Material.BANNER, (byte) 12),
	MAGENTA_BANNER(Material.BANNER, (byte) 13),
	ORANGE_BANNER(Material.BANNER, (byte) 14),
	WHITE_BANNER(Material.CARPET, (byte) 15);
	
	//Variables
	private Material material;
	private byte data;
	
	private ItemsWithData(Material pMaterial, byte pData){
		this.material = pMaterial;
		this.data = pData;
	}
	
	//Récupération du Material de l'item
	public Material getMaterial(){
		return this.material;
	}
	
	//Récupération de la data value de l'item
	public byte getData(){
		return this.data;
	}
	
	//Récupération du nom de l'item à partir du Material et de sa data value
	public static ItemsWithData getValue(Material pMaterial, short pData){
		for (ItemsWithData tempItem : ItemsWithData.values()){
			if (tempItem.getMaterial().equals(pMaterial) && tempItem.getData() == pData)
				return tempItem;
		}
		
		return null;
	}
	
	
}
