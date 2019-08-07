package fr.alphashadows77.dailychallenge;

import org.bukkit.Material;

//Énumération contenant tous les items ayant une data value
public enum ItemsWithData {
	//stone
	GRANITE(Material.STONE, (short) 1),
	POLISHED_GRANITE(Material.STONE, (short) 2),
	DIORITE(Material.STONE, (short) 3),
	POLISHED_DIORITE(Material.STONE, (short) 4),
	ANDESITE(Material.STONE, (short) 5),
	POLISHED_ANDESITE(Material.STONE, (short) 6),
	
	//dirt
	COARSE_DIRT(Material.DIRT, (short) 1),
	PODZOL(Material.DIRT, (short) 2),
	
	//planks
	SPRUCE_WOOD_PLANK(Material.WOOD, (short) 1),
	BIRCH_WOOD_PLANK(Material.WOOD, (short) 2),
	JUNGLE_WOOD_PLANK(Material.WOOD, (short) 3),
	ACACIA_WOOD_PLANK(Material.WOOD, (short) 4),
	DARK_OAK_WOOD_PLANK(Material.WOOD, (short) 5),
	
	//sapling
	SPRUCE_SAPLING(Material.SAPLING, (short) 1),
	BIRCH_SAPLING(Material.SAPLING, (short) 2),
	JUGNLE_SAPLING(Material.SAPLING, (short) 3),
	ACACIA_SAPLING(Material.SAPLING, (short) 4),
	DARK_OAK_SAPLING(Material.SAPLING, (short) 5),
	
	//sand
	RED_SAND(Material.SAND, (short) 1),
	
	//log
	SPRUCE_WOOD(Material.LOG, (short) 1),
	BIRCH_WOOD(Material.LOG, (short) 2),
	JUNGLE_WOOD(Material.LOG, (short) 3),
	
	//leaves
	SPRUCE_LEAVES(Material.LEAVES, (short) 1),
	BIRCH_LEAVES(Material.LEAVES, (short) 2),
	JUNGLE_LEAVES(Material.LEAVES, (short) 3),
	
	//sponge
	WET_SPONGE(Material.SPONGE, (short) 1),
	
	//sandstone
	CHISELED_SANDSTONE(Material.SANDSTONE, (short) 1),
	SMOOTH_SANDSTONE(Material.SANDSTONE, (short) 2),
	
	//tallgrass
	GRASS(Material.LONG_GRASS, (short) 1),
	FERN(Material.LONG_GRASS, (short) 2),
	
	//wool
	ORANGE_WOOL(Material.WOOL, (short) 1),
	MAGENTA_WOOL(Material.WOOL, (short) 2),
	LIGHT_BLUE_WOOL(Material.WOOL, (short) 3),
	YELLOW_WOOL(Material.WOOL, (short) 4),
	LIME_WOOL(Material.WOOL, (short) 5),
	PINK_WOOL(Material.WOOL, (short) 6),
	GRAY_WOOL(Material.WOOL, (short) 7),
	LIGHT_GRAY_WOOL(Material.WOOL, (short) 8),
	CYAN_WOOL(Material.WOOL, (short) 9),
	PURPLE_WOOL(Material.WOOL, (short) 10),
	BLUE_WOOL(Material.WOOL, (short) 11),
	BROWN_WOOL(Material.WOOL, (short) 12),
	GREEN_WOOL(Material.WOOL, (short) 13),
	RED_WOOL(Material.WOOL, (short) 14),
	BLACK_WOOL(Material.WOOL, (short) 15),
	
	//red_flower
	BLUE_ORCHID(Material.RED_ROSE, (short) 1),
	ALLIUM(Material.RED_ROSE, (short) 2),
	AZURE_BLUET(Material.RED_ROSE, (short) 3),
	RED_TULIP(Material.RED_ROSE, (short) 4),
	ORANGE_TULIP(Material.RED_ROSE, (short) 5),
	WHITE_TULIP(Material.RED_ROSE, (short) 6),
	PINK_TULIP(Material.RED_ROSE, (short) 7),
	OXEYE_DAISY(Material.RED_ROSE, (short) 8),
	
	//stone_slab
	SANDSTONE_SLAB(Material.STEP, (short) 1),
	COBBLESTONE_SLAB(Material.STEP, (short) 3),
	BRICKS_SLAB(Material.STEP, (short) 4),
	STONE_BRICKS_SLAB(Material.STEP, (short) 5),
	NETHER_BRICK_SLAB(Material.STEP, (short) 6),
	QUARTZ_SLAB(Material.STEP, (short) 7),
	
