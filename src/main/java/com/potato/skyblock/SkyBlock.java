package com.potato.skyblock;

import com.potato.skyblock.enchantment.GrowthEnchantment;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SkyBlock implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("SkyBlockMod");
	public static final Enchantment GROWTH = new GrowthEnchantment();

	@Override
	public void onInitialize() {
		Registry.register(Registry.ENCHANTMENT,new Identifier("skyblock","growth"), GROWTH);
		LOGGER.info("Skyblock Mod has initialised!");
	}
}
