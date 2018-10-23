package fr.alphashadows77.dailychallenge;

public class Utils {
	
	//Variables
	private static Main main;
	
	protected static void setMain(Main pMain){
		main = pMain;
	}
	
	public static String getMessage(String pKey){
		return main.getMessagesConfig().getString(pKey);
	}
}
