package com.cookiecraft.enums;

import com.cookiecraft.item.CCItemRegistry;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum CookieCraftArmorMaterial implements IArmorMaterial {
	ARMOR_COOKIE("cookie_scale", 21, new int[]{3, 6, 7, 2}, 15, SoundEvents.BLOCK_IRON_DOOR_CLOSE, 0.5F, () -> Ingredient.fromItems(CCItemRegistry.COOKIE_INGOT.get()));

	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
	private final String name;
	private final int durability;
	private final int[] damageReduction;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final Supplier<Ingredient> repairMaterial;

	CookieCraftArmorMaterial(String name, int durability, int damageReduction[], int enchantability, SoundEvent sound, float toughness, Supplier<Ingredient> repairMaterial) {
		this.name = name;
		this.durability = durability;
		this.damageReduction = damageReduction;
		this.enchantability = enchantability;
		this.equipSound = sound;
		this.toughness = toughness;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * durability;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return damageReduction[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return equipSound;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return repairMaterial.get();
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getToughness() {
		return toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.0F; //Discuss use in other sets
	}
}
