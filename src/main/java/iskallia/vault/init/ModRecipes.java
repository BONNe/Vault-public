package iskallia.vault.init;

import iskallia.vault.Vault;
import iskallia.vault.recipe.KeyPressRecipe;
import iskallia.vault.recipe.UpgradeCrystalRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;


/**
 * This class loads custom Vault Recipes.
 */
public class ModRecipes
{
	/**
	 * Key Press Recipe Type class.
	 */
	public static final IRecipeType<KeyPressRecipe> KEY_PRESS_RECIPE = new IRecipeType<KeyPressRecipe>()
	{
		@Override
		public String toString()
		{
			return Vault.id("key_press_recipe").toString();
		}
	};


	/**
	 * Key Press Recipe Type class.
	 */
	public static final IRecipeType<UpgradeCrystalRecipe> UPGRADE_CRYSTAL_RECIPE = new IRecipeType<UpgradeCrystalRecipe>()
	{
		@Override
		public String toString()
		{
			return Vault.id("crystal_crafting").toString();
		}
	};


	/**
	 * 	Vanilla has a registry for recipe types, but it does not actively use this registry.
	 * 	While this makes registering your recipe type an optional step, I recommend
	 * 	registering it anyway to allow other mods to discover your custom recipe types.
	 * @param event registry event.
	 */
	public static void registerRecipes(RegistryEvent.Register<IRecipeSerializer<?>> event)
	{
		Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(KEY_PRESS_RECIPE.toString()), KEY_PRESS_RECIPE);
		event.getRegistry().register(KeyPressRecipe.SERIALIZER);

		Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(UPGRADE_CRYSTAL_RECIPE.toString()), UPGRADE_CRYSTAL_RECIPE);
		event.getRegistry().register(UpgradeCrystalRecipe.SERIALIZER);
	}
}