	//stained_glass
	ORANGE_STAINED_GLASS(Material.STAINED_GLASS, (short) 1),
	MAGENTA_STAINED_GLASS(Material.STAINED_GLASS, (short) 2),
	LIGHT_BLUE_STAINED_GLASS(Material.STAINED_GLASS, (short) 3),
	YELLOW_STAINED_GLASS(Material.STAINED_GLASS, (short) 4),
	LIME_STAINED_GLASS(Material.STAINED_GLASS, (short) 5),
	PINK_STAINED_GLASS(Material.STAINED_GLASS, (short) 6),
	GRAY_STAINED_GLASS(Material.STAINED_GLASS, (short) 7),
	LIGHT_GRAY_STAINED_GLASS(Material.STAINED_GLASS, (short) 8),
	CYAN_STAINED_GLASS(Material.STAINED_GLASS, (short) 9),
	PURPLE_STAINED_GLASS(Material.STAINED_GLASS, (short) 10),
	BLUE_STAINED_GLASS(Material.STAINED_GLASS, (short) 11),
	BROWN_STAINED_GLASS(Material.STAINED_GLASS, (short) 12),
	GREEN_STAINED_GLASS(Material.STAINED_GLASS, (short) 13),
	RED_STAINED_GLASS(Material.STAINED_GLASS, (short) 14),
	BLACK_STAINED_GLASS(Material.STAINED_GLASS, (short) 15),
	
