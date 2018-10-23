package fr.alphashadows77.dailychallenge;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import fr.alphashadows77.dailychallenge.commands.AdminsCommands;

public class Main extends JavaPlugin {
	
	private static FileConfiguration mainConfig;
	
	@Override
	public void onEnable(){
		
		//Config Loading
		loadConfig();
		
		//Main setting
		Utils.setMain(this);
		
		//Commands Registering
		getCommand("modifychallenge").setExecutor(new AdminsCommands());
		
	}
	
	private void loadConfig(){
		if (!new File(getDataFolder(), "config.yml").exists()){
			saveDefaultConfig();
			saveConfig();
		}
		
		mainConfig = getConfig();
	}
	
	protected FileConfiguration getMainConfig(){
		return mainConfig;
	}
	
}
