//
// Created by BONNe
// Copyright - 2021
//


package iskallia.vault.hook.jei;


import iskallia.vault.Vault;
import iskallia.vault.client.gui.screen.KeyPressScreen;
import iskallia.vault.container.KeyPressContainer;
import iskallia.vault.hook.jei.anvil.AnvilRecipeMaker;
import iskallia.vault.hook.jei.category.KeyPressCategory;
import iskallia.vault.init.ModBlocks;
import iskallia.vault.init.ModRecipes;
import iskallia.vault.recipe.KeyPressRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;


/**
 * This class adds and manages custom content in JEI.
 */
@JeiPlugin
public class JEIVaultHuntersPlugin implements IModPlugin
{
    /**
     * Vault Plugin Id.
     */
    @Override
    public ResourceLocation getPluginUid()
    {
        return Vault.id(Vault.MOD_ID);
    }


    /**
     * This method registers custom categories to the JEI.
     */
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration)
    {
        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registration.addRecipeCategories(
            keyPressCategory = new KeyPressCategory(guiHelper)
        );
    }


    /**
     * This method adds custom recipes to the JEI.
     */
    @Override
    public void registerRecipes(IRecipeRegistration registration)
    {
        IVanillaRecipeFactory vanillaRecipeFactory = registration.getVanillaRecipeFactory();
        registration.addRecipes(AnvilRecipeMaker.getAnvilRecipes(vanillaRecipeFactory), VanillaRecipeCategoryUid.ANVIL);
        registration.addRecipes(
            Minecraft.getInstance().world.getRecipeManager().getRecipesForType(ModRecipes.KEY_PRESS_RECIPE),
            Vault.id("key_press_recipe"));
    }


    /**
     * This method adds Key Press Recipes GUI handler to JEI.
     */
    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration)
    {
        registration.addRecipeClickArea(KeyPressScreen.class, 102, 48, 22, 15, Vault.id("key_press_recipe"));
    }


    /**
     * This method adds Key Press Recipes Transfer handler to JEI GUI.
     */
    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration)
    {
        registration.addRecipeTransferHandler(KeyPressContainer.class, Vault.id("key_press_recipe"), 0, 2, 3, 36);
    }


    /**
     * This method adds Key Press Recipes catalyst to JEI GUI.
     */
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration)
    {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.KEY_PRESS), Vault.id("key_press_recipe"));
    }

    /**
     * New category for the JEI.
     */
    private IRecipeCategory<KeyPressRecipe> keyPressCategory;
}