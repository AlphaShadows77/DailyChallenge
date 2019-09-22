package fr.alphashadows77.dailychallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import fr.alphashadows77.dailychallenge.challengestype.Challenge;

public class PlayerInfos {
	
	private Map<UUID, Challenge> usedChallenge;
	
	public PlayerInfos() {
		this.usedChallenge = new HashMap<UUID, Challenge>();
	}
	
	public void addPlayer(UUID uuid, Challenge challenge) {
		usedChallenge.put(uuid, challenge);
	}
	
	/**
	 * Allows to get the currently modified challenge by the player
	 * @param uuid UUID of the player
	 * @return Currently modified challenge or null if not found
	 */
	public Challenge getChallenge(UUID uuid) {
		
		if (!usedChallenge.containsKey(uuid)) {
			return null;
		}
		
		Challenge challenge = usedChallenge.get(uuid);
		
		return challenge;
		
	}
	
}