	//monster_egg
	COBBLESTONE_MONSTER_EGG(Material.MONSTER_EGGS, (short) 1),
	STONBE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, (short) 2),
	MOSSY_STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, (short) 3),
	CRACKED_STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, (short) 4),
	CHISELED_STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, (short) 5),
	
	//stonebrick
	MOSSY_STONE_BRICKS(Material.SMOOTH_BRICK, (short) 1),
	CRACKED_STONE_BRICKS(Material.SMOOTH_BRICK, (short) 2),
	CHISELED_STONE_BRICKS(Material.SMOOTH_BRICK, (short) 3),
	
	//wooden_slab
	SPRUCE_WOOD_SLAB(Material.WOOD_STEP, (short) 1),
	BIRCH_WOOD_SLAB(Material.WOOD_STEP, (short) 2),
	JUNGLE_WOOD_SLAB(Material.WOOD_STEP, (short) 3),
	ACACIA_WOOD_SLAB(Material.WOOD_STEP, (short) 4),
	DARK_OAK_WOOD_SLAB(Material.WOOD_STEP, (short) 5),
	
	//cobblestone_wall
	MOSSY_COBBLESTONE_WALL(Material.COBBLE_WALL, (short) 1),
	
	//anvil
	SLIGHTLY_DAMAGED_ANVIL(Material.ANVIL, (short) 1),
	VERY_DAMAGED_ANVIL(Material.ANVIL, (short) 2),
	
	//quartz_block
	CHISELED_QUARTZ_BLOCK(Material.QUARTZ_BLOCK, (short) 1),
	PILLAR_QUARTZ_BLOCK(Material.QUARTZ_BLOCK, (short) 2),
	
	//stained_hardened_clay
	ORANGE_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 1),
	MAGENTA_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 2),
	LIGHT_BLUE_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 3),
	YELLOW_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 4),
	LIME_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 5),
	PINK_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 6),
	GRAY_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 7),
	LIGHT_GRAY_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 8),
	CYAN_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 9),
	PURPLE_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 10),
	BLUE_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 11),
	BROWN_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 12),
	GREEN_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 13),
	RED_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 14),
	BLACK_STAINED_HARDENED_CLAY(Material.STAINED_CLAY, (short) 15),
	
	//stained_glass_pane
	ORANGE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 1),
	MAGENTA_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 2),
	LIGHT_BLUE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 3),
	YELLOW_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 4),
	LIME_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 5),
	PINK_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 6),
	GRAY_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 7),
	LIGHT_GRAY_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 8),
	CYAN_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 9),
	PURPLE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 10),
	BLUE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 11),
	BROWN_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 12),
	GREEN_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 13),
	RED_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 14),
	BLACK_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 15),
	
	//leaves2
	DARK_OAK_LEAVES(Material.LEAVES_2, (short) 1),
	
	//log2
	DARK_OAK_WOOD(Material.LOG_2, (short) 1),
	
	//prismarine
	PRISMARINE_BRICKS(Material.PRISMARINE, (short) 1),
	DARK_PRISMARINE(Material.PRISMARINE, (short) 2),
	
	//carpet
	ORANGE_CARPET(Material.CARPET, (short) 1),
	MAGENTA_CARPET(Material.CARPET, (short) 2),
	LIGHT_BLUE_CARPET(Material.CARPET, (short) 3),
	YELLOW_CARPET(Material.CARPET, (short) 4),
	LIME_CARPET(Material.CARPET, (short) 5),
	PINK_CARPET(Material.CARPET, (short) 6),
	GRAY_CARPET(Material.CARPET, (short) 7),
	LIGHT_GRAY_CARPET(Material.CARPET, (short) 8),
	CYAN_CARPET(Material.CARPET, (short) 9),
	PURPLE_CARPET(Material.CARPET, (short) 10),
	BLUE_CARPET(Material.CARPET, (short) 11),
	BROWN_CARPET(Material.CARPET, (short) 12),
	GREEN_CARPET(Material.CARPET, (short) 13),
	RED_CARPET(Material.CARPET, (short) 14),
	BLACK_CARPET(Material.CARPET, (short) 15),
	
	//double_pant
	LILAC(Material.DOUBLE_PLANT, (short) 1),
	DOUBLE_TALLGRASS(Material.DOUBLE_PLANT, (short) 2),
	LARGE_FERN(Material.DOUBLE_PLANT, (short) 3),
	ROSE_BUSH(Material.DOUBLE_PLANT, (short) 4),
	PEONY(Material.DOUBLE_PLANT, (short) 5),
	
	//red_sandstone
	CHISELED_RED_SANDSTONE(Material.RED_SANDSTONE, (short) 1),
	SMOOTH_RED_SANDSTONE(Material.RED_SANDSTONE, (short) 2),
	
	//coal
	CHARCOAL(Material.COAL, (short) 1),
	
	//golden_apple
	ENCHANTED_GOLDEN_APPLE(Material.GOLDEN_APPLE, (short) 1),
	
	//fish
	RAW_SALMON(Material.RAW_FISH, (short) 1),
	CLOWNFISH(Material.RAW_FISH, (short) 2),
	PUFFERFISH(Material.RAW_FISH, (short) 3),
	
	//cooked_fish
	COOKED_SALMON(Material.COOKED_FISH, (short) 1),
	
	//dye
	ROSE_RED(Material.INK_SACK, (short) 1),
	CACTUS_GREEN(Material.INK_SACK, (short) 2),
	COCOA_BEANS(Material.INK_SACK, (short) 3),
	LAPIS_LAZULI(Material.INK_SACK, (short) 4),
	PURPLE_DYE(Material.INK_SACK, (short) 5),
	CYAN_DYE(Material.INK_SACK, (short) 6),
	LIGHT_GRAY_DYE(Material.INK_SACK, (short) 7),
	GRAY_DYE(Material.INK_SACK, (short) 8),
	PINK_DYE(Material.INK_SACK, (short) 9),
	LIME_DYE(Material.INK_SACK, (short) 10),
	YELLOW_DYE(Material.INK_SACK, (short) 11),
	LIGHT_BLUE_DYE(Material.INK_SACK, (short) 12),
	MAGENTA_DYE(Material.INK_SACK, (short) 13),
	ORANGE_DYE(Material.INK_SACK, (short) 14),
	BONE_MEAL(Material.INK_SACK, (short) 15),
	
	//potion
	POTION_OF_REGENERATION(Material.POTION, (short) 8193),
	POTION_OF_SWIFTNESS(Material.POTION, (short) 8194),
	POTION_OF_POISON(Material.POTION, (short) 8196),
	POTION_OF_STRENGTH(Material.POTION, (short) 8201),
	POTION_OF_LEAPING(Material.POTION, (short) 8203),
	POTION_OF_REGENERATION_II(Material.POTION, (short) 8225),
	POTION_OF_SWIFTNESS_II(Material.POTION, (short) 8226),
	POTION_OF_FIRE_RESISTANCE(Material.POTION, (short) 8227),
	POTION_OF_POISON_II(Material.POTION, (short) 8228),
	POTION_OF_HEALING_II(Material.POTION, (short) 8229),
	POTION_OF_NIGHT_VISION(Material.POTION, (short) 8230),
	POTION_OF_WEAKNESS(Material.POTION, (short) 8232),
	POTION_OF_STRENGTH_II(Material.POTION, (short) 8233),
	POTION_OF_SLOWNESS(Material.POTION, (short) 8234),
	POTION_OF_LEAPING_II(Material.POTION, (short) 8235),
	POTION_OF_HARMING_II(Material.POTION, (short) 8236),
	POTION_OF_WATER_BREATHING(Material.POTION, (short) 8237),
	POTION_OF_INVISIBILITY(Material.POTION, (short) 8238),
	POTION_OF_REGENERATION_LONG(Material.POTION, (short) 8257),
	POTION_OF_SWIFTNESS_LONG(Material.POTION, (short) 8258),
	POTION_OF_FIRE_RESISTANCE_LONG(Material.POTION, (short) 8259),
	POTION_OF_POISON_LONG(Material.POTION, (short) 8260),
	POTION_OF_HEALING(Material.POTION, (short) 8261),
	POTION_OF_NIGHT_VISION_LONG(Material.POTION, (short) 8262),
	POTION_OF_WEAKNESS_LONG(Material.POTION, (short) 8264),
	POTION_OF_STRENGTH_LONG(Material.POTION, (short) 8265),
	POTION_OF_SLOWNESS_LONG(Material.POTION, (short) 8266),
	POTION_OF_LEAPING_LONG(Material.POTION, (short) 8267),
	POTION_OF_HARMING(Material.POTION, (short) 8268),
	POTION_OF_WATER_BREATHING_LONG(Material.POTION, (short) 8269),
	POTION_OF_INVISIBILITY_LONG(Material.POTION, (short) 8270),
	POTION_OF_REGENERATION_SPLASH(Material.POTION, (short) 16385),
	POTION_OF_SWIFTNESS_SPLASH(Material.POTION, (short) 16386),
	POTION_OF_POISON_SPLASH(Material.POTION, (short) 16388),
	POTION_OF_STRENGTH_SPLASH(Material.POTION, (short) 16393),
	POTION_OF_LEAPING_SPLASH(Material.POTION, (short) 16395),
	POTION_OF_REGENERATION_II_SPLASH(Material.POTION, (short) 16417),
	POTION_OF_SWIFTNESS_II_SPLASH(Material.POTION, (short) 16418),
	POTION_OF_FIRE_RESISTANCE_SPLASH(Material.POTION, (short) 16419),
	POTION_OF_POISON_II_SPLASH(Material.POTION, (short) 16420),
	POTION_OF_HEALING_II_SPLASH(Material.POTION, (short) 16421),
	POTION_OF_NIGHT_VISION_SPLASH(Material.POTION, (short) 16422),
	POTION_OF_WEAKNESS_SPLASH(Material.POTION, (short) 16424),
	POTION_OF_STRENGTH_II_SPLASH(Material.POTION, (short) 16425),
	POTION_OF_SLOWNESS_SPLASH(Material.POTION, (short) 16426),
	POTION_OF_LEAPING_II_SPLASH(Material.POTION, (short) 16427),
	POTION_OF_HARMING_II_SPLASH(Material.POTION, (short) 16428),
	POTION_OF_WATER_BREATHING_SPLASH(Material.POTION, (short) 16429),
	POTION_OF_INVISIBILITY_SPLASH(Material.POTION, (short) 16430),
	POTION_OF_REGENERATION_LONG_SPLASH(Material.POTION, (short) 16449),
	POTION_OF_SWIFTNESS_LONG_SPLASH(Material.POTION, (short) 16450),
	POTION_OF_FIRE_RESISTANCE_LONG_SPLASH(Material.POTION, (short) 16451),
	POTION_OF_POISON_LONG_SPLASH(Material.POTION, (short) 16452),
	POTION_OF_HEALING_SPLASH(Material.POTION, (short) 16453),
	POTION_OF_NIGHT_VISION_LONG_SPLASH(Material.POTION, (short) 16454),
	POTION_OF_WEAKNESS_LONG_SPLASH(Material.POTION, (short) 16456),
	POTION_OF_STRENGTH_LONG_SPLASH(Material.POTION, (short) 16457),
	POTION_OF_SLOWNESS_LONG_SPLASH(Material.POTION, (short) 16458),
	POTION_OF_LEAPING_LONG_SPLASH(Material.POTION, (short) 16459),
	POTION_OF_HARMING_SPLASH(Material.POTION, (short) 16460),
	POTION_OF_WATER_BREATHING_LONG_SPLASH(Material.POTION, (short) 16461),
	POTION_OF_INVISIBILITY_LONG_SPLASH(Material.POTION, (short) 16462),
	
	//spawn_egg
	SPAWN_CREEPER(Material.MONSTER_EGG, (short) 50),
	SPAWN_SKELETON(Material.MONSTER_EGG, (short) 51),
	SPAWN_SPIDER(Material.MONSTER_EGG, (short) 52),
	SPAWN_ZOMBIE(Material.MONSTER_EGG, (short) 54),
	SPAWN_SLIME(Material.MONSTER_EGG, (short) 55),
	SPAWN_GHAST(Material.MONSTER_EGG, (short) 56),
	SPAWN_ZOMBIE_PIGMAN(Material.MONSTER_EGG, (short) 57),
	SPAWN_ENDERMAN(Material.MONSTER_EGG, (short) 58),
	SPAWN_CAVE_SPIDER(Material.MONSTER_EGG, (short) 59),
	SPAWN_SILVERFISH(Material.MONSTER_EGG, (short) 60),
	SPAWN_BLAZE(Material.MONSTER_EGG, (short) 61),
	SPAWN_MAGMA_CUBE(Material.MONSTER_EGG, (short) 62),
	SPAWN_BAT(Material.MONSTER_EGG, (short) 65),
	SPAWN_WITCH(Material.MONSTER_EGG, (short) 66),
	SPAWN_ENDERMITE(Material.MONSTER_EGG, (short) 67),
	SPAWN_GUARDIAN(Material.MONSTER_EGG, (short) 68),
	SPAWN_PIG(Material.MONSTER_EGG, (short) 90),
	SPAWN_SHEEP(Material.MONSTER_EGG, (short) 91),
	SPAWN_COW(Material.MONSTER_EGG, (short) 92),
	SPAWN_CHICKEN(Material.MONSTER_EGG, (short) 93),
	SPAWN_SQUID(Material.MONSTER_EGG, (short) 94),
	SPAWN_WOLF(Material.MONSTER_EGG, (short) 95),
	SPAWN_MOOSHROOM(Material.MONSTER_EGG, (short) 96),
	SPAWN_OCELOT(Material.MONSTER_EGG, (short) 98),
	SPAWN_HORSE(Material.MONSTER_EGG, (short) 100),
	SPAWN_RABBIT(Material.MONSTER_EGG, (short) 101),
	SPAWN_VILLAGER(Material.MONSTER_EGG, (short) 120),

	//skull
	WITHER_SKELETON_SKULL(Material.SKULL_ITEM, (short) 1),
	ZOMBIE_HEAD(Material.SKULL_ITEM, (short) 2),
	HEAD(Material.SKULL_ITEM, (short) 3),
	CREEPER_HEAD(Material.SKULL_ITEM, (short) 4),
	
	//banner
	RED_BANNER(Material.BANNER, (short) 1),
	GREEN_BANNER(Material.BANNER, (short) 2),
	BROWN_BANNER(Material.BANNER, (short) 3),
	BLUE_BANNER(Material.BANNER, (short) 4),
	PURPLE_BANNER(Material.BANNER, (short) 5),
	CYAN_BANNER(Material.BANNER, (short) 6),
	LIGHT_GRAY_BANNER(Material.BANNER, (short) 7),
	GRAY_BANNER(Material.BANNER, (short) 8),
	PINK_BANNER(Material.BANNER, (short) 9),
	LIME_BANNER(Material.BANNER, (short) 10),
	YELLOW_BANNER(Material.BANNER, (short) 11),
	LIGHT_BLUE_BANNER(Material.BANNER, (short) 12),
	MAGENTA_BANNER(Material.BANNER, (short) 13),
	ORANGE_BANNER(Material.BANNER, (short) 14),
	WHITE_BANNER(Material.CARPET, (short) 15);
	
	//Variables
	private Material material;
	private short data;
	
	private ItemsWithData(Material pMaterial, short pData){
		this.material = pMaterial;
		this.data = pData;
	}
	
	//Récupération du Material de l'item
	public Material getMaterial(){
		return this.material;
	}
	
	//Récupération de la data value de l'item
	public short getData(){
		return this.data;
	}
	
	//Récupération du nom de l'item à partir du Material et de sa data value
	public static ItemsWithData getValue(Material pMaterial, short pData){
		for (ItemsWithData tempItem : ItemsWithData.values()){
			if (tempItem.getMaterial().equals(pMaterial) && tempItem.getData() == pData)
				return tempItem;
		}
		
		System.out.println("Coucou");
		
		return null;
	}
	
	
}
