package fr.alphashadows77.dailychallenge;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private static FileConfiguration mainConfig;
	
	@Override
	public void onEnable(){
		
		//Config Loading
		loadConfig();
		
	}
	
	private void loadConfig(){
		if (!new File(getDataFolder(), "config.yml").exists()){
			saveDefaultConfig();
			saveConfig();
		}
		
		mainConfig = getConfig();
	}
	
}
