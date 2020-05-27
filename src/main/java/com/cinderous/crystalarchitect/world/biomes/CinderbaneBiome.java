package com.cinderous.crystalarchitect.world.biomes;

import com.cinderous.crystalarchitect.world.feature.CinderwoodTree;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class CinderbaneBiome extends Biome {
    public CinderbaneBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 40,5,10));
        addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.04f)));
        //addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(128))));

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.NORMAL_TREE.withConfiguration(CinderwoodTree.CINDERWOOD_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1f, 1))));

        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addSparseGrass(this);
    }
}
