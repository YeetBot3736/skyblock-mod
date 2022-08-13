package com.potato.skyblock.mixin;

import com.potato.skyblock.SkyBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(LivingEntity.class)
public abstract class GrowthMixin {
	
	@Inject(at = @At("HEAD"), method = "tick()V")
	private void onEquipStack(CallbackInfo info) {
		LivingEntity entity = (LivingEntity)(Object)this;
		int helm = EnchantmentHelper.getLevel(SkyBlock.GROWTH,entity.getEquippedStack(EquipmentSlot.HEAD));
		int chest = EnchantmentHelper.getLevel(SkyBlock.GROWTH,entity.getEquippedStack(EquipmentSlot.CHEST));
		int leg = EnchantmentHelper.getLevel(SkyBlock.GROWTH,entity.getEquippedStack(EquipmentSlot.LEGS));
		int feet = EnchantmentHelper.getLevel(SkyBlock.GROWTH,entity.getEquippedStack(EquipmentSlot.FEET));
		SkyBlock.LOGGER.info("helmet value:" + helm + " \n chestplate value:" + chest +
				"\n leggings value:" + leg + "\n, boots value: " + feet + "\n");
		int x = helm + chest + leg + feet;
		x *= 3;
		SkyBlock.LOGGER.info("x = " + x + '\n');
		float maxH = entity.getMaxHealth();
		SkyBlock.LOGGER.info("max health rn = " + maxH);
		try {
			EntityAttributeModifier eam = new EntityAttributeModifier(UUID.randomUUID(), "Change Health Effect", x + 20 - maxH, EntityAttributeModifier.Operation.ADDITION);
			EntityAttributeInstance ai = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
			if (ai != null && x > 0) {
				ai.addTemporaryModifier(eam);
				entity.setHealth(entity.getHealth() / maxH * (x + 20));
			}
		}catch(Exception e){
			System.out.println("Bruh. An Error occurred somehow somewhere.");
		}
	}
}
