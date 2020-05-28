package com.cinderous.crystalarchitect.util.enums;

import com.cinderous.crystalarchitect.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModItemTiers implements IItemTier {

    // int harvestLevel, int maxUses, float efficiency, float attackDamage, int
    // enchantability, Supplier<Ingredient> repairMaterial
    //same harvest tier as wood
    SHARPENED_CINDERITE_ROCK_CONFIG(0, 30, 2.0F, 0.0F, 15, () -> {
        return Ingredient.fromItems(RegistryHandler.SHARPENED_CINDERITE_ROCK.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private ModItemTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
                         Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}