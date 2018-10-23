package fr.alphashadows77.dailychallenge;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.InputStreamReader;
import org.bukkit.plugin.java.JavaPlugin;

import fr.alphashadows77.dailychallenge.commands.AdminsCommands;

public class Main extends JavaPlugin {
	
	private static FileConfiguration mainConfig;
	private static FileConfiguration messagesConfig;
	
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
		
		//Main Config
		if (!new File(getDataFolder(), "config.yml").exists()){
			saveDefaultConfig();
			saveConfig();
		}
		
		mainConfig = getConfig();
		
		
		//Messages Config
		File messagesFile = new File(getDataFolder(), "messages.yml");
		if (!messagesFile.exists()){
			
			try {
				messagesFile.createNewFile();
				messagesConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(getResource("messages.yml")));
				messagesConfig.save(messagesFile);
			}
			catch (IOException e) {e.printStackTrace();}
			
		}
		
		else{
			messagesConfig = YamlConfiguration.loadConfiguration(messagesFile);
		}
		
	}
	
	protected FileConfiguration getMainConfig(){
		return mainConfig;
	}
	
	protected FileConfiguration getMessagesConfig(){
		return messagesConfig;
	}
	
}
