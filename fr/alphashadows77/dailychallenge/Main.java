package fr.alphashadows77.dailychallenge;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import fr.alphashadows77.dailychallenge.challengestype.Challenge;
import fr.alphashadows77.dailychallenge.challengestype.ItemChallenge;
import fr.alphashadows77.dailychallenge.commands.AdminsCommands;

public class Main extends JavaPlugin {
	
	private static FileConfiguration mainConfig;
	private static Map<String, FileConfiguration> customConfigs = new HashMap<String, FileConfiguration>();
		
	@Override
	public void onEnable(){
		
		//Config Loading
		loadConfig();
		
		//Main setting
		Utils.setMain(this);
		
		//Commands Registering
		getCommand("modifychallenge").setExecutor(new AdminsCommands());
		
		//Events Registering
		getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
		
	}
	
	private void loadConfig(){
		
		//Main Config
		if (!new File(getDataFolder(), "config.yml").exists()){
			saveDefaultConfig();
			saveConfig();
		}
		
		mainConfig = getConfig();
		
		//Custom configs
		addCustomConfig("messages");
		addCustomConfig("challenges");
		
		//Serialization registering
		ConfigurationSerialization.registerClass(Challenge.class);
		ConfigurationSerialization.registerClass(ItemChallenge.class);
		ConfigurationSerialization.registerClass(Gift.class);
		
	}
	
	protected FileConfiguration getMainConfig(){
		return mainConfig;
	}
	
	private void addCustomConfig(String pKey){
		
		FileConfiguration customConfig = null;
		File customFile = new File(getDataFolder(), pKey + ".yml");
		if (!customFile.exists()){
			
			try {
				customFile.createNewFile();
				customConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(getResource(pKey + ".yml")));
				customConfig.save(customFile);
			}
			catch (IOException e) {e.printStackTrace();}
			
		}
		
		else{
			customConfig = YamlConfiguration.loadConfiguration(customFile);
		}
		
		customConfigs.put(pKey, customConfig);
		
	}
	
	protected FileConfiguration getCustomConfig(String pKey){
		return customConfigs.get(pKey);
	}
	
}
