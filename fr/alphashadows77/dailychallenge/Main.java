package fr.alphashadows77.dailychallenge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import fr.alphashadows77.dailychallenge.challengestype.Challenge;
import fr.alphashadows77.dailychallenge.challengestype.ItemChallenge;
import fr.alphashadows77.dailychallenge.challengestype.StatChallenge;
import fr.alphashadows77.dailychallenge.commands.AdminsCommands;
import fr.alphashadows77.dailychallenge.commands.PlayersCommands;

public class Main extends JavaPlugin {
	
	private static FileConfiguration mainConfig;
	private static Map<String, FileConfiguration> customConfigs = new HashMap<String, FileConfiguration>();
		
	@Override
	public void onEnable() {
		
		//Main setting
		Utils.setMain(this);

		//Config Loading
		loadConfig();
		
		//Commands Registering
		getCommand("modifychallenge").setExecutor(new AdminsCommands());
		getCommand("dailychallenge").setExecutor(new PlayersCommands());
		getCommand("allowdailychallenge").setExecutor(new AdminsCommands());
		getCommand("forcechallenge").setExecutor(new AdminsCommands());
		
		//Events Registering
		getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
		
		// Sélection aléatoire des challenges périodiques
		Calendar calendar = Calendar.getInstance();
		FileConfiguration challengesConfig = getCustomConfig("challenges");
			
		// Vérification si c'est bien un reload quotidien et non ponctuel ou qu'aucun challenge journalier n'est défini
		if (calendar.get(Calendar.HOUR_OF_DAY) == 5 || calendar.get(Calendar.HOUR_OF_DAY) == 6){
			
			ConfigurationSection dailyConfig = challengesConfig.getConfigurationSection("daily");
			
			if (dailyConfig != null && !dailyConfig.getValues(false).isEmpty()) {
				randomNewChallenge("daily");
			}
			
			ConfigurationSection weeklyConfig = challengesConfig.getConfigurationSection("weekly");
			
			if (weeklyConfig != null && !weeklyConfig.getValues(false).isEmpty() && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				randomNewChallenge("weekly");
			}
			
			ConfigurationSection monthlyConfig = challengesConfig.getConfigurationSection("monthly");
			
			if (monthlyConfig != null && !monthlyConfig.getValues(false).isEmpty() && calendar.get(Calendar.DAY_OF_MONTH) == 1) {
				randomNewChallenge("monthly");
			}
		
		}
					
		Utils.saveCustomConfig(Utils.getCustomConfig("challenges"), new File(getDataFolder(), "challenges.yml"), StandardCharsets.UTF_8);
		
	}
	
	private void loadConfig(){
		
		//Serialization registering
		ConfigurationSerialization.registerClass(Challenge.class);
		ConfigurationSerialization.registerClass(ItemChallenge.class);
		ConfigurationSerialization.registerClass(StatChallenge.class);
		ConfigurationSerialization.registerClass(Gift.class);
		ConfigurationSerialization.registerClass(Stat.class);
		
		//Main Config
		if (!new File(getDataFolder(), "config.yml").exists()){
			saveDefaultConfig();
			saveConfig();
		}
		
		mainConfig = getConfig();

		//Custom configs
		addCustomConfig("messages");
		addCustomConfig("challenges");
		
	}
	
	protected FileConfiguration getMainConfig(){
		return mainConfig;
	}
	
	private void addCustomConfig(String pKey){
		
		FileConfiguration customConfig = new YamlConfiguration();
		File customFile = new File(getDataFolder(), pKey + ".yml");
		
		if (!customFile.exists()){
						
			if (getResource(pKey + ".yml") != null){
				
				try{
					customFile.createNewFile();
					customConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(getResource(pKey + ".yml"), StandardCharsets.UTF_8));
					Utils.saveCustomConfig(customConfig, customFile, StandardCharsets.UTF_8);
				}
				
				catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		else{
			
			try {
				FileInputStream fis = new FileInputStream(customFile);
				InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
				customConfig = YamlConfiguration.loadConfiguration(isr);
			}
			
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		customConfigs.put(pKey, customConfig);
				
	}
	
	protected FileConfiguration getCustomConfig(String pKey){
		return customConfigs.get(pKey);
	}
	
	private void randomNewChallenge(String frequency) {
		FileConfiguration challengesConfig = getCustomConfig("challenges");
		Set<String> challenges = new HashSet<String>();
		//Ajout de tous les challenges dans une liste
		for (String challenge : challengesConfig.getConfigurationSection(frequency).getValues(false).keySet()){
			challenges.add(challenge);
		}
		
		//Choix aléatoire d'un challenge et assignation comme challenge périodique
		int random = (int) (Math.random() * challenges.size());
			Utils.changePeriodicChallenge(frequency, challenges.toArray(new String[challenges.size()])[random]);
	}
	
}
