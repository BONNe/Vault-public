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
	 * List of custom defined boss names form which one will be chosen.
	 */
	@Expose public List<String> BOSS_LIST;

	/**
	 * Chance for a crystal to be a boss crystal.
	 */
	@Expose public float CHANCE;

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
