package iskallia.vault.config;

import com.google.gson.annotations.Expose;
import java.util.Collections;
import java.util.List;


/**
 * This config allows to enable a chance to craft a crystal with a specific player name.
 * BOSS_LIST contains a names of players that can become a boss.
 * CHANCE is a float that allows to specify a chance for crystal to become a boss crystal.
 */
public class VaultBossesConfig extends Config {
	/**
	 * Variable that stores currently active pool mode.
	 */
	@Expose public Mode POOL_MODE;

	/**
	 * List of custom defined boss names form which one will be chosen.
	 */
	@Expose public List<String> BOSS_LIST;

	/**
	 * Chance for a crystal to be a boss crystal.
	 */
	@Expose public float CHANCE;

	/**
	 * Different modes for the raffle fighter choosing.
	 */
	public enum Mode {
		// The player who started the vault
		PLAYER,
		// Random player from online player list.
		ONLINE_PLAYERS,
		// Random player from whitelisted player list.
		WHITELIST,
		// Random player from given list.
		LIST
	}

	@Override
	public String getName() {
		return "vault_bosses";
	}

	@Override
	protected void reset() {
		CHANCE = 0.0f;
		BOSS_LIST = Collections.emptyList();
	}
}
