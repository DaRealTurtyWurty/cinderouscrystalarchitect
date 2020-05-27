package com.cinderous.crystalarchitect.util;

import com.cinderous.crystalarchitect.CrystalArchitect;
import com.cinderous.crystalarchitect.blocks.*;
import com.cinderous.crystalarchitect.items.CinderiteDust;
import com.cinderous.crystalarchitect.items.ItemBase;
import com.cinderous.crystalarchitect.world.biomes.CinderbaneBiome;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, CrystalArchitect.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }



    //Items
    public static final RegistryObject<Item> CINDERIUM_INGOT = ITEMS.register("cinderium_ingot", ItemBase::new);
    public static final RegistryObject<Item> CINDERITE_DUST = ITEMS.register("cinderite_dust", CinderiteDust::new);


    //blocks
    public static final RegistryObject<Block> CINDERIUM_BLOCK = BLOCKS.register("cinderium_block", CinderiumBlock::new);
    public static final RegistryObject<Block> CINDERITE_STONE = BLOCKS.register("cinderite_stone", CinderiteStone::new);
    public static final RegistryObject<Block> CINDERITE_MULCH = BLOCKS.register("cinderite_mulch", CinderiteMulch::new);

    public static final RegistryObject<Block> CINDIRT = BLOCKS.register("cindirt",
            () -> new Block(Block.Properties.from(Blocks.DIRT)));

    public static final RegistryObject<Block> CINDIRT_GRASS = BLOCKS.register("cindirt_grass",
            () -> new Block(Block.Properties.from(Blocks.GRASS_BLOCK)));





    public static final RegistryObject<Block> CINDERWOOD_PLANKS = BLOCKS.register("cinderwood_planks",
            () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> CINDERWOOD_LOG = BLOCKS.register("cinderwood_log",
            () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> CINDERWOOD_LEAVES = BLOCKS.register("cinderwood_leaves",
            () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> CINDERWOOD_SAPLING = BLOCKS.register("cinderwood_sapling",
            () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));


    //block items
    public static final RegistryObject<Item> CINDERIUM_BLOCK_ITEM = ITEMS.register("cinderium_block", () -> new BlockItemBase(CINDERIUM_BLOCK.get()));
    public static final RegistryObject<Item> CINDERITE_STONE_ITEM = ITEMS.register("cinderite_stone", () -> new BlockItemBase(CINDERITE_STONE.get()));
    public static final RegistryObject<Item> CINDERITE_MULCH_ITEM = ITEMS.register("cinderite_mulch", () -> new BlockItemBase(CINDERITE_MULCH.get()));
    public static final RegistryObject<Item> CINDIRT_ITEM = ITEMS.register("cindirt", () -> new BlockItemBase(CINDIRT.get()));
    public static final RegistryObject<Item> CINDIRT_GRASS_ITEM = ITEMS.register("cindirt_grass", () -> new BlockItemBase(CINDIRT_GRASS.get()));

    public static final RegistryObject<Item> CINDERWOOD_PLANKS_ITEM = ITEMS.register("cinderwood_planks", () -> new BlockItemBase(CINDERWOOD_PLANKS.get()));
    public static final RegistryObject<Item> CINDERWOOD_LOG_ITEM = ITEMS.register("cinderwood_log", () -> new BlockItemBase(CINDERWOOD_LOG.get()));
    public static final RegistryObject<Item> CINDERWOOD_LEAVES_ITEM = ITEMS.register("cinderwood_leaves", () -> new BlockItemBase(CINDERWOOD_LEAVES.get()));
    public static final RegistryObject<Item> CINDERWOOD_SAPLING_ITEM = ITEMS.register("cinderwood_sapling", () -> new BlockItemBase(CINDERWOOD_SAPLING.get()));

    //biomes
    public static final RegistryObject<Biome> CINDERBANE = BIOMES.register("cinderbane_biome",
            () -> new CinderbaneBiome(new Biome.Builder().precipitation(Biome.RainType.SNOW).scale(1.2f).temperature(0.5f)
                    .waterColor(16762304).waterFogColor(66762304)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    //RegistryHandler.CINDERITE_MULCH.get().getDefaultState(),
                                    Blocks.DIRT.getDefaultState(),
                                    Blocks.COARSE_DIRT.getDefaultState(),
                                    Blocks.GRANITE.getDefaultState()))
                    .category(Biome.Category.PLAINS)
                    .downfall(0.5f)
                    .depth(0.12f)
                    .parent(null)
            ));

    public static void registerBiomes(){
        registerBiome(CINDERBANE.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
    }

    public static void registerBiome(Biome biome, BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
