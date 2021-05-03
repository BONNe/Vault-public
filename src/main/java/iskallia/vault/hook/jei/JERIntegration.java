//
// Created by BONNe
// Copyright - 2021
//


package iskallia.vault.hook.jei;


import java.util.List;

import iskallia.vault.Vault;
import iskallia.vault.init.ModBlocks;
import jeresources.api.IJERAPI;
import jeresources.api.IWorldGenRegistry;
import jeresources.api.JERPlugin;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.drop.LootDrop;
import jeresources.api.restrictions.DimensionRestriction;
import jeresources.api.restrictions.Restriction;
import jeresources.util.LootTableHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.util.ResourceLocation;


public class JERIntegration
{
    @JERPlugin
    public static IJERAPI jerAPI = null;


    public static void init()
    {
        if (jerAPI == null)
        {
            return;
        }

//        integrateMobs();
        integrateWorldGen();
    }


    private static void integrateWorldGen()
    {
        IWorldGenRegistry worldGenRegistry = jerAPI.getWorldGenRegistry();

        // Vault Gem Ores
        worldGenRegistry.register(new ItemStack(ModBlocks.ALEXANDRITE_ORE),
            new DistributionSquare(64, 3, 0, 256),
            new Restriction(new DimensionRestriction(Vault.VAULT_KEY)),
            true,
            getLootDropsFromResource(ModBlocks.ALEXANDRITE_ORE.getLootTable()));
        worldGenRegistry.register(new ItemStack(ModBlocks.BENITOITE_ORE),
            new DistributionSquare(64, 3, 0, 256),
            new Restriction(new DimensionRestriction(Vault.VAULT_KEY)),
            true,
            getLootDropsFromResource(ModBlocks.BENITOITE_ORE.getLootTable()));
        worldGenRegistry.register(new ItemStack(ModBlocks.LARIMAR_ORE),
            new DistributionSquare(64, 3, 0, 256),
            new Restriction(new DimensionRestriction(Vault.VAULT_KEY)),
            true,
            getLootDropsFromResource(ModBlocks.LARIMAR_ORE.getLootTable()));
        worldGenRegistry.register(new ItemStack(ModBlocks.BLACK_OPAL_ORE),
            new DistributionSquare(64, 3, 0, 256),
            new Restriction(new DimensionRestriction(Vault.VAULT_KEY)),
            true,
            getLootDropsFromResource(ModBlocks.BLACK_OPAL_ORE.getLootTable()));
        worldGenRegistry.register(new ItemStack(ModBlocks.PAINITE_ORE),
            new DistributionSquare(64, 3, 0, 256),
            new Restriction(new DimensionRestriction(Vault.VAULT_KEY)),
            true,
            getLootDropsFromResource(ModBlocks.PAINITE_ORE.getLootTable()));
        worldGenRegistry.register(new ItemStack(ModBlocks.ISKALLIUM_ORE),
            new DistributionSquare(64, 3, 0, 256),
            new Restriction(new DimensionRestriction(Vault.VAULT_KEY)),
            true,
            getLootDropsFromResource(ModBlocks.ISKALLIUM_ORE.getLootTable()));
        worldGenRegistry.register(new ItemStack(ModBlocks.RENIUM_ORE),
            new DistributionSquare(64, 3, 0, 256),
            new Restriction(new DimensionRestriction(Vault.VAULT_KEY)),
            true,
            getLootDropsFromResource(ModBlocks.RENIUM_ORE.getLootTable()));
        worldGenRegistry.register(new ItemStack(ModBlocks.GORGINITE_ORE),
            new DistributionSquare(64, 3, 0, 256),
            new Restriction(new DimensionRestriction(Vault.VAULT_KEY)),
            true,
            getLootDropsFromResource(ModBlocks.GORGINITE_ORE.getLootTable()));
        worldGenRegistry.register(new ItemStack(ModBlocks.SPARKLETINE_ORE),
            new DistributionSquare(64, 3, 0, 256),
            new Restriction(new DimensionRestriction(Vault.VAULT_KEY)),
            true,
            getLootDropsFromResource(ModBlocks.SPARKLETINE_ORE.getLootTable()));
        worldGenRegistry.register(new ItemStack(ModBlocks.WUTODIE_ORE),
            new DistributionSquare(64, 3, 0, 256),
            new Restriction(new DimensionRestriction(Vault.VAULT_KEY)),
            true,
            getLootDropsFromResource(ModBlocks.WUTODIE_ORE.getLootTable()));

        // Vault Rock Ore
        worldGenRegistry.register(new ItemStack(ModBlocks.VAULT_ROCK_ORE),
            new DistributionSquare(1, 1, 5, 11),
            true,
            getLootDropsFromResource(ModBlocks.VAULT_ROCK_ORE.getLootTable()));
    }


    private static LootDrop[] getLootDropsFromResource(ResourceLocation resourceLocation)
    {
        if (Minecraft.getInstance().world != null)
        {
            LootTableManager manager = jerAPI.getWorld().getServer().getLootTableManager();
            LootTable lootTable = manager.getLootTableFromLocation(resourceLocation);

            List<LootDrop> lootDrops = LootTableHelper.toDrops(lootTable);

            return lootDrops.toArray(new LootDrop[lootDrops.size()]);
        }
        else
        {
            return new LootDrop[0];
        }
    }

}
