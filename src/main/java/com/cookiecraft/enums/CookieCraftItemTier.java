package com.cookiecraft.enums;

import com.cookiecraft.item.CCItemRegistry;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum CookieCraftItemTier implements IItemTier {
	// harvestLevel, maxUses, efficiency, damage, enchantability
	//TOOL_IRONWOOD(2, 512, 6.5F, 2, 25, () -> Ingredient.fromItems(TFItems.ironwood_ingot.get())),
	TOOL_COOKIE(0, 1, 1.0F, 36.0F, 30, () -> Ingredient.fromItems(CCItemRegistry.COOKIE_INGOT.get()));

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final Supplier<Ingredient> repairMaterial;

	CookieCraftItemTier(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, Supplier<Ingredient> repairMaterial) {
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = damage;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getHarvestLevel() {
		return harvestLevel;
	}

	@Override
	public int getMaxUses() {
		return maxUses;
	}

	@Override
	public float getEfficiency() {
		return efficiency;
	}

	@Override
	public float getAttackDamage() {
		return attackDamage;
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return repairMaterial.get();
	}

}
